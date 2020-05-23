package com.wy.designpattern.factory.simpleFactory.inoodle;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname PaoNoodles
 * @Description TODO
 */

public class PaoNoodles implements INoodles {
    @Override
    public void desc() {
        System.out.println("泡面，绝对的美味啊");
    }
}
