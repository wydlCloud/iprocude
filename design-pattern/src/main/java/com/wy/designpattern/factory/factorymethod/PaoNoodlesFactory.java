package com.wy.designpattern.factory.factorymethod;

import com.wy.designpattern.factory.simpleFactory.inoodle.INoodles;
import com.wy.designpattern.factory.simpleFactory.inoodle.PaoNoodles;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname PaoNoodlesFactory
 * @Description TODO
 */

public class PaoNoodlesFactory implements INoodlesFactory {
    @Override
    public INoodles createNoodles() {
        return new PaoNoodles();
    }
}
