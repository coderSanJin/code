package com.geekbang.supermarket;

/**
 * 商品
 */
public class Merchandise {
    /**
     * 主键ID
     */
    public String id;
    /**
     * 商品名称
     */
    public String name;
    /**
     * 进货量
     */
    public int count;
    /**
     * 商品售价
     */
    public double soldPrice;
    /**
     * 商品进价
     */
    public double purchasePrice;

    public void describe() {
        double netIncome = soldPrice - purchasePrice;
        System.out.println("当前商品名字叫做" + name + ", id是" + id + "。商品售价是" + soldPrice
                + "。商品进价是" + purchasePrice + "，商品库存量是" + count +
                "。销售一个的毛利润是" + netIncome);
    }

    public double calculateProfit() {
        double profit = soldPrice - purchasePrice;
        if (profit <= 0) {
            return 0;
        }
        return profit;
    }

    public double getCurrentCount() {
        return count;
    }

    public int getIntSoldPrice() {
        return (int) soldPrice;
    }

}
