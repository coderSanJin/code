package com.sanjin.paramclass;

/**
 *
 * 结论
 * 一个方法不能修改一个基本数据类型的参数
 * 一个方法可以改变一个对象参数的状态
 * 一个方法不能让对象参数引用一个新的对象
 */

public class ParamTest {
    public static void main(String[] args) {
        /**
         * 修改基本数据类型的值
         *
         * 结论 在一个方法中如果传入一个基本类型值 方法中修改值  在方法外面打印值不变
         *     说明放在Java中基本数据类型是值传递
         */
        System.out.println("Testing tripleValue");
        double percent = 10;
        System.out.println("BeFore: percent = " + percent);
        tripleValue(percent);
        System.out.println("After: percent = " + percent);

        /**
         * 修改引用数据类型的值
         * 结论  定义一个对象，给对象赋值，调用修改对象中修改值的方法  外面打印对象值
         *      值被改变  引用数据类型是引用数据传递 其实还是传递的值
         */
        System.out.println("\nTesting tripleSalary");
        Employee harry = new Employee("Hary", 50000);
        System.out.println("Before: salary = " + harry.getSalary());
        tripleSalary(harry);
        System.out.println("After: salary = " + harry.getSalary());

        /**
         * 参数不能引用一个新的对象
         * 如果两个引用数据类型  传入一个方法中   在方法中如果没有对值进行修改就算是改变了对象的引用地址
         * 也说明改变的是形参 而对象传入方法中，相当于也是新对象的引用传进去的 所以在外面打印对象 对象依然没有被改变
         */
        System.out.println("\nTesting swap");
        Employee a = new Employee("Alice", 70000);
        Employee b = new Employee("Bob", 60000);
        System.out.println("Before: a = " + a.getName());
        System.out.println("Before: b = " + b.getName());
        swap(a, b);
        System.out.println("After: a = " + a.getName());
        System.out.println("After: b = " + b.getName());
    }

    public static void tripleValue(double x) {
        x = 3 * x;
        System.out.println("End of method: x = " + x);
    }

    public static void tripleSalary(Employee x) {
        x.raiseSalary(200);
        System.out.println("End of method：salary = " + x.getSalary());
    }

    public static void swap(Employee x, Employee y) {
        Employee temp = x; //先把 temp 指向 x
        x = y;   //在吧x 指向 y
        y = temp; //在吧y  指向 temp
        System.out.println("End of method：x = " + x.getName());
        System.out.println("End of method：y = " + y.getName());
    }
}

class Employee {
    private String name;
    private double salary;

    public Employee(String n, double s) {
        name = n;
        salary = s;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}

