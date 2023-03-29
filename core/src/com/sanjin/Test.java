package com.sanjin;
import java.awt.*;

public class Test {
    //初始化块跟变量的执行顺序按照代码的执行顺序
    int b = 8;

    public Test() {
        System.out.println("构造方法");
    }

    {
        System.out.println("初始化块");
        b = 5;
    }

    static {
        System.out.println("静态初始化块");
    }





    public static void main(String[] args) {
        System.out.println(new Test().b);
    }
}
