package com.wy.other.thread;

/**
 * Created on 2019/8/22.
 * Title: Simple
 * Description:
 * 锁重入(要进行更加深入的理解)
 * 同一个线程去进行访问，用同一个对象加锁的过程中，可以加进行锁重入
 * 如果多个线程进行访问，用同一个对象进行加锁，
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class Demo6 {

    public synchronized void a() {
        System.out.println("a");
        b();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void b() {
        System.out.println("b");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Demo6 demo6 = new Demo6();
        new Thread(() -> {

            demo6.a();
        }).start();

        new Thread(() -> {
            demo6.b();
        }).start();
    }
}
