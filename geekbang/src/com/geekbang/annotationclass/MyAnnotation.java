package com.geekbang.annotationclass;


import com.sanjin.innerclass.enumclass.Direction;
import com.sanjin.innerclass.enumclass.DirectionEnum;

import java.lang.annotation.*;

/**
 * 若一个注解中没有任何的成员，则这样的注解叫做标记注解/标识注解
 * • 注解体中只有成员变量没有成员方法，而注解的成员变量以“无形参的方 法”形式来声明，其方法名定义了该成员变量的名字，其返回值定义了该 成员变量的类型。
 * • 如果注解只有一个参数成员，建议使用参数名为value，而类型只能是八种基本数据类型、String类型、Class类型、enum类型及Annotation类型。
 */
// 表示下面的注解可以用于类型、构造方法、成员变量、成员方法、参数 的修饰
//@Retention(RetentionPolicy.SOURCE)     // 表示下面的注解在源代码中有效
//@Retention(RetentionPolicy.CLASS)      // 表示下面的注解在字节码文件中有效，默认方式
@Retention(RetentionPolicy.RUNTIME)      // 表示下面的注解在运行时有效
@Documented                              // 表示下面的注解信息可以被javadoc工具提取到API文档中，很少使用
//@Target(ElementType.TYPE)    可以给类 接口 枚举进行注解 当@Target() 值只有一个的时候只能修饰当前值代表的范围
//@Target({ElementType.TYPE,ElementType.FIELD})
@Target({ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Inherited  // 表示下面的注解所修饰的类中的注解使用可以被子类继承
public @interface MyAnnotation {
    //public Direction value();  //声明一个String类型的成员变量，名字为value   类型有要求
    public String value() default "123"; //default 给默认值在使用该注解的地方可以不赋值
    public String value2();
}
