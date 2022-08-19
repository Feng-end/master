package com.witsky.website.web.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author YSJ
 * @date 2022/01/06 14:48
 */
public class SendMessageUtil {

    private static ObjectMapper mapper=new ObjectMapper();

    /**
     * 将某个对象转换成json格式并发送到客户端
     *
     * @param response
     * @param obj
     * @throws Exception
     */
    public static void sendJsonMessage(HttpServletResponse response, Object obj)  {
        response.setContentType("application/json; charset=utf-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.print(mapper.writeValueAsString(obj));
            writer.close();
            response.flushBuffer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
