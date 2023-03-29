package com.sanjin.equalsclass;

public class Manager extends Employee{

    private double bonus;

    public Manager(String name, double salary, int year, int month, int day) {
        //实现父类的构造方法
        super(name, salary, year, month, day);
        bonus = 0;
    }

    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public boolean equals(Object otherObject) {
        //直接实现父类的方法
        if (!super.equals(otherObject)) return false;
        Manager other = (Manager) otherObject;

        return bonus == other.bonus;
    }

    public String toString() {
        return super.toString() + "[bonus = " + bonus + "]";
    }

}
