package com.ysy.aspectjsupport.declaringaspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ysy.aspectjsupport.declaringaspect.config.AppConfig;
import com.ysy.aspectjsupport.declaringaspect.service.MyService;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = 
        		new AnnotationConfigApplicationContext(AppConfig.class);
        MyService myService = context.getBean(MyService.class);
        myService.doSomething();


    }
}