package com.wy.other.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created on 2019/8/21.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class Demo5 {
    public static void main(String[] args) {
      /*  使用ScheduledExecutorService代替Timer less... (Ctrl+F1)

        多线程并行处理定时任务时，Timer运行多个TimeTask时，只要其中之一没有捕获抛出的异常，其它任务便会自动终止运行，使用ScheduledExecutorService则没有这个问题。

        //org.apache.commons.lang3.concurrent.BasicThreadFactory
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
                new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                //do something
            }
        },initialDelay,period, TimeUnit.HOURS);*/

     /*   Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //实现定时任务,一秒运行一次
                System.out.println("-----------------------------");
                System.out.println("timertask is run");
                System.out.println("-----------------------------");
            }
        }, 0, 1000);*/


      /*  线程池不允许使用Executors去创建，而是通过ThreadPoolExecutor的方式，这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。 说明：Executors各个方法的弊端：
        1）newFixedThreadPool和newSingleThreadExecutor:
  主要问题是堆积的请求处理队列可能会耗费非常大的内存，甚至OOM。
        2）newCachedThreadPool和newScheduledThreadPool:
  主要问题是线程数最大数是Integer.MAX_VALUE，可能会创建数量非常多的线程，甚至OOM。

        Positive example 1：
        //org.apache.commons.lang3.concurrent.BasicThreadFactory
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
                new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());



        Positive example 2：
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();

        //Common Thread Pool
        ExecutorService pool = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        pool.execute(()-> System.out.println(Thread.currentThread().getName()));
        pool.shutdown();//gracefully shutdown



        Positive example 3：
    <bean id="userThreadPool"
        class="org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor">
        <property name="corePoolSize" value="10" />
        <property name="maxPoolSize" value="100" />
        <property name="queueCapacity" value="2000" />

    <property name="threadFactory" value= threadFactory />
        <property name="rejectedExecutionHandler">
            <ref local="rejectedExecutionHandler" />
        </property>
    </bean>
                //in code
                userThreadPool.execute(thread);*/

        //理论性的东西要记住：具体知识已经涉及到操作系统层面，要先了解并行和并发的区别
        Executor threadPool = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 1000000; i++) {
            System.out.println(i);
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        System.out.println(Thread.currentThread().getName());
                    }
                }
            });
        }
    }


}
