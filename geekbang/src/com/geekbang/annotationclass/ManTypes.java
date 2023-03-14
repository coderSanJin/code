package com.geekbang.annotationclass;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE_USE)
public @interface ManTypes {
    ManType[] value();
}
