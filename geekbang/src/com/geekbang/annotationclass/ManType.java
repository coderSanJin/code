package com.geekbang.annotationclass;

import java.lang.annotation.*;

@Repeatable(value = ManTypes.class)
@Target(ElementType.TYPE_USE)  //全部范围都可使用当前注解
public @interface ManType {
    String value() default "";
}
