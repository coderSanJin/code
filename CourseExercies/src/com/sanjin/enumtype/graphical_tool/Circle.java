package com.sanjin.enumtype.graphical_tool;

/**
 * 定义一个普通类（代表圆形） 继承 绘制图形抽象基类
 */
class Circle extends Shape {
    /**
     * 半径
     */
    double radius;

    /**
     * 构造方法
     * @param radius
     */
    Circle(double radius) {
        this.radius = radius;
    }

    /**
     * 获取圆的面积
     * @return
     */
    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     * 获取圆的周长
     * @return
     */
    @Override
    double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}