package com.sanjin.enumtype.graphical_tool;


/**
 * 定义一个图形绘制的抽象基类
 */
abstract class Shape {
    /**
     * 定义一个获取面积的抽象方法
     * @return
     */
    abstract double getArea();

    /**
     * 定义一个获取周长的抽象方法
     * @return
     */
    abstract double getPerimeter();
}
