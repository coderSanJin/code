package com.sanjin.exercies;

import java.lang.String;
import java.util.Comparator;

public class StringExercies {

    public static void main(String[] args) {

        String str1,str2;
        str1 = "hello";
        str2 = "hello";
        System.out.println(str1==str2);
        System.out.println(str1.equals(str2));
        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2));
        String word1 = new String("word");
        String word2 = new String("word");
        System.out.println(System.identityHashCode(word1));
        System.out.println(System.identityHashCode(word2));
        System.out.println(word1 == word2);

        System.out.println(str1.indexOf("h"));
        System.out.println(str1.lastIndexOf("l"));
        System.out.println(str1.indexOf("s"));//返回-1表示没有检索到指定字符
        System.out.println(str1.lastIndexOf(""));
        System.out.println(str1.length());//如果检索的值是空字符串的话。则lastIndexOf()的效果和length()方法的效果保持一致。

        //charAt()  返回指定索引处的方法
        //charAt() 方法不能超过字符串的索引长度  否则会报下标越界异常
//        System.out.println(str1.charAt(5));
        System.out.println(str1.charAt(4));

        //subString()   从指定位置开始截取字符串到结尾
        System.out.println(str1.substring(1));
        //subString( , )  从指定位置截取到指定位置,指定位置索引对应的值不截取
        System.out.println(str1.substring(1, 3));
        //trim()  去除头部和尾部的空格  字符中间的空格不会进行截取
        String good = new String(" go  od ");
        System.out.println(good.trim());


        //startsWith() 是否是指定前缀的字符串  返回值boolean类型
        //endsWith()

        //compareTo()
        String s1 = "hello";
        String s2 = "word";

        System.out.println(s1.compareTo(s2));


        String time1 = "123分12秒";
        String time2 = "34分";
        System.out.println(time2.substring(0, time2.indexOf("分")));

    }
}
