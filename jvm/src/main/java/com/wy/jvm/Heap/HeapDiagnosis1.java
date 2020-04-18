package com.wy.jvm.Heap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wy
 * @company 妈妈好网络科技
 * @Classname HeapDiagnosis1
 * @Description 垃圾回收确没有把垃圾回收掉，问题排查代码演示
 * 排查思路，jvisaulvm打开，先进行垃圾回收，然后heap dump 然后可以进行查看对象内存占用，具体可以进行查看
 * @Date 2020/4/18 4:25 下午
 */

public class HeapDiagnosis1 {
    public static void main(String[] args) throws InterruptedException {
        List<Student> list=new ArrayList<>();
        for (int i=0;i<200;i++){
            list.add(new Student());
        }
        Thread.sleep(10000000000L);
    }
    static class Student{
        private byte[] bytes=new byte[1024*1024*10];
    }
}
