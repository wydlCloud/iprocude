package com.wy.concurrent.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2019/8/27.
 * Title: Simple
 * Description:信号量 为多线程协作提供了更为强大的控制方法。广义上说，信号量是对锁的扩展。
 * 无论是隐式锁还是显示锁，一次都只允许一个线程访问一个资源，而信号量确可以指定多个线程同时访问同一个资源
 * 信号量主要提供了两种构造函数
 * public Semaphore(int permits) {
 * sync = new NonfairSync(permits);
 * }
 * fair用来检测是公平还是非公平
 * public Semaphore(int permits, boolean fair) {
 * sync = fair ? new FairSync(permits) : new NonfairSync(permits);
 * }
 * 主要逻辑方法主要有以下五种：
 * semaphore.acquire();
 * semaphore.acquireUninterruptibly();
 * semaphore.tryAcquire();
 * semaphore.tryAcquire(5, TimeUnit.SECONDS);
 * semaphore.release();
 * <p>
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class SemaphoreDemo implements Runnable {
    public static Semaphore semaphore = new Semaphore(5, true);


    @Override
    public void run() {
        try {
            semaphore.acquire();
            //  semaphore.acquireUninterruptibly();
            // semaphore.tryAcquire();
            //  semaphore.tryAcquire(5, TimeUnit.SECONDS);
            //  semaphore.release();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "===:done!");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        final SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
        for (int i = 0; i < 20; i++) {
            executorService.submit(semaphoreDemo);
        }
    }
}
