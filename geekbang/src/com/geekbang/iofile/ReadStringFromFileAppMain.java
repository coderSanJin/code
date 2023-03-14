package com.geekbang.iofile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ReadStringFromFileAppMain {

    public static void main(String[] args) {

        File file = new File("./这是我的文本文件.txt");

        classicWay(file);

        coolerWay(file);
    }

    private static void classicWay(File sourceFile) {
        System.out.println("----------经典的处理方式---------");
        try {
            //TODO 建立文件到程序的数据输入(input) 流
            FileInputStream fis = new FileInputStream(sourceFile);
            //TODO 用inputStreamReader 将这个byte 流套一下，装饰一下，
            // 并指定字符编码，让它能够将读出的byte转为字符
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            //TODO 增加缓存功能，输入输出效率更高，并且可以一次读取一行
            BufferedReader reader = new BufferedReader(isr);

            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line.trim().toUpperCase());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private static void coolerWay(File sourceFile) {
        System.out.println("---------666的处理方式---------");
        try {
            //TODO 建立文件到程序的数据输入(input) 流
            FileInputStream fis = new FileInputStream(sourceFile);
            //TODO 用inputStreamReader 将这个byte 流套一下，装饰一下，
            // 并指定字符编码，让它能够将读出的byte转为字符
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            //TODO 增加缓存功能，输入输出效率更高，并且可以一次读取一行
            BufferedReader reader = new BufferedReader(isr);

            reader.lines().map(String::trim).map(String::toUpperCase).forEach(System.out::println);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
