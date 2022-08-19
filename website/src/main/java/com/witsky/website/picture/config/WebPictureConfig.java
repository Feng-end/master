package com.witsky.website.picture.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.*;

import javax.servlet.MultipartConfigElement;

/**
 * @author YSJ
 * @date 2022/07/20 17:21
 */
public class WebPictureConfig implements WebMvcConfigurer {

    /**
     * 在配置文件中配置的文件保存路径
     */
    @Value("${img.location}")
    private String location;


    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大KB,MB
        // factory.setMaxFileSize("2MB");
        //设置总上传数据总大小
        // factory.setMaxRequestSize("10MB");
        return factory.createMultipartConfig();
    }

}
