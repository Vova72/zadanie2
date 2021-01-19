package com.company;

import jdk.nashorn.internal.objects.NativeDebug;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main2 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        TextContainer container = new TextContainer();
        Class<?> cls = container.getClass();
        if (cls.isAnnotationPresent(SaveTo.class)) {
            String path = cls.getAnnotation(SaveTo.class).path();
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Saver.class)) {
                    method.invoke(container, path);
                }
            }
        }
    }
}
