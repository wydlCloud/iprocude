package com.wy.other.designpattern.proxy.staticProxy;

/**
 * @author wy
 * @company 唯小宝(江苏)网络科技
 * @Classname BuyHouseProxyImpl
 * @Description 代理对象类
 */

public class BuyHouseProxyImpl implements BuyHouse{
    private BuyHouse buyHouse;

    public BuyHouseProxyImpl(BuyHouse buyHouse) {
        this.buyHouse = buyHouse;
    }

    @Override
    public void buyHouse() {
        System.out.println("********开始验资********");
        buyHouse.buyHouse();
        System.out.println("********购买结束********");
    }
}
