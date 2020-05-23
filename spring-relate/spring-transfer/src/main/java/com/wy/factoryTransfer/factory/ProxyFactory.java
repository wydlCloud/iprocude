package com.wy.factoryTransfer.factory;

import com.wy.factoryTransfer.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname ProxyFactory
 * @Description 代理工厂类
 */

public class ProxyFactory {

    private TransactionManager transactionManager;

    // 通过此方式来实现依赖注入到代理工厂中
    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    private static ProxyFactory proxyFactory=new ProxyFactory();

    public static ProxyFactory getInstance(){
        return proxyFactory;
    }
    // 通过动态代理来实现自动的事务管理机制
    public Object getJDKProxy(Object object){
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result=null;
                try{
                    // 在这里属于是做功能的增强
                    /* step1  实现开始事务*/
                    transactionManager.beginTransaction();
                    // 执行原方法
                    method.invoke(object,args);
                    // 事务提交
                    transactionManager.commit();
                }catch (Exception e){
                    e.printStackTrace();
                    // 如果抛出异常进行事务回滚
                    transactionManager.rollback();
                    throw e;
                }
                return result;
            }
        });
    }



}
