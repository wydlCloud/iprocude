package com.wy.concurrent.thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created on 2019/8/2.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class ThreadPoolExcutorDemo {
    private static int produceTaskSleepTime = 5;
    private static int corePoolSize = 5;
    private static int maximumPoolSize = 100;

    private static int consumeTaskSleepTime = 5000;
    private static int produceTaskMaxNumber = 20; //定义最大添加10个线程到线程池中
    private static Map<Long, LinkedBlockingQueue> mapQueue = new HashMap<>();


    private static List<Integer> list1 = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {


       ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(100,100,10,TimeUnit.SECONDS,new LinkedBlockingQueue(100));
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(100);
        List<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.execute(() -> {
                for (int l = 0; l < 100; l++) {
                    list.add(l);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println("cost time : " + String.valueOf(System.currentTimeMillis() - start));

    }
}
