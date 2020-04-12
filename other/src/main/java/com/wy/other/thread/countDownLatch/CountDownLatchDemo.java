package com.wy.other.thread.countDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created on 2019/8/27.
 * Title: Simple
 * Description:倒计时器
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class CountDownLatchDemo implements Runnable {
    //生成一个CountDownLatch实例，计数数量为10,这表示需要有10个线程完成任务，
    //等待在CountDownLatch上的线程才会继续执行。
    static final CountDownLatch end = new CountDownLatch(10);
    static final CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo();

    @Override
    public void run() {
        try {
            //模拟检查任务
            Thread.sleep(new Random().nextInt() * 100);
            System.out.println("check complete");
            //使用了countDown()方法，也就是通知CountDownLatch,一个线程已经结束，倒计时器可以减1了
            end.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(countDownLatchDemo);
        }
        //等待检查
        //要求主线程等待所有10个检查任务全部完成，待10个线程全部完成后，主线程才能继续执行操作，
        //主线程在CountDownLatch上等待，当所有检查任务全部完成后，主线程方能继续执行。
        end.await();
        System.out.println("============fire！=========");
        executorService.shutdown();
    }
}
