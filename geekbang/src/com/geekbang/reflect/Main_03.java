package com.geekbang.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main_03 {


    /**
     * 运用反射的时候需要注意执行具有可变参数的方法时，需要将形参定义为二维数组
     * @param args
     */
    public static void main(String[] args) {
        Example_03 example03 = new Example_03();
        Class<? extends Example_03> clazz = example03.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            System.out.println("方法名称为：" + method.getName());
            System.out.println("是否是允许带有可变参数为形参的方法：" + method.isVarArgs());
            System.out.println("入口参数类型依次为：");
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (int j = 0; j < parameterTypes.length; j++) {
                System.out.println(" " + parameterTypes[j]);
            }

            System.out.println("返回值类型为：" + method.getReturnType());
            System.out.println("可能抛出的异常类型有：");
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            for (int e = 0; e < exceptionTypes.length; e++) {
                System.out.println(" " + exceptionTypes[e]);
            }

            boolean isTurn = true;
            while (isTurn) {
                try {
                    isTurn = false;
                    if ("staticMethod".equals(method.getName()))
                        method.invoke(example03);
                    else if ("publicMethod".equals(method.getName()))
                        System.out.println("返回值为：" + method.invoke(example03, 168));
                    else if ("protectedMethod".equals(method.getName()))
                        System.out.println("返回值为：" + method.invoke(example03, "7", 5));
                    else if ("privateMethod".equals(method.getName())) {
                        Object[] parameters = new Object[] {new String[] {"M", "W", "Q"}};
                        System.out.println("返回值为：" + method.invoke(example03, parameters));
                    }
                } catch (Exception e) {
                    System.out.println("在执行方法时抛出异常，" + "下面执行 setAccessible()方法");
                    method.setAccessible(true);
                    isTurn = true;
                }
            }
            System.out.println();
        }
    }
}
