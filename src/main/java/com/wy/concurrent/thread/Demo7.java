package com.wy.concurrent.thread;

/**
 * Created on 2019/8/22.
 * Title: Simple
 * Description:死锁问题  可以描述为1->2 2->1   1要获取2   2要获取1  1被占用了，2也被占用了  1获取不到2  2也获取不到1  就一直等待被锁定， 就形成了死锁
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class Demo7 {
    private Object object = new Object();
    private Object object1 = new Object();

    public void a() {
        synchronized (object) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object1) {
                System.out.println("a");
            }
        }
    }

    public void b() {
        synchronized (object1) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object) {
                System.out.println("b");
            }
        }
    }

    public static void main(String[] args) {
        Demo7 demo7 = new Demo7();

        new Thread(() -> demo7.a()).start();
        new Thread(() -> demo7.b()).start();

    }
}
