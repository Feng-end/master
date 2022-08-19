package com.witsky.website.web.log;


import com.witsky.website.web.wrapper.CacheBodyHttpServletRequest;
import org.slf4j.*;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Kun Yang on 2018/8/3.
 */
public class HttpServletRequestWrapperFilter extends OncePerRequestFilter {

    private static final String LOGGER_NAME = "messageLogger";

    private static final Logger MESSAGE_LOGGER = LoggerFactory.getLogger(LOGGER_NAME);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        MDC.clear();
        MDC.put("trade_id", UUID.randomUUID().toString().replaceAll("-", ""));
        // 初始化 parameter map
        request.getParameterMap();
        CacheBodyHttpServletRequest wrapperRequest = new CacheBodyHttpServletRequest(request);
        ContentCachingResponseWrapper wrapperResponse = new ContentCachingResponseWrapper(response);
        HttpLogger.onLog(MESSAGE_LOGGER, wrapperRequest);
        filterChain.doFilter(wrapperRequest, wrapperResponse);
        HttpLogger.onLog(MESSAGE_LOGGER, wrapperRequest, wrapperResponse);
        wrapperResponse.copyBodyToResponse();
        ControllerLogger.removeLogger();
    }

}
