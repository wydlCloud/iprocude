package com.wy.other.designpattern.proxy.dynProxy;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname BuyHouseImpl
 * @Description 买房具体实现类
 */

public class BuyHouseImpl implements BuyHouse {
    @Override
    public void buyHouse() {
        System.out.println("买套别墅");
    }
}
