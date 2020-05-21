package com.wy.factoryTransfer.factory;

/**
 * @author wy
 * @company 唯小宝(江苏)网络科技
 * @Classname BeanFactory
 * @Description bean工厂
 * @Date 2020/5/21 8:18 下午
 */
public interface BeanFactory {
    /**
     * 获取bean
     *
     * @param id
     * @return
     */
    <T> T getBean(String id);

}
