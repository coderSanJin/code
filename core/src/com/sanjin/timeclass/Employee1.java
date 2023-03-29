package com.sanjin.timeclass;

import java.util.Date;

public class Employee1 {

    private Date hireDay;

    public Date getHireDay() {
        return (Date) hireDay.clone();
    }
}

class Employee1Test {
    public static void main(String[] args) {
        Employee1 harry = new Employee1();
        Date d = harry.getHireDay();
        double tenYearsInMilliSeconds = 10 * 365.25 * 24 * 60 * 60 * 1000;
        d.setTime(d.getTime() - (long) tenYearsInMilliSeconds);


    }
}
