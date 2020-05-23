package com.wy.designpattern.factory.simpleFactory.inoodle;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname LzNoodles
 * @Description TODO
 */

public class LzNoodles implements INoodles {
    @Override
    public void desc() {
        System.out.println("兰州拉面，很美味啊");
    }
}
