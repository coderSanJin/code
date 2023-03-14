package com.sanjin.exercies.wts;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ExamTimer {
    private Date endTime;
    private Timer timer;

    public void startTimer(String desc) {
        TimerTask task = new TimerTask() {
            int remainingTime = (int) ((endTime.getTime() - System.currentTimeMillis()) / 1000);
            public void run() {
                if (remainingTime > 0) {
                    System.out.println(desc + ":Remaining time: " + remainingTime);
                    remainingTime--;
                } else {
                    timer.cancel();
                    System.out.println("----------------调用考试结束方法----------------");
                }
            }
        };

        timer = new Timer();
        timer.schedule(task, 0, 1000);
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}