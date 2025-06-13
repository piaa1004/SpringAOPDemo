package com.ysy.aspectjsupport.declaringadvice.config;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.ysy.aspectjsupport.declaringadvice.aop.ExecutionCountingAspect;
import com.ysy.aspectjsupport.declaringadvice.aop.SampleAspect;
import com.ysy.aspectjsupport.declaringadvice.aop.TimingAspect;
import com.ysy.aspectjsupport.declaringadvice.model.MyType;
import com.ysy.aspectjsupport.declaringadvice.service.Sample;
import com.ysy.aspectjsupport.declaringadvice.service.SampleService;

@Configuration
@ComponentScan(basePackages = "com.ysy.aspectjsupport.declaringadvice")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
	
    @Bean
    public ExecutionCountingAspect executionCountingAspect() {
        return new ExecutionCountingAspect();
    }

    @Bean
    public TimingAspect timingAspect() {
        return new TimingAspect();
    }

}