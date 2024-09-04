package com.spring.ex01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor {

    //invoke 메서드는 MethodInterceptor 인터페이스에서 정의된 메서드로, 실제로 메서드 호출을 가로채는 핵심 메서드
    //MethodInvocation 객체를 인자로 받아, 원래 메서드 호출에 관한 정보와 실행 제어를 제공합니다.
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("[메서드 호출 전 : Logging Advice");
        System.out.println(invocation.getMethod() + "메서드 호출 전");

        //invocation.proceed()를 호출하여 실제 대상 메서드를 실행
        Object object = invocation.proceed();

        System.out.println("[메서드 호출 후 : loggingAdvice");
        System.out.println(invocation.getMethod() + "메서드 호출 후");
        return object;
    }
}