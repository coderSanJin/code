package com.geekbang.generic;

import java.util.ArrayList;
import java.util.List;

public class UsegenericClassAppMain {

    public static void main(String[] args) {
        useStringListGenerics();
    }

    public static List<String> createStringListGenerics() {
        ArrayList<String> ret = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ret.add("str" + (i % 5));
        }

        List causeError = ret;
        causeError.add(new Object());
        return ret;
    }


    private static void useStringListGenerics() {
        List<String> strList = createStringListGenerics();
        for (int i = 0; i < strList.size(); i++) {
            String str = strList.get(i).toUpperCase();
            System.out.println(str);
        }
    }
}
