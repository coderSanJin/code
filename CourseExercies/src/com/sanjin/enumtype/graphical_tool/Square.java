package com.sanjin.enumtype.graphical_tool;

/**
 * 定义一个正方形的类 继承绘制图形的抽象基类  重写抽象方法
 */
class Square extends Shape {

    //定义一个边长的属性
    double sideLength;

    //当前类的构造器
    Square(double sideLength) {
        this.sideLength = sideLength;
    }

    /**
     * 重写父类的抽象方法，获取正方形的面积
     * @return
     */
    @Override
    double getArea() {
        return sideLength * sideLength;
    }

    /**
     * 重写父类的抽香方法，获取正方形的周长
     * @return
     */
    @Override
    double getPerimeter() {
        return sideLength * 4;
    }
}


