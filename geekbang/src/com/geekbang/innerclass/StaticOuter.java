package com.geekbang.innerclass;

/**
 * 外部类
 */
public class StaticOuter {

    //隶属对象层级
    private int cnt = 1;

    //隶属类层级
    private static int snt = 2;

    public void show(){
        System.out.println("外部类的show方法");
    }

    /**
     * 静态内部类  static关键字修饰隶属于类层级
     */
    public static class StaticInner {

        private int ia = 3;

        private static int snt = 4;

        public StaticInner() {
            System.out.println("静态内部类的构造方法");
        }

        public void show() {
            System.out.println("ia = " + ia);
            System.out.println("内部类中的snt = " + snt);
            //System.out.println("外部类的cnt = " + cnt); //Error: 静态上下文中不能访问非静态的成员，因为此时可能还没有创建对象
        }

        public void show2(int snt){
            //就近原则 此时读取的为形参
            System.out.println("snt = " + snt);
            //外部类的静态变量
            System.out.println("外部类的snt = " + StaticOuter.snt);
            System.out.println("内部类的snt = " + StaticInner.snt);
            new StaticOuter().show();
        }
    }

}
