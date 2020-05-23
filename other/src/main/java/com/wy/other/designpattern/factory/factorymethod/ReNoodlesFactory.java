package com.wy.other.designpattern.factory.factorymethod;

import com.wy.other.designpattern.factory.simpleFactory.inoodle.INoodles;
import com.wy.other.designpattern.factory.simpleFactory.inoodle.ReNoodles;

/**
 * @author wy
 * @company 唯小宝(江苏)网络科技
 * @Classname ReNoodlesFactory
 * @Description TODO
 */

public class ReNoodlesFactory implements INoodlesFactory {
    @Override
    public INoodles createNoodles() {
        return new ReNoodles();
    }
}
