package com.varNcrement.bookingservice.commons.config;

import com.varNcrement.bookingservice.commons.interceptor.ContextBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    ContextBuilder contextBuilder;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(contextBuilder);
    }
}
