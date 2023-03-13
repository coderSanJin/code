package com.geekbang.innerclass;

/**
 * 外部类
 *
 */
public class OuterClass {
    private int cnt = 1;

    public OuterClass(){
        System.out.println("外部类的构造方法");
    }

    /**
     * 内部类
     * private   内部类私有化后不能被其他类调用
     *
     */
    public class InnerClass {
        private int cnt = 2;

        public InnerClass() {
            System.out.println("内部类的构造方法");
        }


        public void show() {
            System.out.println("我是内部类");
            System.out.println("内部类的cnt=" + this.cnt);
            System.out.println("外部类的cnt=" + OuterClass.this.cnt);
        }
    }

}
