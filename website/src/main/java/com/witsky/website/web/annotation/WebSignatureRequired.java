package com.witsky.website.web.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface WebSignatureRequired {

    String[] invokers();

    /**
     * 请求超时时间
     *
     * @return
     */
    long authTimeout() default 30000;

}
