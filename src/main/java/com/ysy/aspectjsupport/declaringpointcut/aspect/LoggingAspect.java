package com.ysy.aspectjsupport.declaringpointcut.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	/*
	 targetIsSpecialService(), 
	 methodWithStringArg(), 
	 loggableMethods(), 
	 withinSpecialComponent(), 
	 targetHasSpecialComponent(), 
	 methodWithValidatedArgs() 
	 위 메서드들은 실제로 호출되지 않으며, 포인트컷을 정의하는 역할(포인트컷 시그니쳐)을 합니다.
	 
	 단지, 다음의 어드바이스 메서드의 포인트컷으로 활용됩니다
	 예를 들어 logBeforeTransfer 메서드는 anyTransferOperation 포인트컷으로 타겟에 적용됩니다
	 logBeforeTransfer(), 
	 logBeforeWithinService(), 
	 logWhenProxyIsTransferService(), 
	 logWhenTargetIsSpecialService(), 
	 logForMethodsWithStringArg(), 
	 logForLoggableMethods(), 
	 logWithinSpecialComponent(), 
	 logWhenTargetHasSpecialComponent(), 
	 logForMethodsWithValidatedArgs() 
	 위 메서드들은 실제로 어드바이스(Advice)를 수행하는 메서드들입니다.
	 */
   

    // args 디지그네이터를 사용하여 메서드의 아규먼트가 특정 타입인 경우 매칭
    @Pointcut("args(String, ..)")
    private void methodWithStringArg() {}

    // @annotation 디지그네이터를 사용하여 메서드에 특정 애노테이션이 있는 경우 매칭
    @Pointcut("@annotation(com.ysy.aspectjsupport.declaringpointcut.annotation.Loggable)")
    private void loggableMethods() {}

    // @within 디지그네이터를 사용하여 클래스에 특정 애노테이션이 있는 경우 매칭
    @Pointcut("@within(com.ysy.aspectjsupport.declaringpointcut.annotation.SpecialComponent)")
    private void withinSpecialComponent() {}

    // @target 디지그네이터를 사용하여 실제 타겟 객체가 특정 애노테이션을 가지고 있는 경우 매칭
    @Pointcut("@target(com.ysy.aspectjsupport.declaringpointcut.annotation.SpecialComponent)")
    private void targetHasSpecialComponent() {}

    // @args 디지그네이터를 사용하여 메서드의 아규먼트가 특정 애노테이션을 가진 타입인 경우 매칭
    @Pointcut("@args(com.ysy.aspectjsupport.declaringpointcut.annotation.Validated)")
    private void methodWithValidatedArgs() {}
    
    
    // 첫 번째 인자가 String인 메서드가 호출될 때, 메서드 이름과 전달된 인자 값을 로그로 출력합니다.
    @Before("methodWithStringArg()")
    public void logForMethodsWithStringArg(JoinPoint joinPoint) {
        System.out.println("Logging methods with String argument");
        System.out.println("Method: " + joinPoint.getSignature().getName());
        System.out.println("Arguments: " + Arrays.toString(joinPoint.getArgs()));
    }

    // @Loggable 애노테이션이 붙은 메서드가 호출될 때, 메서드 이름과 타겟 클래스 정보를 로그로 출력합니다.
    @Before("loggableMethods()")
    public void logForLoggableMethods(JoinPoint joinPoint) {
        System.out.println("Logging for methods annotated with @Loggable");
        System.out.println("Method: " + joinPoint.getSignature().getName());
        System.out.println("Target class: " + joinPoint.getTarget().getClass().getName());
    }

    // @SpecialComponent 애노테이션이 붙은 클래스 내의 메서드가 호출될 때, 메서드 이름과 클래스 이름을 로그로 출력합니다.
    @Before("withinSpecialComponent()")
    public void logWithinSpecialComponent(JoinPoint joinPoint) {
        System.out.println("Logging for methods within a @SpecialComponent class");
        System.out.println("Method: " + joinPoint.getSignature().getName());
        System.out.println("Class: " + joinPoint.getTarget().getClass().getName());
    }

    // 타겟 객체가 @SpecialComponent 애노테이션을 가진 경우, 타겟 클래스와 호출된 메서드 이름을 로그로 출력합니다.
    @Before("targetHasSpecialComponent()")
    public void logWhenTargetHasSpecialComponent(JoinPoint joinPoint) {
        System.out.println("Logging for targets annotated with @SpecialComponent");
        System.out.println("Target class: " + joinPoint.getTarget().getClass().getName());
        System.out.println("Method being called: " + joinPoint.getSignature().getName());
    }

    // @Validated 애노테이션이 붙은 아규먼트가 있는 메서드가 호출될 때, 메서드 이름과 아규먼트 값을 로그로 출력합니다.
    @Before("methodWithValidatedArgs()")
    public void logForMethodsWithValidatedArgs(JoinPoint joinPoint) {
        System.out.println("Logging for methods with @Validated annotated arguments");
        System.out.println("Method: " + joinPoint.getSignature().getName());
        System.out.println("Arguments: " + Arrays.toString(joinPoint.getArgs()));
    }
    
    @Before("bean(myServiceBean)")
    public void beforeBeanExecution() {
        System.out.println("🔥 Before advice applied to bean named 'myServiceBean'");
    }
}