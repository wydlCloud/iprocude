package com.wy.other.thread.interrupedThread;

/**
 * Created on 2019/8/26.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class Interrupted {


    public static void main(String[] args) throws InterruptedException {
        //在这里虽然对thread进行了中断，但是在thread中并没有中断处理的逻辑，
        // 因此，即使thread线程被置上了中断状态，但是这个中断不会发生任何作用。
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    System.out.println("中断");
                    Thread.yield();
                }
            }
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}
