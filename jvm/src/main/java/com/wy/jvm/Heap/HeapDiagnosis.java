package com.wy.jvm.Heap;

/**
 * @author wy
 * @company 妈妈好网络科技
 * @Classname HeapDiagnosis
 * @Description TODO
 * @Date 2020/4/18 3:12 下午
 */

public class HeapDiagnosis {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("1......");
        Thread.sleep(30000);
        byte[] bytes=new byte[1024*1024*10];
        System.out.println("2.......");
        Thread.sleep(30000);
        bytes=null;
        System.gc();
        System.out.println("3.......");
        Thread.sleep(30000);
    }

}