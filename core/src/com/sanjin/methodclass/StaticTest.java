package com.sanjin.methodclass;

public class StaticTest {

    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Tom", 40000);
        staff[1] = new Employee("Dick", 60000);
        staff[2] = new Employee("Harry", 65000);

        for (Employee e : staff) {
            //nextId ++
            e.setId();
            System.out.println("name=" + e.getName() + ",id=" + e.getId() + "" +
                    e.getSalary());
        }

        int nextId = Employee.getNextId();
        System.out.println(nextId);
    }
}

class Employee {
    private static int nextId = 1;
    private  String name;
    private double salary;
    private int id;

    public Employee(String n, double s) {
        name = n;
        salary = s;
        id = 0;
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

    public void setId() {
        id = nextId;
        nextId++;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void tripValue(double x) {
        x = 3 * x;
    }

    public static void tripQuote(Employee x) {
        x.raiseSalary(200);
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public static void main(String[] args) {
        Employee e = new Employee("hary", 50000);
        System.out.println(e.getName() + " " + e.getSalary());


        //基本数据类型 在特定的情况下基本数据类型的值不能被修改
        double percent = 10;
        Employee.tripValue(percent);
        System.out.println(percent);

        tripQuote(e);
        System.out.println(e.salary);
    }
}
