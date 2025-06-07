package com.ysy.aspectjsupport.declaringadvice.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcuts {

    @Pointcut("within(com.ysy.aspectjsupport.declaringadvice.service..*)")
    public void inDataAccessLayer() {}
}