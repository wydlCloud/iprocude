package com.wy.other.thread.threadPool;

import java.util.concurrent.*;

/**
 * @author wy
 * @Classname ThreadPoolDemo
 * @Description 多线程的的软件设计方法确实可以做大限度地发挥现在多核处理器的计算能力，提高生产系统的吞吐量和性能
 * 但是，若不加控制和管理的随意使用线程，对系统的性能反而会产生不利的影响。
 * <p>
 * 打印堆栈信息
 * @company
 */

public class ThreadPoolDemo implements Runnable {
    int a, b;

    public ThreadPoolDemo(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        double re = a / b;
        System.out.println("----------" + re + "-----------------");
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //在这种情况下进行输出，只有4个，也就是说漏掉了一组数据，主要是程序没有任何日志，没有任何错误信息
        // 如何进行排查呢，在这个程序中，我们可以看到应该是除以0到最后的问题的出现，但是在一些复杂的项目系统中
        //这样的错误肯定特别难以排查。
        //使用线程池是件好事情，但是还是得处处留意这些坑，线程池很有可能会吃掉程序抛出的异常，出现错误异常的难排查
        //
        //异常堆栈就好比指南针，可以为我们找到方向，有经验的我们，肯定都知道异常堆栈的好处，下面实现一下讨论异常堆栈的方法

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor
                (0, Integer.MAX_VALUE, 0L, TimeUnit.SECONDS, new SynchronousQueue<>());

        for (int i = 0; i < 5; i++) {
            //方式一
          /*  Future<?> submit = poolExecutor.submit(new ThreadPoolDemo(100, i));
            submit.get();*/
            //方式二
            poolExecutor.execute(new ThreadPoolDemo(100, i));
//通过两个异常堆栈中我们能知道异常出现在哪里，但是我们还希望得到另外一个更重要的信息，那就是这个任务到底
            //是在哪里提交的？而任务的具体提交位置已经被线程池完全淹没了，
            // 顺着堆栈，我们最多只能找到线程池中的
            //调度流程，而这对于我们几乎是没有什么价值的



        }

    }


}
