package com.wy.concurrent.reflect;

import java.lang.reflect.InvocationTargetException;

/**
 * Created on 2019/4/15.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class test {
    public static void main(String[] args) {
        try {
            ReflectImplServiceImpl2 reflectImplServiceImpl2= (ReflectImplServiceImpl2) Class.forName("com.example.demo.ids.reflect.ReflectImplServiceImpl2").getConstructor(String.class).newInstance("张三");
            reflectImplServiceImpl2.sayHello();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


       /*     try {
                ReflectServiceImpl reflectService = (ReflectServiceImpl) Class.forName("com.example.demo.ids.reflect.ReflectServiceImpl").newInstance();
                reflectService.sayHello("张三");

            } catch (Exception e) {
                e.printStackTrace();
            }*/

     /*   ReflectServiceImpl target = new ReflectServiceImpl();
        try {
            //Method method=target.getClass().getMethod("sayHello", String.class);
            Method method = ReflectServiceImpl.class.getMethod("sayHello", String.class);
            try {
                method.invoke(target, "张三");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }*/}
}
