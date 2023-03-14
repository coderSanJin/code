package com.geekbang.innerclass;

public class AreaOuter {
    private int cnt = 1;

    public void show() {

        // 为了保证局部内部类和外部类的数据保证一致性  从Java8开始默认理解为final关键字修饰的变量
        // 虽然可以省略final关键字，但建议还是加上
        final int ic = 4;

        // 定义局部内部类，只在当前方法体的内部好使    拷贝一份
        class AreaInner {
            private int ia = 2;

            public AreaInner() {
                System.out.println("局部内部类的构造方法！");
            }

            public void test() {
                int ib = 3;
                System.out.println("ia = " + ia); // 2
                System.out.println("cnt = " + cnt); // 1
                //ic = 5;  //Error
                System.out.println("ic = " + ic); // 4
            }
        }

        // 声明局部内部类的引用指向局部内部类的对象
        AreaInner ai = new AreaInner();
        ai.test();
    }

}