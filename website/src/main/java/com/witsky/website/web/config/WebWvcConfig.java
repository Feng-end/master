package com.witsky.website.web.config;

import com.witsky.website.web.log.HttpServletRequestWrapperFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author YSJ
 * @date 2022/02/21 14:35
 */
@Configuration
public class WebWvcConfig  implements WebMvcConfigurer {

    @Bean
    public FilterRegistrationBean<HttpServletRequestWrapperFilter> httpServletRequestWrapperFilterRegistrationBean() {
        FilterRegistrationBean<HttpServletRequestWrapperFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new HttpServletRequestWrapperFilter());
        filterRegistrationBean.setName("httpServletRequestWrapperFilter");
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);//order的数值越小 则优先级越高
        return filterRegistrationBean;
    }

}
