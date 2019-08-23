package com.wy.concurrent.thread;

/**
 * Created on 2019/8/21.
 * Title: Simple
 * Description:
 * 实现runnable时作为线程任务存在(面向接口编程)
 *
 * <p>
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class Demo2 implements Runnable {


    @Override
    public void run() {
        while (true) {
            System.out.println("thread running ...");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Demo2());
        thread.start();
    }
}
