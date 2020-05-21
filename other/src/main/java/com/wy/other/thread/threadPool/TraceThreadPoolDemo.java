package com.wy.other.thread.threadPool;


import java.util.concurrent.*;

/**
 * @author wy
 * @Classname TraceThreadPoolDemo
 * @Description 我们来扩展线程池，让它在调度任务之前，先保存一下提交任务的线程的堆栈信息
 * @company
 */

public class TraceThreadPoolDemo extends ThreadPoolExecutor {

    public TraceThreadPoolDemo(int corePoolSize,
                               int maximumPoolSize,
                               long keepAliveTime,
                               TimeUnit unit,
                               BlockingQueue<Runnable> workQueue) {
        super(corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue);
    }

    @Override
    public void execute(Runnable task) {
        super.execute(wrap(task, clientTrace(), Thread.currentThread().getName()));
    }

    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(wrap(task, clientTrace(), Thread.currentThread().getName()));
    }

    private Exception clientTrace() {
        return new Exception("Client stack trace");
    }

    private Runnable wrap(final Runnable task, final Exception clientStack, String clientThreadName) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    task.run();
                } catch (Exception e) {
                    clientStack.printStackTrace();
                    throw e;
                }
            }
        };
    }


    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new TraceThreadPoolDemo(0, Integer.MAX_VALUE,
                0L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

        /**错误堆栈中可以看到在哪里提交任务*/
        for (int i = 0; i < 5; i++) {
            threadPoolExecutor.execute(new ThreadPoolDemo(100, i));
        }
    }
}
