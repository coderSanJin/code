package com.sanjin.custom_exception.exercise;

public class Student {

    public static void speak(int m) throws MyException {
        if (m > 1000) {
            throw new MyException("m 的值大于1000");
        }
    }

    public static void main(String[] args) {
        try {
            speak(1001);
        } catch (MyException e) {
            System.out.println(e.message);
        }

    }
}
