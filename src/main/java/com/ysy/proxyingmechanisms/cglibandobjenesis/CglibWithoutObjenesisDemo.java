package com.ysy.proxyingmechanisms.cglibandobjenesis;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

// CGLIB이 내부적으로 사용하는 ClassLoader#defineClass(...) 메서드에 접근하지 못함으로써
// Caused by: net.sf.cglib.core.CodeGenerationException: java.lang.reflect.InaccessibleObjectException-->Unable to make protected final java.lang.Class java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain) throws java.lang.ClassFormatError accessible: module java.base does not "opens java.lang" to unnamed module @54a097cc
// VM 아규먼트 옵션에 다음 라인을 추가
// --add-opens java.base/java.lang=ALL-UNNAMED
public class CglibWithoutObjenesisDemo {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Target.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("🔍 " + method.getName() + " 메서드 호출");
                return proxy.invokeSuper(obj, args);
            }
        });

        Target proxy = (Target) enhancer.create(); // 생성자 호출!
        proxy.hello();
    }
}

