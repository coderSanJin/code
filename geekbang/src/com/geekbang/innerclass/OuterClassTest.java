package com.geekbang.innerclass;


/**
 * 调用普通内部类的时候需要先创建外部类的对象，然后对象.内部类的方式
 * • 普通内部类和普通类一样可以定义成员变量、成员方法以及构造方法等。
 * • 普通内部类和普通类一样可以使用final或者abstract关键字修饰。
 * • 普通内部类还可以使用private或protected关键字进行修饰。
 * • 普通内部类需要使用外部类对象来创建对象。
 * • 如果内部类访问外部类中与本类内部同名的成员变量或方法时，需要使 用this关键字
 */
public class OuterClassTest {

    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        //调用内部类的话需要用外部类的引用指向内部类
        OuterClass.InnerClass inner = outer.new InnerClass();

        inner.show();
    }
}
