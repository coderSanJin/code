package com.geekbang.supermarket;

import com.geekbang.supermarket.person.Customer;
import com.geekbang.supermarket.LittleSuperMarket;
import com.geekbang.supermarket.Merchandise;

import java.util.Scanner;

public class RunLittleSupperMarketAppMain {

    public static void main(String[] args) {
        LittleSuperMarket littleSuperMarket = new LittleSuperMarket();
        littleSuperMarket.address = "世纪大道666号";
        littleSuperMarket.superMarketName = "有家超市";
        littleSuperMarket.parkingCount = 200;
        littleSuperMarket.merchandises = new Merchandise[200];
        littleSuperMarket.merchandiseSold = new int[littleSuperMarket.merchandises.length];

        Merchandise[] all = littleSuperMarket.merchandises;

        for (int i = 0; i < all.length; i++) {
            Merchandise m = new Merchandise();
            m.count = 200;
            m.id = "ID" + i;
            m.name = "商品" + i;
            //Math.random()*200 代表商品的进价肯定会大于200
            m.purchasePrice = Math.random() * 200;
            m.soldPrice = (1 + Math.random() * 200);
            all[i] = m;
        }

        System.out.println("超市开门了");

        boolean open = true;
        Scanner scanner = new Scanner(System.in);
        while (open) {
            System.out.println("本店叫做" + littleSuperMarket.superMarketName);
            System.out.println("本店地址" + littleSuperMarket.address);
            System.out.println("共有停车位" + littleSuperMarket.parkingCount + "个");
            System.out.println("今天的营业额为" + littleSuperMarket.incomingSum);
            System.out.println("共有商品" + littleSuperMarket.merchandises.length + "种");

            Customer customer = new Customer();
            customer.name = "顾客编号" + ((int) (Math.random() * 10000));
            customer.money = (1 + Math.random()) * 1000;
            customer.isDrivingCar = Math.random() > 0.5;

            if (customer.isDrivingCar) {
                if (littleSuperMarket.parkingCount>0) {
                    System.out.println("欢迎" + customer.name + "驾车而来。本店已经为您安排了车位，停车免费！");
                    littleSuperMarket.parkingCount--;
                } else {
                    System.out.println("不好意思，本店车位已满。欢迎您下次光临");
                    continue;
                }
            } else {
                System.out.println("欢迎" + customer.name + "光临本店");
            }

            //记录总购买金额
            double totalCost = 0;
            while (true) {
                System.out.println("本店提供" + all.length + "种商品，欢迎选购。请输入商品编号（负数退出购物）");
                int index = scanner.nextInt();

                //退出超市
                if (index < 0) {
                    System.out.println("购物结束，欢迎下次光临");
                    break;
                }

                if (index >= all.length) {
                    System.out.println("本店没有这种商品，请输入编号在0到" + (all.length - 1));
                    continue;
                }

                Merchandise m = all[index];

                System.out.println("您选购的商品名字" + m.name + "。单价是" + m.soldPrice + "。请问您要购买多少个？");
                int numToBuy = scanner.nextInt();

                //不能输入商品数量为负数
                if (numToBuy <= 0) {
                    System.out.println("不买看看也好，欢迎继续挑选。");
                    continue;
                }

                //不能购买没有库存的
                if (numToBuy > m.count) {
                    System.out.println("本店库存没有那么多，欢迎继续挑选");
                }

                //钱不够不能购买
                if (numToBuy * m.soldPrice + totalCost > customer.money) {
                    System.out.println("您带的钱不够，欢迎继续挑选");
                    continue;
                }

                totalCost += numToBuy * m.soldPrice;

                m.count -= numToBuy;
                littleSuperMarket.merchandiseSold[index] += numToBuy;
            }

            customer.money -= totalCost;

            //离开超市，停车位归还
            if (customer.isDrivingCar) {
                littleSuperMarket.parkingCount ++;
            }

            System.out.println("顾客" + customer.name + "共消费了" + totalCost);

            littleSuperMarket.incomingSum += totalCost;

            System.out.println("还继续营业吗？(true 继续营业，false 停止营业)");

            open = scanner.nextBoolean();
        }

        System.out.println("超市关门了！");
        System.out.println("今天总营业额为" + littleSuperMarket.incomingSum + "。营业情况如下");

        for (int i = 0; i < littleSuperMarket.merchandiseSold.length; i++) {
            Merchandise m = all[i];
            int numSold = littleSuperMarket.merchandiseSold[i];
            if (numSold > 0) {
                double incomming =  m.soldPrice * numSold;
                double netIncomming = (m.soldPrice - m.purchasePrice) * numSold;
                System.out.println(m.name + "售出了" + numSold + "个。销售额为"
                        + incomming + "。净利润为" + netIncomming);

            }
        }

    }
}
