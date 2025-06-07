package com.ysy.aspectjsupport.declaringpointcut.service;

import com.ysy.aspectjsupport.declaringpointcut.annotation.Loggable;
import com.ysy.aspectjsupport.declaringpointcut.annotation.SpecialComponent;
import com.ysy.aspectjsupport.declaringpointcut.annotation.Validated;

@SpecialComponent
public class SpecialService {
	
    @Loggable
    public void specialOperation(String operation) {
        System.out.println("Performing special operation: " + operation);
    }

    public void anotherSpecialOperation(@Validated String parameter) {
        System.out.println("Performing another special operation with parameter: " + parameter);
    }


}
