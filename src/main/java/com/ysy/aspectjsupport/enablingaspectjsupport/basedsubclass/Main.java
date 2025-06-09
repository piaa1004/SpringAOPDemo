package com.ysy.aspectjsupport.enablingaspectjsupport.basedsubclass;

import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ysy.aspectjsupport.enablingaspectjsupport.basedsubclass.config.AppConfig;
import com.ysy.aspectjsupport.enablingaspectjsupport.basedsubclass.service.FooService;


public class Main {

	public static void main(String[] args) {
		ApplicationContext context = 
        		new AnnotationConfigApplicationContext(AppConfig.class);

		FooService fooService = context.getBean(FooService.class);
		
		System.out.println(AopUtils.isCglibProxy(fooService)); // → true
		System.out.println(AopUtils.isJdkDynamicProxy(fooService)); // → false

		
		fooService.helloFoo();
		
	}

}
