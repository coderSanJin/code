package com.sanjin.task10;


/**
 * 自定义注解的格式
 *
 * 注解相当于是一个接口 用@interface修饰
 *
 * 若一个注解中没有任何的成员，则这样的注解叫做标记注解
 *
 * 注解中只有成员变量 没有成员方法，而注解的成员变量以无型参的方法形式来声明
 * 其方法名称定义了改成员变量的名字，其返回值定义了该成员变量的类型
 */
public @interface MyAnnotation {

    public String value();

}
