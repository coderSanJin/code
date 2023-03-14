package com.geekbang.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main_01 {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Example_01 example = new Example_01("10", "20", "30");

        Class<? extends Example_01> aClass = example.getClass();
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (int i = 0; i < declaredConstructors.length; i++) {
            Constructor<?> constructor = declaredConstructors[i];
            System.out.println("查看是否允许带有可变数量的参数：" + constructor.isVarArgs());
            System.out.println("该构造方法的入口参数类型依次为：");
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (int j = 0; j < parameterTypes.length; j++) {
                System.out.println(" " + parameterTypes[i]);
            }

            System.out.println("该构造方法可能抛出的异常类型为：");
            //获得所有可能抛出的异常信息类
            Class<?>[] exceptionTypes = constructor.getExceptionTypes();
            for (int j = 0; j < exceptionTypes.length; j++) {
                System.out.println("" + exceptionTypes[i]);
            }
            Example_01 example2 = null;

            while (example2 == null) {
                try {
                    if (i == 2)
                        example2 = (Example_01) constructor.newInstance();
                    else if (i == 1)
                        example2 = (Example_01) constructor.newInstance("7", 5);
                    else {
                        Object[] parameters = new Object[] {new String[]{"100", "200", "3000"}};
                        example2  = (Example_01) constructor.newInstance(parameters);
                    }
                } catch (Exception e) {
                    System.out.println("在创建对象时抛出异常，下面执行setAccessible() 方法");
                    constructor.setAccessible(true); //设置为允许访问
                }
            }

            if (null != example2) {
                example2.print();
                System.out.println();
            }
        }


    }

    /*
        // 通过反射访问Example_01类中的所有构造方法，
        // 并将该该构造方法是否允许带有可变数量的参数、
        // 入口参数类型和可能抛出的异常类型信息输出到控制台，
        Class clazz = Example_01.class;
        //获取所有的构造方法
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (int i = 0; i < declaredConstructors.length; i++) {
            Constructor declaredConstructor = declaredConstructors[i];
            if (declaredConstructor.isVarArgs()) {
                System.out.println(declaredConstructor.getTypeParameters());
                System.out.println(declaredConstructor.getExceptionTypes());
            }
        }


     */
}
