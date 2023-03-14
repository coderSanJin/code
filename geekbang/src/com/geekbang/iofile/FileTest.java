package com.geekbang.iofile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class FileTest {

    public static void main(String[] args) {
        File file = new File("word.txt");
        //System.out.println(file.getPath());
        //System.out.println(file.getAbsolutePath());
        //if (file.isFile()){
        //    System.out.println("存在当前文件，删除当前文件");
        //    file.delete();
        //} else {
        //    try {
        //        file.createNewFile();
        //    } catch (IOException e) {
        //        throw new RuntimeException(e);
        //    }
        //}

        if (file.exists()) {
            String name = file.getName();
            long length = file.length();
            boolean hidden = file.isHidden();
            long lastTime = file.lastModified();
            System.out.println("文件名称：" + name);
            System.out.println("文件长度是：" + length);
            System.out.println("文件是隐藏文件吗？" + hidden);
            System.out.println("文件最后修改时间是：" + lastTime);

        } else {
            System.out.println("该文件不存在");
        }
    }
}
