package com.witsky.website.web.log;

import cn.hutool.core.io.IoUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.*;
import org.springframework.web.util.*;

import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.util.function.Consumer;

import static java.nio.charset.StandardCharsets.*;

/**
 * Created by Kun Yang on 2018/8/3.
 */
public class HttpLogger {

    private static final String SPLIT_STRING_M = "=";

    private static final String BODY_ELLIPSIS = "......";

    private static final String SPLIT_STRING_DOT = "&";

    private static final int LOG_MAX_BODY_SIZE = 4096;

    public static void onLog(Logger logger, HttpServletRequest request) {
        try {
            String uri = request.getRequestURI();
            if (StringUtils.startsWith(uri, "/actuator")) {
                return;
            }
            String params = request.getQueryString();
            String body = getRequestBody(request);
            String headers = getRequestHeaders(request);
            String more = "";
            if (body.length() > LOG_MAX_BODY_SIZE) {
                body = body.substring(0, LOG_MAX_BODY_SIZE);
                more = BODY_ELLIPSIS;
            }
            MDC.put(MDCConstants.HTTP_MSG_TYPE, "Request");
            MDC.put(MDCConstants.HTTP_METHOD, request.getMethod());
            MDC.put(MDCConstants.HTTP_HEADERS, headers);
            MDC.put(MDCConstants.HTTP_QUERY, request.getQueryString());
            MDC.put(MDCConstants.HTTP_URL, request.getRequestURL().toString());
            MDC.put(MDCConstants.HTTP_PATH, request.getRequestURI());
            if (StringUtils.isBlank(request.getQueryString())) {
                logger.info("[Http 请求] {} {} | params : {} | headers {} | requestBody : {}{}",
                        request.getMethod(), uri, params, headers, StringUtils.trim(body), more);
            } else {
                logger.info("[Http 请求] {} {}?{} | params : {} | headers {} | requestBody : {}{}",
                        request.getMethod(), uri, request.getQueryString(), params, headers, StringUtils.trim(body), more);
            }
        } catch (IOException e) {
            logger.error("onLog failed", e);
        }
    }

    public static void onLog(Logger logger, HttpServletRequest request, HttpServletResponse response) {
        ContentCachingResponseWrapper respondWrapper = WebUtils.getNativeResponse(response, ContentCachingResponseWrapper.class);
        if (respondWrapper == null) {
            return;
        }
        String uri = request.getRequestURI();
        if (StringUtils.startsWith(uri, "/actuator")) {
            return;
        }
        MDC.put(MDCConstants.TRADE_ID, "Response");
        MDC.put(MDCConstants.HTTP_STATUS, response.getStatus() + "");
        if (response.getStatus() == 302) {
            logger.info("[Http 响应] {} {} | HttpStatus : {} | redirect => {}", request.getMethod(), uri,
                    response.getStatus(), response.getHeader("Location"));
        } else {
            String body = getResponseBody(respondWrapper);
            String more = "";
            if (body.length() > LOG_MAX_BODY_SIZE) {
                body = body.substring(0, LOG_MAX_BODY_SIZE);
                more = BODY_ELLIPSIS;
            }
            logger.info("[Http 响应] {} {} | HttpStatus : {} | responseBody : {}{}", request.getMethod(), uri,
                    response.getStatus(), body, more);
        }
    }

    private static void log(Consumer<Logger> consumer, Logger... loggers) {
        for (Logger logger : loggers) {
            consumer.accept(logger);
        }
    }

    /**
     * 打印请求参数
     *
     * @param request
     */
    private static String getRequestBody(HttpServletRequest request) throws IOException {
        if (request != null) {
            try (InputStream stream = request.getInputStream()) {
                String body = IoUtil.read(stream, false).toString();
                if (StringUtils.isNotBlank(body)) {
                    return body.replaceAll("\\n", "");
                }
            }
        }
        return "";
    }

    /**
     * 打印请求参数
     *
     * @param response
     */
    private static String getResponseBody(ContentCachingResponseWrapper response) {
        if (response != null) {
            byte[] buf = response.getContentAsByteArray();
            if (buf.length > 0) {
                String payload;
                payload = new String(buf, 0, buf.length, UTF_8);
                return payload;
            }
        }
        return "";
    }

    /**
     * 获取请求地址上的参数
     *
     * @param request
     * @return
     */
    private static String getRequestParams(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        Enumeration<String> enu = request.getParameterNames();
        //获取请求参数
        while (enu.hasMoreElements()) {
            String name = enu.nextElement();
            sb.append(name).append(SPLIT_STRING_M).append(request.getParameter(name));
            if (enu.hasMoreElements()) {
                sb.append(SPLIT_STRING_DOT);
            }
        }
        return sb.toString();
    }

    private static String getRequestHeaders(HttpServletResponse response) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> headerNames = response.getHeaderNames().iterator();
        while (headerNames.hasNext()) {
            String headerName = headerNames.next();
            sb.append("[").append(headerName).append(SPLIT_STRING_M).append(response.getHeader(headerName)).append("]");
            if (headerNames.hasNext()) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    private static String getRequestHeaders(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            sb.append("[").append(headerName).append(SPLIT_STRING_M).append(request.getHeader(headerName)).append("]");
            if (headerNames.hasMoreElements()) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

}
