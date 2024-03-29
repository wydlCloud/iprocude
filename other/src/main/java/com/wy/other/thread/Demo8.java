package com.wy.other.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wy
 * @Classname Demo8
 * @Description TODO
 * @company
 */
//jdk提供的原子类使用（解决并发问题）
//原子更新基本数据类型
//原子更新数组
//原子更新抽象类型
//原子更新字段
//保证线程安全  要满足三大特性（1.原子性  2.可见性 3.有序性）
public class Demo8 {

    private AtomicInteger value = new AtomicInteger(0);

    // private int value;

    public int getNext() {
        return value.getAndIncrement();
        // return value++;
    }

    public static void main(String[] args) {
        Demo8 demo8 = new Demo8();


        new Thread(() -> {

            while (true) {
                System.out.println(Thread.currentThread().getName() + "---" + demo8.getNext());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(() -> {

            while (true) {
                System.out.println(Thread.currentThread().getName() + "---" + demo8.getNext());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(() -> {

            while (true) {
                System.out.println(Thread.currentThread().getName() + "---" + demo8.getNext());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
