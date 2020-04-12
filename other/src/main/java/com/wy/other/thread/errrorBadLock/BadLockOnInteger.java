package com.wy.other.thread.errrorBadLock;

/**
 * Created on 2019/8/27.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 201
 * Company:
 *
 * @author wy
 */
public class BadLockOnInteger implements Runnable {
    private static volatile Integer i = 0;
    static BadLockOnInteger badLockOnInteger = new BadLockOnInteger();

    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            synchronized (i) {
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(badLockOnInteger);
        Thread thread1 = new Thread(badLockOnInteger);
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(i);
    }
}
