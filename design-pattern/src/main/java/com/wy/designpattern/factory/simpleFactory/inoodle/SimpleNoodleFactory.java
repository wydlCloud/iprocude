package com.wy.designpattern.factory.simpleFactory.inoodle;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname SimpleNoodleFactory
 * @Description TODO
 */

/**
 * 简单工厂模式
 * 一家“简单面馆”（简单工厂类）
 */
public class SimpleNoodleFactory {
    // 拉州拉面
    private static final int LZ = 1;
    // 泡面
    private static final int PAO = 2;
    // 热干面
    private static final int RE = 3;

    /**
     * 功能描述: 创建面条实例
     * 如果此方法是静态的，也可以成为静态工厂
     * 如果此方法不是静态的话，也可以称为简单工厂，来创建实例，也可以称为实例工厂
     *
     * @Param:
     * @Return:
     * @Author: wy
     **/
    public static INoodles createNoodle(int type) {
        switch (type) {
            case 1:
                return new LzNoodles();
            case 2:
                return new PaoNoodles();
            case 3:
                return new ReNoodles();
            default:
                return new ReNoodles();
        }
    }
}
