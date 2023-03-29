package com.sanjin.timeclass;

import java.time.LocalDate;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee harry = new Employee("zzx", 5, 2023, 3, 19);
    }
}

class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;


    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
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

}
