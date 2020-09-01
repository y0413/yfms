package com.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Component
public class Config implements WebMvcConfigurer {
    @Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/files/**").addResourceLocations("file:" + UPLOAD_FOLDER);
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
