package com.wy.other.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created on 2019/8/21.
 * Title: Simple
 * Description:带返回值的实现线程方式，先学习一下如何实现，后面学习原理
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class Demo4 implements Callable<Integer> {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Demo4 demo4 = new Demo4();
        FutureTask<Integer> futureTask = new FutureTask<>(demo4);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println("我先做点别的事情");
        Integer re = futureTask.get();
        System.out.println("执行结果为：=" + re);

    }


    @Override
    public Integer call() throws Exception {
        System.out.println("正在进行紧张的计算");
        Thread.sleep(3000);
        return 1;
    }
}
