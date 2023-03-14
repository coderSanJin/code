package com.geekbang.iofile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TestFile {

    //TODO 不同操作系统代表文件路径的值不同
    //TODO MAC 或者 Linux 可以写为～代表 home 目录
    private static final String ROOT = "." + File.separator;
    private static Scanner scanner = new Scanner(System.in);

    //public static void main(String[] args) throws IOException {
    //    //System.out.println("文件路径分隔符：" + File.separator); //TODO /
    //    //System.out.println("环境变量分割符  " + File.pathSeparator); //TODO :
    //
    //    File dir = createDirs();
    //
    //    File newDir = renameDir(dir);
    //    if (newDir == null) return;
    //
    //    String fileName = createFiles(newDir);
    //
    //    String fileNameNew = renameFiles(newDir, fileName);
    //
    //    deleteFiles(newDir, fileNameNew);
    //
    //    deleteDir(newDir);
    //
    //}


    private static File createDirs() {
        ArrayList<String> pathList = new ArrayList<>();
        while (true) {
            System.out.println("请输入文件路径，如果为空则结束");
            String path = scanner.nextLine();
            if (path.isEmpty()) {
                break;
            }
            pathList.add(path);
        }

        return createDir(pathList.toArray(new String[0]));
    }

    private static File createDir(String... restPaths) {
        String rest = joinResDir(restPaths);
        System.out.println("将在" + ROOT + "下创建" + rest);
        File dir = new File(ROOT, rest);
        if (dir.exists() && dir.isDirectory()) {
            System.out.println("文件夹已经存在" + dir.toString());
            return dir;
        } else {
            boolean createSuccess = dir.mkdirs();
            if (createSuccess) {
                return dir;
            } else {
                throw new IllegalArgumentException("无法在" + ROOT + "下创建" + rest);
            }
        }
    }


    private static String joinResDir(String... restPaths) {
        return Arrays.stream(restPaths).map(String::trim).collect(Collectors.joining(File.separator));
    }

    private static File renameDir(File dir) {
        System.out.println("请输入新的文件夹的名字：");
        String newDirName = scanner.nextLine().trim();

        File newDir = new File(dir.getParentFile(), newDirName);
        boolean renameSuccess = dir.renameTo(newDir);

        if (renameSuccess) {
            System.out.println("改名为" + newDirName + "成功");
        } else {
            System.out.println("改名为" + newDirName + "失败");
            return null;
        }
        return newDir;
    }

    private static String createFiles(File newDir) throws IOException {
        System.out.println("请输入文件名的前缀：");
        String fileName = scanner.next().trim();

        for (int i = 0; i < 20; i++) {
            File f = new File(newDir, fileName + i + ".txt");
            System.out.println("创建文件" + f.getName() + "：" + f.createNewFile());
        }

        return fileName;
    }

    private static String renameFiles(File newDir, String fileName) {
        System.out.println("请输入新的文件名的前缀：");
        String filenameNew = scanner.next().trim();

        for (int i = 0; i < 20; i++) {
            File f = new File(newDir, fileName + i + ".txt");
            File fn = new File(newDir, filenameNew + i + ".txt");
            System.out.println("重命名文件" + f.getName() + "：" + f.renameTo(fn));
        }

        return filenameNew;
    }

    private static void deleteFiles(File newDir, String fileNameNew) {
        System.out.println("删除文件？");

        boolean deleteFiles = scanner.nextBoolean();

        if (deleteFiles) {
            for (int i = 0; i < 20; i++) {
                File fn = new File(newDir, fileNameNew + i + ".txt");
                System.out.println("删除文件" + fn.delete());
            }
        }
    }

    private static void deleteDir(File newDir) {
        System.out.println("删除文件夹？");
        boolean deleteDir = scanner.nextBoolean();

        //TODO 删除文件夹的前提是文件夹下面是空的，否则删除失败
        if (deleteDir) {
            String[] split = newDir.getName().split(File.separator);
            System.out.println("删除文件夹：" + newDir.delete());
        }
    }

}
