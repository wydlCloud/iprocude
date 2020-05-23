package com.wy.designpattern.dynamicproxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname DynamicproxyTom
 * @Description 自定义代理类
 */

public class DynamicproxyTom implements InvocationHandler {
    // 声明被代理的对象
    private Person person;

    public DynamicproxyTom(Person person) {
        this.person = person;
    }

    // 获取代理对象
    public Object getProxy() {
        Object proxyInstance = Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), this);
        return proxyInstance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        addClassToDisk(proxy.getClass().getName(), proxy.getClass(),"/Users/wy/project/concurrent/other/$Proxy1.class");
        System.out.println("方法前置功能增强");
        // 执行原方法
        Object invoke = method.invoke(person, args);
        System.out.println("方法后置功能增强");
        return invoke;
    }

    /**
     * 用于生产代理对象的字节码，并将其保存到硬盘上
     * @param className
     * @param cl
     * @param path
     */
    private static void addClassToDisk(String className, Class<?> cl, String path) {
        //用于生产代理对象的字节码
        byte[] classFile = ProxyGenerator.generateProxyClass(className, cl.getInterfaces());
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(path);
            //将代理对象的class字节码写到硬盘上
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
