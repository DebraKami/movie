package com.nsu.movie2023.config;

import com.nsu.movie2023.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    };

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor());
        registration.addPathPatterns(
                "/addtocart","/tocart","/toorder","/delcart","/order","/orderlist"
        );
        registration.excludePathPatterns(
                "/login",
                "/tologin",
                "/checklogin",
                "/login.html",
                "/error",
                "/error.html",
                "/html/*.html",
                "/js/*.js",
                "/css/*.css",
                "/font/*.*",
                "/pictures/*.*"
        );
    }
}