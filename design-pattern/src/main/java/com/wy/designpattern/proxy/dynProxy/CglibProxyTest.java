package com.wy.designpattern.proxy.dynProxy;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname CglibProxyTest
 * @Description Cglib动态代理 生成代理对象，代理对象调用方法测试
 */

public class CglibProxyTest {
    public static void main(String[] args) {
        BuyHouseImpl rentingHouse = new BuyHouseImpl();  // 委托对象

        // 获取rentingHouse对象的代理对象，
        // Enhancer类似于JDK动态代理中的Proxy
        // 通过实现接口MethodInterceptor能够对各个方法进行拦截增强，类似于JDK动态代理中的InvocationHandler

        // 使用工厂来获取代理对象
        BuyHouseImpl cglibProxy = (BuyHouseImpl) ProxyFactory.getInstance().getCglibProxy(rentingHouse);

        cglibProxy.buyHouse();
    }
}
