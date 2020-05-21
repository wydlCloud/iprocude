package com.wy.other.listener.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname BeanUtils
 * @Description TODO
 * @Date 2020/4/24 10:48 下午
 */
public class BeanUtils implements BeanFactoryAware {

    // Spring的bean工厂
    private static BeanFactory beanFactory;
    @Override
    public void setBeanFactory(BeanFactory factory) throws BeansException {
        beanFactory=factory;
    }
    public static<T> T getBean(String beanName){
        return (T) beanFactory.getBean(beanName);
    }

}
