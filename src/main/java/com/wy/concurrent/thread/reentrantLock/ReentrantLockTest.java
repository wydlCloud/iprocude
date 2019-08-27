package com.wy.concurrent.thread.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created on 2019/8/27.
 * Title: Simple
 * Description:重入锁 reentrantlock
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class ReentrantLockTest implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            lock.lock();
            try {
                i++;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest test = new ReentrantLockTest();
        Thread thread = new Thread(test);
        Thread thread1 = new Thread(test);
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(i);
    }
}
