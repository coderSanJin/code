package com.sanjin.constructorclass;

import java.util.Random;

public class ConstructorTest {

    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Harry", 40000);
        staff[1] = new Employee(60000);
        staff[2] = new Employee();

        for (Employee e : staff) {
            System.out.println("name = " + e.getName() + ",id" +
                    e.getId() + ",salary = " + e.getSalary() );
        }

        staff[0].sName = "ss";
    }

}

class Employee {
    private static int nextId;

    private int id;
    private String name = "";
    private double salary;
    String sName;

    /**
     * 静态代码块
     */
    static {
        Random generator = new Random();
        nextId = generator.nextInt(10000);
    }

    /**
     * 初始化块
     */
    {
        id = nextId;
        nextId++;
    }

    /**
     * 构造方法
     */
    public Employee(String n, double s) {
        name = n;
        salary = s;
    }

    public Employee(double s) {
        this("Employee #" + nextId , s);
    }

    /**
     * 会对变量进行初始化 将变量值赋值为变量类型的默认值
     */
    public Employee() {

    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }
}