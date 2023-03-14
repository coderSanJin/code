package com.geekbang.reflect;


/**
 * test student
 * @version 1.0
 */
public class Student extends StudentPerson implements StudentInterface{


    public String name;
    public int age;
    public double score;


    private Student() {
    }


    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.println("show 方法");
    }

    public int getAge(int age) {
        return age += 1;
    }

    @Override
    public String getGrade() {
        return "实现接口的方法";
    }
}
