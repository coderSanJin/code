package com.sanjin.timeclass;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class CalendarTest {

    /**
     * 打印日历
     * Mon Tue Wed Thu Fri Sat Sun
     *                          1
     *  2   3   4   5   6   7   8
     *  9   10  11  12  13  14  15
     *  16  17  18  19  20  21  22
     *  23* 24  25  26  27  28  29
     *  30
     * @param args
     */

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        //获取当前月和当前日
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();
        //将date设置为这个月的第一天，并得到这一天是星期几
        date = date.minusDays(today - 1);
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();

        System . out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value; i++) {
            System.out.print("        ");
            while (date.getMonthValue() == month) {
                System.out.printf("%3d", date.getDayOfMonth());
                if (date.getDayOfMonth() == today)
                    System.out.print("*");
                else
                    System.out.print(" ");
                date = date.plusDays(1);
                if (date.getDayOfWeek().getValue() == 1)
                    System.out.println();
            }
            //下个月的值不是星期一就换行
            if (date.getDayOfWeek().getValue() != 1)
                System.out.println();
        }
    }
}
