package com.geekbang.iofile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class WriteToFilesAppMain {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        File file = createFile();

        writerToFile(file);

        System.out.println("程序执行结束");
    }

    private static void writerToFile(File targetFile) throws IOException {
        try {
            //TODO 创建一个inputStream，建立一个从文件到程序的byte数据传输流
            FileOutputStream fos = new FileOutputStream(targetFile);
            //TODO 建立一个可以消费inputStream的writer，并指定字符集，这样就可以一个个的写入字符了
            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            //TODO 使用PrintWriter，可以方便的写入一行字符
            PrintWriter pw = new PrintWriter(osw);

            System.out.println("输入的内容会实时写入文件，如果输入空行则结束");
            while (true) {
                String lineToWriter = in.nextLine().trim();
                System.out.println("输入内容为" + lineToWriter);
                if (lineToWriter.trim().isEmpty()) {
                    System.out.println("输入结束");
                    break;
                } else {
                    pw.println(lineToWriter);
                    pw.flush();
                }
            }
            pw.close();
            osw.close();
            fos.close();
        } catch (IOException e) {
            throw new IOException("文件写入错误");
        }
    }


    private static File createFile() throws IOException {
        System.out.println("请输入文件名：");
        String fileName = in.nextLine().trim();
        File f = new File("." + File.separator + fileName + ".txt");
        if (f.exists()) {
            System.out.println("目标文件存在，删除：" + f.delete());
        }

        System.out.println(f.createNewFile());
        return f;

    }
}
