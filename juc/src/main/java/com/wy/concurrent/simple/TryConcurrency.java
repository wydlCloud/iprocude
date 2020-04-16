package com.wy.concurrent.simple;

/**
 * @author wy
 * @company
 * @Classname TryConcurrency
 * @Description TODO
 * @Date 2020/4/12 4:36 下午
 */

public class TryConcurrency {
    private static void readFromDataSource(){

        try {
            System.out.println("Begin read data from db.");
            Thread.sleep(1000);
            System.out.println("Read data done and start handle it.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Read data handle finish.");

    }

}
