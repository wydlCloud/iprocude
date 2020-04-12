package com.wy.other.thread;

/**
 * Created on 2019/8/21.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class NewThread implements Runnable {



    @Override
    public synchronized void run() {
        //  System.out.println("Thread start .......");
        while (true) {
            try {
                // Thread.sleep(1000);
                wait();
                System.out.println("自定义线程执行.....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {

        NewThread newThread = new NewThread();
        //create thread  Assign a task
        //初始化状态
        Thread thread = new Thread(newThread);
        //start thread
        thread.start();
        while (true) {
            System.out.println("主线程执行...");
            synchronized (newThread){
                try {
                    Thread.sleep(1000);
                    newThread.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
