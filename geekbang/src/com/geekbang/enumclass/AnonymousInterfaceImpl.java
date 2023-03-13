package com.geekbang.enumclass;

/**
 * 定义一个接口实现类
 */
public class AnonymousInterfaceImpl implements AnonymousInterface{

    /**
     * 实现抽象方法
     */
    @Override
    public void show() {
        System.out.println("接口的实现类");
    }
}
