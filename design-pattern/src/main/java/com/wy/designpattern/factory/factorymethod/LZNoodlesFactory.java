package com.wy.designpattern.factory.factorymethod;


import com.wy.designpattern.factory.simpleFactory.inoodle.INoodles;
import com.wy.designpattern.factory.simpleFactory.inoodle.LzNoodles;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname LZNoodlesFactory
 * @Description TODO
 */

public class LZNoodlesFactory implements INoodlesFactory {
    @Override
    public INoodles createNoodles() {
        return new LzNoodles();
    }
}
