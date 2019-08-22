package com.wy.concurrent.first;

/**
 * Created on 2019/8/21.
 * Title: Simple
 * Description:重写run()方法
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class Demo3 {

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                System.out.println("thread start...");
            }
        }.start();

        //Thread thread=new Thread();

        new Thread(() -> System.out.println("runnable...")) {
            @Override
            public void run() {
                System.out.println("sub...");
            }
        }.start();
    }
}
