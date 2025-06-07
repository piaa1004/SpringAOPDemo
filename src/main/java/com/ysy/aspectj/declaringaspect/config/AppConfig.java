package com.ysy.aspectj.declaringaspect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.ysy.aspectj.declaringaspect.aspect.NotVeryUsefulAspect;
import com.ysy.aspectj.declaringaspect.service.MyService;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.ysy.aspectj.declaringaspect")
public class AppConfig {

    @Bean
    public NotVeryUsefulAspect notVeryUsefulAspect() {
        return new NotVeryUsefulAspect();
    }

    @Bean
    public MyService myService() {
        return new MyService();
    }
}