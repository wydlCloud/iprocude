package com.wy.concurrent.thread.communication;


/**
 * Created on 2019/8/26.
 * Title: Simple
 * Description:volatile 线程之间的通信
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class Demo2 {

    private volatile int signal;

    public synchronized int getSignal() {
        System.out.println(Thread.currentThread().getName() + "方法执行了");
        if (signal != 1) {
            try {
                //调用wait方法会释放锁
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "方法执行完毕");
        return signal;
    }

    public synchronized void setSignal(int signal) {
        this.signal = signal;
        notify();//会随机唤醒一个wait等待状态的线程
        //notifyAll();//会唤醒所有wait等待状态的线程
    }

    public static void main(String[] args) {

        Demo2 demo2 = new Demo2();

        Target1 target1 = new Target1(demo2);

        Target2 target2 = new Target2(demo2);
        new Thread(target1).start();
        new Thread(target1).start();
        new Thread(target1).start();
        new Thread(target1).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(target2).start();
    }
}
