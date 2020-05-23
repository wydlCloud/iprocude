package com.wy.other.designpattern.factory.factorymethod;

import com.wy.other.designpattern.factory.simpleFactory.inoodle.INoodles;
import com.wy.other.designpattern.factory.simpleFactory.inoodle.LzNoodles;

/**
 * @author wy
 * @company 唯小宝(江苏)网络科技
 * @Classname LZNoodlesFactory
 * @Description TODO
 */

public class LZNoodlesFactory implements INoodlesFactory {
    @Override
    public INoodles createNoodles() {
        return new LzNoodles();
    }
}
