package com.ysy.aspectj.declaringadvice.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.ysy.aspectj.declaringadvice.annotation.AuditCode;
import com.ysy.aspectj.declaringadvice.annotation.AuditableCode;
import com.ysy.aspectj.declaringadvice.model.MyType;

@Service
public class SampleService implements Sample<MyType> {
	
	@AuditableCode(AuditCode.USER_ACTION)
    public void sampleMethod(String data) {
        System.out.println("Executing sampleMethod with data: " + data);
    }

    public void sampleGenericMethod(MyType param) {
        System.out.println("sampleGenericMethod called with param: " + param);
    }

    public void sampleGenericCollectionMethod(Collection<MyType> param) {
        System.out.println("sampleGenericCollectionMethod called with param: " + param);
    }	
}