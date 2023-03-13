package com.geekbang.innerclass;

public class AreaOuterTest {

    /**
     * • 局部内部类只能在该方法的内部可以使用。
     * • 局部内部类可以在方法体内部直接创建对象。
     * • 局部内部类不能使用访问控制符和static关键字修饰符。
     * • 局部内部类可以使用外部方法的局部变量，但是必须是final的。由局部内 部类和局部变量的声明周期不同所致。
     */
    public static void main(String[] args) {
        // 1.声明外部类类型的引用指向外部类的对象
        AreaOuter ao = new AreaOuter();
        // 2.通过show方法的调用实现局部内容类的定义和使用
        ao.show();
    }
}