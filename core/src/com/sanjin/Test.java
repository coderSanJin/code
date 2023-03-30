package com.sanjin;
import com.sanjin.equalsclass.Manager;
import org.w3c.dom.ls.LSInput;

import java.awt.*;
import java.util.ArrayList;

public class Test {
    //初始化块跟变量的执行顺序按照代码的执行顺序
    int b = 8;

    public Test() {
        System.out.println("构造方法");
    }

    {
        System.out.println("初始化块");
        b = 5;
    }

    static {
        System.out.println("静态初始化块");
    }





    public static void main(String[] args) {
        //System.out.println(new Test().b);
        //ArrayList<String> list = new ArrayList<>();
        //list.add("jiji");
        //list.add("jijijijiji");
        //list.set(1,"oooo");

        //自动装箱规范要求boolean byte char <= 127
        //介于-128 ~ 127 之间的short 和 int 被包装到固定的对象中 则 == 进行比较的结果是成立的
        //Integer a = 100;
        //Integer b = 100;
        //
        //if (a == b) {
        //    System.out.println("true");
        //}
        //对于printf相当于匹配Object[0] Object[1]
        // Object... args  就是 new Object[]{"11", "222"}
        // 所以 printf 允许将一个数组传递给可变参数的最后一个参数（如果只有一个参数那就是最后一个参数）
        System.out.printf("%d %s", new Object[] {new Integer(1), "world"});
        System.out.println();
        //编译器会 new double[]{3.1,40.5,-5}
        double max = Test.max(3.1, 40.4, -5);
        System.out.println(max);


    }

    public static double max(double... values) {
        double largest = Double.NEGATIVE_INFINITY;

        for (double v : values) if (v > largest) largest =v;

        return largest;
    }
}
