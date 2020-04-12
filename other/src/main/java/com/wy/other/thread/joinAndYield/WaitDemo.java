package com.wy.other.thread.joinAndYield;

/**
 * Created on 2019/8/27.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class WaitDemo implements Runnable {

    public static Object o = new Object();

    @Override
    public synchronized void run() {
        try {
            for (int i = 0; i < 10000000; i++) {
                System.out.println("开启线程");
                Thread.sleep(100);
                System.out.println(i);
                System.out.println("线程休眠");
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notifyAll();
    }

    public static void main(String[] args) throws InterruptedException {

        WaitDemo waitDemo = new WaitDemo();
        Thread thread = new Thread(waitDemo);
        thread.start();
        System.out.println("主线程执行结束");
        Thread.sleep(2000);
        while (true) {
            synchronized (waitDemo) {
                waitDemo.notify();
            }
        }
    }
}
