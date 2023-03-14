package com.geekbang.reflect;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main_02 {

    public static void main(String[] args) {
        /**
         * 获取所有成员变量的值，将成员变量的名称和类型信息输出到控制台
         * 并分别将各个成员变量在修改前后的值输出到控制台
         */

        Example_02 example02 = new Example_02();
        Class<? extends Example_02> clazz = example02.getClass();

        Arrays.stream(clazz.getFields()).forEach(vo -> System.out.println(vo.getName()));
        System.out.println("---------");
        Arrays.stream(clazz.getDeclaredFields()).forEach(vo -> System.out.println(vo.getName()));

        //try {
        //    Field i = clazz.getDeclaredField("s");
        //    i.setAccessible(true);
        //    i.set(example02, "11");
        //    System.out.println(i.get(example02));
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}
        ////获得所有成员变量
        //Field[] fields = clazz.getDeclaredFields();
        //for (int i = 0; i < fields.length; i++) {
        //    Field field = fields[i];
        //    System.out.println("名称为：" + field.getName());
        //
        //    Class<?> type = field.getType();
        //    System.out.println("类型为：" + type);
        //
        //    boolean isTurn = true;
        //    while (isTurn) {
        //        //如果该成员量变量的访问权限为private，则抛出异常，既不允许访问
        //        try {
        //            isTurn = false;
        //            //获得成员变量值
        //            System.out.println("修改前的值为：" + field.get(example02));
        //            if (type.equals(int.class)) {
        //                System.out.println("利用方法setInt() 修改成员变量的值");
        //                field.setInt(example02, 168);
        //            } else if (type.equals(float.class)) {
        //                System.out.println("利用方法setFloat() 修改成员变量的值");
        //                field.setFloat(example02, 99.9F);
        //            } else if (type.equals(boolean.class)) {
        //                System.out.println("利用方法setBoolean() 修改成员变量的值");
        //                field.setBoolean(example02, true);
        //            } else {
        //                System.out.println("利用方法set() 修改成员变量的值");
        //                field.set(example02,"MWQ");//可以为各种成员变量赋值
        //            }
        //            //获得成员变量的值
        //            System.out.println("修改后的值为：" + field.get(example02));
        //            System.out.println("当前方法的访问修饰符为：" + Modifier.toString(field.getModifiers()));
        //        } catch (Exception e) {
        //            System.out.println("当前成员变量的访问权限为private，设置为可访问属性 setAccessible(true)");
        //            field.setAccessible(true);
        //            isTurn = true;
        //        }
        //    }
        //    System.out.println();
        //}
    }
}
