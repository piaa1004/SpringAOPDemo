package com.ysy.aspectjsupport.aspectinstantiationmodels.config;

import org.springframework.context.annotation.*;

import com.ysy.aspectjsupport.aspectinstantiationmodels.service.MyService;
import com.ysy.aspectjsupport.aspectinstantiationmodels.service.MyServiceImpl;

@Configuration
@ComponentScan({"com.ysy.aspectinstantiationmodels"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

	 @Bean
	 public MyService myService1() {
	     return new MyServiceImpl("SVC1");
	 }
	
	 @Bean
	 public MyService myService2() {
	     return new MyServiceImpl("SVC2");
	 }
}
