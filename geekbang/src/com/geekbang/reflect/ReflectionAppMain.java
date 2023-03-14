package com.geekbang.reflect;

import com.geekbang.supermarket.LittleSuperMarket;
import com.geekbang.supermarket.Merchandise;
import sun.reflect.misc.ConstructorUtil;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ReflectionAppMain {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Merchandise merchandise = new Merchandise();


        //反射
        //Class<Merchandise> clazz = Merchandise.class;
        //Field count = clazz.getField("count");
        //count.set(merchandise,100);
        //System.out.println(count.get(merchandise));

        //TextField textField = new TextField();
        //Class textFieldC = textField.getClass();

        Student student = new Student("",0,0.1);
        Class clazz = student.getClass();

        Package aPackage = clazz.getPackage();
        System.out.println("获取该类的存放路径" + aPackage);

        System.out.println("获取该类的名称" + clazz.getName());

        System.out.println("获取该类继承的类" + clazz.getSuperclass());

        System.out.println("获取该类实现的所有接口" + clazz.getInterfaces());

        //构造方法
        Constructor[] constructors = clazz.getConstructors();
        Arrays.stream(constructors).forEach(vo -> {
            System.out.println("index   " + vo);
        });

        //Constructor constructor = constructors[0];
        //Constructor constructor = clazz.getConstructor();
        Constructor constructor = clazz.getDeclaredConstructor();
        System.out.println("获取权限为public的构造方法" + "");
        //获取指定的构造方法  参数为形式参数数组或者可变数组
        System.out.println("获取权限为public的指定构造方法" + clazz.getConstructor(String.class,int.class,double.class));
        System.out.println(constructor.isVarArgs());
        System.out.println(constructor.getParameterTypes());
        System.out.println(constructor.getExceptionTypes());
        constructor.setAccessible(true);
        Student stu = (Student) constructor.newInstance();
        stu.show();
        //getModifiers() 返回值 是int类型的  每个值代表不同的访问修饰符
        int modifiers = constructor.getModifiers();
        System.out.println("判断当前方法的返回值是否是public类型的  " + Modifier.isPublic(modifiers));
        System.out.println("判断当前方式的返回值是否代表是private   " + Modifier.isPrivate(modifiers));

        System.out.println("Modifier 将int类型的值转化为 表示的修饰符信息" + Modifier.toString(modifiers));


    }
}
