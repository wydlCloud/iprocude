package com.wy.concurrent.thread.interrupedThread;

/**
 * Created on 2019/8/26.
 * Title: Simple
 * Description:中断之后要添加处理的方法，不然的话，还是检测不到线程是否被中断，置上了标记，也检测不到，需要在业务处理中自己去检测
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class DealInterrupted {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    System.out.println("未中断");
                    if (Thread.interrupted()) {
                        System.out.println("中断");
                        break;
                    }
                }
            }
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }

}
