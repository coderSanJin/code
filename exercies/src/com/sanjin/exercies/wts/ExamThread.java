package com.sanjin.exercies.wts;

public class ExamThread extends Thread {
    private ExamTimer exam;
    private String desc;

    public ExamThread(ExamTimer exam, String desc) {
        this.exam = exam;
        this.desc = desc;
    }

    public void run() {
        exam.startTimer(desc);
    }
}
