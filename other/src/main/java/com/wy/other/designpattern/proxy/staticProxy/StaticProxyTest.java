package com.wy.other.designpattern.proxy.staticProxy;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname Test
 * @Description 静态代理测试类
 */

public class StaticProxyTest {

    public static void main(String[] args) {
         BuyHouse buyHouse=new BuyHouseImpl();
        BuyHouseProxyImpl buyHouseProxy = new BuyHouseProxyImpl(buyHouse);
        buyHouseProxy.buyHouse();
    }
}
