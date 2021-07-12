package com.example.basicjava.reflection;

import java.lang.annotation.Annotation;

public class AnnotationEx {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.example.basicjava.reflection.Member");
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("annotation = " + annotation);
        }
    }

}
