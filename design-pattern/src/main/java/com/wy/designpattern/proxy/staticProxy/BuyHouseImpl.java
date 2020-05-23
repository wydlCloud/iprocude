package com.wy.designpattern.proxy.staticProxy;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname BuyHouseImpl
 * @Description 买房实现类
 */

public class BuyHouseImpl implements BuyHouse {
    @Override
    public void buyHouse() {
        System.out.println("要买一套别墅");
    }
}
