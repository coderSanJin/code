package com.sanjin.exercies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorTest {

    public static void main(String[] args) {
        new ComparatorTest().test();
    }


    public void test() {

        CardObject cardObject1 = new CardObject();
        cardObject1.setCourse("100");
        cardObject1.setDuration("202301022222");

        CardObject cardObject2 = new CardObject();
        cardObject2.setCourse("90");
        cardObject2.setDuration("202201022222");

        CardObject cardObject3 = new CardObject();
        cardObject3.setCourse("90");
        cardObject3.setDuration("202301022223");

        CardObject cardObject4 = new CardObject();
        cardObject4.setCourse("100");
        cardObject4.setDuration("202401022222");

        ArrayList<CardObject> list = new ArrayList<>();
        list.add(cardObject1);
        list.add(cardObject2);
        list.add(cardObject3);
        list.add(cardObject4);


        //排序的决定因素是  返回值  根据返回值的正数 或者是  负数  或者是 0 来判断是否移动位置
        Collections.sort(list, new Comparator<CardObject>() {
            @Override
            public int compare(CardObject o1, CardObject o2) {
                int result = 0;
                //如果成绩相同，根据考试时间排序
                if (o1.getCourse() != null && o2.getCourse() != null && o1.getDuration() != null && o2.getDuration() != null) {
                    if (o1.getCourse().compareTo(o2.getCourse()) == 0) {
                        result = o1.getDuration().compareTo(o2.getDuration());
                    } else {
                        result = o1.getCourse().compareTo(o2.getCourse());
                    }
                }
                return result;
            }
        });

        list.forEach(vo ->{
            System.out.println(vo);
        });
    }


    class CardObject{
        private String course;

        private String duration;


        public CardObject() {
        }

        public CardObject(String course, String duration) {
            this.course = course;
            this.duration = duration;
        }

        public String getCourse() {
            return course;
        }

        public void setCourse(String course) {
            this.course = course;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        @Override
        public String toString() {
            return "CardObject{" +
                    "course='" + course + '\'' +
                    ", duration='" + duration + '\'' +
                    '}';
        }
    }
}
