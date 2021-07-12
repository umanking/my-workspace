package com.example.basicjava.reflection.diframework;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Container {

    public static <T> T getObject(Class<T> clazz) {
        T instance = createNewInstance(clazz);
        // 클래스내에 선언된 필드들 중에서 어노테이션이 있는것
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectAnnotation.class)) {
                // 해당 필드의 타입을 새로 만들고
                Object fieldInstance = createNewInstance(field.getType());

                // 필드의 접근 제어가 private인 경우 수정이 가능하도록 변경
                field.setAccessible(true);
                try {
                    // 인스턴스
                    field.set(instance, fieldInstance);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return instance;
    }

    public static <T> T createNewInstance(Class<T> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
