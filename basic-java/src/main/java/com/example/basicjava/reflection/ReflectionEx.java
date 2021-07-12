package com.example.basicjava.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionEx {

    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<?> aClass = Class.forName("com.example.basicjava.reflection.Member");

        // 선언된 메서드 나열하기
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println("method = " + method.toString());
        }

        // 메서드 해부하기
        Method saySomething = aClass.getMethod("saySomething", String.class);
        Class<?>[] parameterTypes = saySomething.getParameterTypes();
        for (Class<?> parameterType : parameterTypes) {
            System.out.println("parameterType = " + parameterType);
        }

        String name = saySomething.getName();
        System.out.println("name = " + name);

        Class<?> returnType = saySomething.getReturnType();
        System.out.println("returnType = " + returnType);

        // method invoke 예제
        Method sayHello = aClass.getMethod("sayHello");
        sayHello.invoke(aClass.getDeclaredConstructor().newInstance());

        // newInstance 예제
        Member memberInstance = (Member) aClass.getDeclaredConstructor().newInstance();
        memberInstance.setName("andrew");
        memberInstance.setAge(32);

        System.out.println("memberInstance = " + memberInstance);

    }

}
