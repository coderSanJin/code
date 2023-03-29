package com.sanjin.equalsclass;

public class EqualsTest {

    /**
     * Objects.equals(object p1, object p2) 比较两个对象是否相等 如果都为空 返回true 一个不为空一个为空返回false
     * getClass()  反射获取类信息
     * equals(Object otherObject) 比价两个对象是否相等，指向同一块存储区域返回true  自定义的类应该重写该方法
     * toString() 自定义的类应该覆盖这个方法
     * getSuperclass() 返回这个类的超类的信息
     * Arrays.toString() 打印数组的信息  直接调用toString() 打印的是地址
     * Arrays.deepToString() 打印多维数组的信息
     * @param args
     */
    public static void main(String[] args) {
        Employee alice1 = new Employee("Alice Adams", 75000, 1987, 12, 15);
        Employee alice2 = alice1;
        Employee alice3 = new Employee("Alice Adams", 75000, 1987, 12,15);

        Employee bob = new Employee("Bob Brandson", 50000, 1989, 10,1);

        System.out.println("alice1 == alice2:" + (alice1 == alice2)); //true

        System.out.println("alice1 == alice3:" + (alice1 == alice3)); //false

        System.out.println("alice1.equals(alice3):" + alice1.equals(alice3)); //true

        System.out.println("alice1.equals(bob):" + alice1.equals(bob)); //false


        Manager carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBonus(5000);
        System.out.println("boss.toString();" + boss);
        System.out.println("carl.equals(boss):" + carl.equals(boss)); //false
        System.out.println("alice1.hashCode():" + alice1.hashCode());
        System.out.println("alice3.hashCode():" + alice3.hashCode());
        System.out.println("bob.hashCode():" + bob.hashCode());
        System.out.println("carl.hashCode():" + carl.hashCode());



    }
}
