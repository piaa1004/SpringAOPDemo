package com.ysy.aspectjsupport.enablingaspectjsupport.basedsubclass.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {

    @Before("execution(* com.ysy.aspectjsupport.enablingaspectjsupport.basedsubclass.service.FooService+.*(..))")
    //@Before(anyOldTransfer)
	public void advice() {
        System.out.println("MyAspect advice");
    }
}