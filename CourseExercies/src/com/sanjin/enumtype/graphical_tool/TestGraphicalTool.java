package com.sanjin.enumtype.graphical_tool;

import java.sql.SQLData;

public class TestGraphicalTool {


    /**
         多态是面向对象编程中的一个重要概念。它允许在程序中多次调用同一个方法，却可以在不同的场景中获得不同的结果。

         Java 中的多态有两种形式：方法多态和对象多态。

         方法多态指的是在同一个类中定义了多个重载的同名方法，在不同场景中调用该方法可以获得不同的结果。

         对象多态指的是同一个方法在不同的对象中有不同的实现。Java 中对象多态通过接口和抽象类来实现。

         以下是一个简单的代码示例，它展示了 Java 中的对象多态：
     **/
    public static void main(String[] args) {
        Shape circle = new Circle(2);
        Shape square = new Square(2);
        Shape [] shapes = {circle, square};

        TestGraphicalTool.canvas(shapes);
    }


    /**
     * 体现了用抽象类来实现Java中对象的多态
     * 可以定义一个抽象基类，同时满足的行为可以抽象出来定义为抽象方法
     * 把不同的事物或个体抽象为对象 每个事物或个体都要重写或使用基类里面的抽象方法
     * 体现了Java的对象多态
     *
     *
     * 方法的多态
     * 方法的多态就是重载方法，这个对象在不同的场景里面使用的方法是不同的
     * 也就是Java多态中的方法多台
     * @param shapes
     */
    public static void canvas(Shape [] shapes){
        for (Shape shape:shapes){
            //不同对象的面积是不同的
            System.out.println("面积是" + shape.getArea());
            System.out.println("周长是" + shape.getPerimeter());
        }
    }
}
