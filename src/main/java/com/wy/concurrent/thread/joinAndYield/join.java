package com.wy.concurrent.thread.joinAndYield;

/**
 * Created on 2019/8/26.
 * Title: Simple
 * Description:join()方法使用
 * yield()
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class join {

    public static volatile int i;

    private static Object o = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (i = 0; i < 1000000; i++) {
            }

        });
        thread.start();
        //join（）本质是让调用线程wait（）在当前线程对象实例上，核心代码其实还是调用的wait()方法
        //它让调用线程(我的理解就是主线程)在当前线程对象上进行等待，当线程执行完成后，被等待的线程会退出前调用notifyall()方法通知所有的等待线程继续执行
        //在系统应用程序中，在Thread对象实例上使用wait()或者nofity()等方法，因为这很可能会影响系统API的工作
        thread.join();
        Thread.sleep(10);
        // thread.wait();
        // thread.join(1);
        //  Thread.sleep(2);
        System.out.println(i + "===");


    }
}
