package com.ysy.aspectjsupport.combindedpointcuts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.ysy.aspectjsupport.combindedpointcuts.aspect.LoggingAspect;
import com.ysy.aspectjsupport.combindedpointcuts.pointcuts.CommonPointcuts;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.ysy.aspectjsupport.combindedpointcuts")
public class AppConfig {

//    @Bean
//    public CommonPointcuts commonPointcuts() {
//        return new CommonPointcuts();
//    }

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }
}