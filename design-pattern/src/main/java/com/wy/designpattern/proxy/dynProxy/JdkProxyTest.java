package com.wy.designpattern.proxy.dynProxy;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname JdkProxyTest
 * @Description jdk动态代理测试类
 */

public class JdkProxyTest {
    public static void main(String[] args) {
        // 获取代理工厂
        ProxyFactory instance = ProxyFactory.getInstance();
        // 从代理工厂生产代理对象   // 委托对象---委托方 new BuyHouseImpl()
        BuyHouse buyHouse = (BuyHouse) instance.getJdkProxy(new BuyHouseImpl());
        // 通过对象调用买房方法
        buyHouse.buyHouse();
    }
}
