package com.wy.concurrent.designpattern;



/**
 * Created on 2019/8/22.
 * Title: Simple
 * Description:单例模式饿汉式
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */

public class Singleton1 {


    private static Singleton1 singleton1 = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return singleton1;
    }
}
