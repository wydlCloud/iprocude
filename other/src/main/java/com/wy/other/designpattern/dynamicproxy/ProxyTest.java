package com.wy.other.designpattern.dynamicproxy;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname ProxyTest
 * @Description TODO
 * @Date 2020/5/20 10:51 上午
 */

public class ProxyTest {
    public static void main(String[] args) {
        // 普通对象调用方法
        Tom tom = new Tom();
        tom.doSomething();
        System.out.println("----------------------------------------------------");
        // 使用代理对象调用方法实现功能增强  有时候在想，deSomething和invoke是如何关联起来的，是通过生成的代理类来关联起来的
        // 具体可以通过$Proxy0  代理类查看，就可以非常的清楚是如何进行调用的，其实比较难理解的是，代理类是如何生成的。
        Person person = (Person) new DynamicproxyTom(new Tom()).getProxy();
        person.doSomething();
    }
}
