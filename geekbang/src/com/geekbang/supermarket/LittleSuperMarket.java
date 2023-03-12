package com.geekbang.supermarket;

/**
 * 超市
 */
public class LittleSuperMarket {
    /**
     * 超市名称
     */
    public String superMarketName;
    /**
     * 超市地址
     */
    public String address;
    /**
     * 停车位数量
     */
    public int parkingCount;
    /**
     * 营业额总数
     */
    public double incomingSum;
    /**
     * 商品集合
     */
    public Merchandise[] merchandises;

    public int[] merchandiseSold;


    /**
     * 找到利润最高的商品
     * @return
     */
    public Merchandise getBiggestProfitMerchdise() {
        Merchandise curr = null;
        for (int i = 0; i < merchandiseSold.length; i++) {
            Merchandise m = merchandises[i];
            if (curr == null) {
                curr = m;
            } else {
                curr.calculateProfit();
                m.calculateProfit();
                if (curr.calculateProfit() < m.calculateProfit()) {
                    curr = m;
                }
            }
        }
        return curr;
    }
}
