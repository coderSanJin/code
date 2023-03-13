package com.geekbang.innerclass;


public class StaticOuterTest {


    /**
     * • 静态内部类不能直接访问外部类的非静态成员。
     * • 静态内部类可以直接创建对象。
     * • 如果静态内部类访问外部类中与本类内同名的成员变量或方法时，需要 使用类名.的方式访问。
     */
    public static void main(String[] args) {
        StaticOuter.StaticInner staticInner = new StaticOuter.StaticInner();
        staticInner.show();
        System.out.println("-----------------------");
        staticInner.show2(6);
    }
}
