package com.wy.other.designpattern.dynamicproxy;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname Tom
 * @Description TODO
 * @Date 2020/5/20 10:43 上午
 */

public class Tom implements Person{

    @Override
    public void doSomething() {
        System.out.println("tom做一些事情");
    }
}
