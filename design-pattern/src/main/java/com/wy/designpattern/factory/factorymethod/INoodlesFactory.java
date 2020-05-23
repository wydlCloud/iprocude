package com.wy.designpattern.factory.factorymethod;

import com.wy.designpattern.factory.simpleFactory.inoodle.INoodles;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname INoodlesFactory
 * @Description 工厂方法类
 * 适用的场景可以这么去理解
 * 个人理解：
 * 如果有各种各样的实例，比如都是生产面条，但是面条的生产的工艺不同，每种面条有各种各样的实现方式，
 * 这样的话，在业务层再去处理关于这个实体类的相关性的实例封装，感觉有点多余，而且只创建此实例还是不够用的，因为各种各样的内容，我也是需要的
 * 这个时候，我认为可以使用工厂方法模式  就像集合框架中的，迭代器工厂方法，由每个类自己去实现自己的迭代器实体
 * <p>
 * 比如：兰州拉面
 * 泡面
 * 热干面
 * 我们使用createNoodles()方法，把以上每个实例都进行创建，当业务层呢，需要什么，就直接调用工厂实例，获取相关的实例，即可完成自己想要完成的操作
 * 如果有业务划分的话，完全可以抛离开各做各自的事情，这种情况下，也是一种比较好的一种解耦方式
 */

public interface INoodlesFactory {
    /**
     *
     * 创建面条工厂方法
     * @return
     */
     INoodles createNoodles();
}
