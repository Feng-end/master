package com.witsky.website.web.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public abstract class AnnotationRequiredInterceptor<A extends Annotation>  implements HandlerInterceptor {

    private Class<A> annotationClass;

    public AnnotationRequiredInterceptor(Class<A> annotationClass) {
        this.annotationClass = annotationClass;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod){
            HandlerMethod handlerMethod =(HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            A annotation = method.getAnnotation(this.annotationClass);
            if (annotation!=null) {
                return this.doInterceptor(request, response, annotation, handler);
            }
            Object value = handlerMethod.getBean();
            annotation = value.getClass().getAnnotation(this.annotationClass);
            if (annotation != null) {
                return this.doInterceptor(request, response, annotation, handler);
            }
            return true;
        }else {
            return true;
        }
    }


    protected abstract boolean doInterceptor(HttpServletRequest request, HttpServletResponse response, A annotation, Object handler) throws Exception;

}
