package com.wy.other.designpattern.factory.factorymethod;

import com.wy.other.designpattern.factory.simpleFactory.inoodle.INoodles;

/**
 * @author wy
 * @company 唯小宝(江苏)网络科技
 * @Classname MethodFactoryTest
 * @Description TODO
 */

public class MethodFactoryTest {
    public static void main(String[] args) {
        INoodlesFactory iNoodlesFactory=new ReNoodlesFactory();
        INoodles noodles = iNoodlesFactory.createNoodles();
        noodles.desc();
    }
}
