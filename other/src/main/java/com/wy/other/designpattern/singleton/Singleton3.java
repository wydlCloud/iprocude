package com.wy.other.designpattern.singleton;

/**
 * Created on 2019/8/22.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class Singleton3 {
    private static Singleton3 singleton3;

    private Singleton3() {
    }

    //第一种情况解决方案，这种情况会增大锁的力度，会频繁的加锁和解锁会影响性能问题
   /* public synchronized static Singleton3 getInstance() {
    //自旋 相当于while(true){}
        if (null == singleton3) {
            return new Singleton3();
        }
        return singleton3;
    }*/
    //双重判空,减小锁的力度，会提高性能，因为只有第一次进来的时候来会去加锁和释放锁，以后的线程任务就不会再走这个地方了
    public static Singleton3 getInstance() {
        if (null == singleton3) {
            synchronized (Singleton3.class) {
                //不双重判断的原因，我的理解是1.6有重入锁的出现，所以判断来增强安全性（要进行详细分析一下）
                if (null == singleton3) {
                    return new Singleton3();   //可能还会存在问题，只是正常情况下没有问题，涉及到指令重排序问题
                }
            }
        }
        return singleton3;
    }
}
