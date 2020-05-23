package com.wy.designpattern.proxy.dynProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname BuyHouseDynProxyImpl
 * @Description 动态代理，可以无侵入性的完成对方法的增强，而且还极度的降低了耦合度
 * 因为不侵入任何的代码就可以完成想要的功能，现在理解的可能比较浅显，后续要继续补充自己的理解和思想
 *
 * 面向切面编程  事务管理都可以通过动态代理方式实现
 */

public class ProxyFactory {

    // 此方式可以理解为单例模式  采用懒汉式，加载的时候进行创建对象，然后使用的时候，直接从内存中获取使用可以了
    private static ProxyFactory proxyFactory = new ProxyFactory();

    public static ProxyFactory getInstance() {
        return proxyFactory;
    }

    /**
     * Jdk动态代理
     * @param o  委托对象
     * @return   代理对象
     */
    public Object getJdkProxy(Object o) {
        return Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                // 此打印可以做方法的增强
                System.out.println("*****验资啦****");
                // 调用原方法
                Object invoke = method.invoke(o, args);
                // 此处打印可以做调用方法结束的增强
                System.out.println("*****买房结束啦*****");
                return invoke;
            }
        });
    }

    /**
     *  使用cglib动态代理生成代理对象
     * @param object  委托对象
     * @return
     */
    public Object getCglibProxy(Object object){
        return Enhancer.create(object.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object result = null;
                // 此打印可以做方法的增强
                System.out.println("*****验资啦****");
                // 调用原方法
                Object invoke = method.invoke(object, objects);
                // 此处打印可以做调用方法结束的增强
                System.out.println("*****买房结束啦*****");
                return invoke;
            }
        });
    }
}
