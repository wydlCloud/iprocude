package com.wy.other.designpattern.factory.factorymethod;

import com.wy.other.designpattern.factory.simpleFactory.inoodle.INoodles;
import com.wy.other.designpattern.factory.simpleFactory.inoodle.PaoNoodles;

/**
 * @author wy
 * @company 唯小宝(江苏)网络科技
 * @Classname PaoNoodlesFactory
 * @Description TODO
 */

public class PaoNoodlesFactory implements INoodlesFactory {
    @Override
    public INoodles createNoodles() {
        return new PaoNoodles();
    }
}
