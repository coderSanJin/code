package com.sanjin.exercies;

import com.sanjin.exercies.wts.ExamTimer;
import com.sanjin.exercies.wts.ExamThread;

import javax.xml.crypto.Data;
import java.util.Date;

public class WtsTest {


    public static void main(String[] args) {
        //ExamTimer exam1 = new ExamTimer();
        //exam1.setEndTime(new Date(System.currentTimeMillis() + 3600));
        //
        //ExamTimer exam2 = new ExamTimer();
        //exam2.setEndTime(new Date(System.currentTimeMillis() + 5000));
        //
        //// 创建考试线程，并启动线程
        //ExamThread thread1 = new ExamThread(exam1, "学生1");
        //ExamThread thread2 = new ExamThread(exam2, "学生2");
        //
        //thread1.start();
        //thread2.start();

        Date date = new Date();
        Date date1 = new Date(System.currentTimeMillis() + 3600);
        int i = date.compareTo(date1);
        System.out.println(i);

    }
}
