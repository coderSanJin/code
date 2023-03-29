package com.sanjin.equalsclass;

import javax.jws.Oneway;
import javax.swing.*;
import java.time.LocalDate;
import java.util.Objects;

public class Employee {
    private String name;

    private double salary;

    private LocalDate hireDay;

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    //重写父类的equals 方法
    public boolean equals(Object otherObject) {
        //看看对象是否相等
        if (this == otherObject) return true;
        //如果显示参数为空则必须返回false
        if (otherObject == null) return false;
        //如果类不匹配，它们不可能相同
        //instanceof如果存在子类和超类的情况下使用instanceof就会出问题
        if (getClass() != otherObject.getClass()) return false;

        Employee other = (Employee) otherObject;

        return Objects.equals(name,other.name) && salary == other.salary
                && Objects.equals(hireDay, other.hireDay);
    }

    //如果重写equals方法就必须重写hashcode()方法
    public int hashCode() {
        return Objects.hash(name, salary, hireDay);
    }

    //重写toString()方法
    public String toString() {
        return getClass().getName() + "[name = " + name + ",salary = " + salary + ", hireDay = "
                + hireDay + "]";
    }
}
