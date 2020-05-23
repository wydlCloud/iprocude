package com.wy.designpattern.factory.simpleFactory;


import com.wy.designpattern.factory.simpleFactory.inoodle.INoodles;
import com.wy.designpattern.factory.simpleFactory.inoodle.SimpleNoodleFactory;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname SimpleFactoryTest
 * @Description 简单工厂测试类
 */

public class SimpleFactoryTest {
    public static void main(String[] args) {
        INoodles noodle = SimpleNoodleFactory.createNoodle(1);
        noodle.desc();
        INoodles noodle1 = SimpleNoodleFactory.createNoodle(2);
        noodle1.desc();
        INoodles noodle2 = SimpleNoodleFactory.createNoodle(3);
        noodle2.desc();
    }
}
