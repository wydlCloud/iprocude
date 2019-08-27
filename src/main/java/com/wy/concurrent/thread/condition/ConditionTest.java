package com.wy.concurrent.thread.condition;

import com.wy.concurrent.thread.reentrantLock.ReentrantLockTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created on 2019/8/27.
 * Title: Simple
 * Description:重入锁的好搭档：Condition条件
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class ConditionTest implements Runnable {
    public static ReentrantLock reentrantLock = new ReentrantLock();
    public static Condition condition = reentrantLock.newCondition();

    @Override
    public void run() {
        try {
            reentrantLock.lock();
            condition.await();
            System.out.println("Thread is going on");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionTest conditionTest = new ConditionTest();
        Thread t1 = new Thread(conditionTest);
        t1.start();
        Thread.sleep(2000);
        //通知线程thread继续执行
        reentrantLock.lock();
        condition.signal();
        reentrantLock.unlock();
    }
}
