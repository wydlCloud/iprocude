package com.wy.concurrent.designpattern.singleton;



/**
 * Created on 2019/8/22.
 * Title: Simple
 * Description:单例模式懒汉式,这两种情况都存在线程不安全的情况
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class Singleton2 {

    private static Singleton2 singleton2;

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        if (null == singleton2) {
            return new Singleton2();
        }
        return singleton2;
    }
}
