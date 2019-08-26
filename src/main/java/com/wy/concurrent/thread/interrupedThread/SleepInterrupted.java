package com.wy.concurrent.thread.interrupedThread;

/**
 * Created on 2019/8/26.
 * Title: Simple
 * Description:
 * Thread.sleep()方法会让当前线程休眠一下，在这个时候去中断线程会抛出InterruptedException中断异常
 * InterruptedException不是运行时异常，也就是说程序必须捕获并且处理它，当线程在sleep()休眠时，如果被中断
 * 这个异常就会产生。
 * Sleep()和wait()：
 * sleep：让线程休眠一定的时间，不会释放任何资源
 * wait:让线程处于等待状态，会释放目标对象的
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class SleepInterrupted {
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
                    try {
                        //当休眠时线程被中断,会抛出异常，并进入catch子句进行执行，由于已经捕获了中断，我们可以立即退出线程。
                        //但是在这里我们并有这么去做，因为也许在这段代码中，我们还需要进行后续的处理。保证数据的一致性和完整性。
                        //因此，执行了interrupt方法再次中断自己，置上中断标记位，只有这么做在第23行的地方才能发现当前线程已经被中断了
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("-----------------------Interrupted When Sleep----------------------");
                        // Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                    Thread.yield();
                }
            }
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}
