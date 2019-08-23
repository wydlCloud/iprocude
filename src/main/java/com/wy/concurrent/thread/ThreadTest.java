package com.wy.concurrent.thread;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2019/4/10.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2018
 * Company:
 *
 * @author wy
 */
public class ThreadTest {


    public static void main(String[] args) {
        int CPUs =Runtime.getRuntime().availableProcessors();
        List<Integer> list  = new ArrayList();
        int loop = 10000000;
        for (int i = 0; i < loop; i++) {
            list.add(i);
        }
        int len = loop / CPUs + (loop % CPUs  == 0 ? 0 : 1);
        List<List<Integer>> partition = Lists.partition(list,len);
        long start = System.currentTimeMillis();
        for (List<Integer> integers: partition) {
            new Thread(() -> {
                integers.forEach(integer -> {int a  = integer;});
            }).start();
        }
        System.out.println("CPU count : "+CPUs + " cost time : "+ String.valueOf(System.currentTimeMillis() - start));
        System.out.println("-----------------------------------------------------");
//        int len2 = loop / 1000 + (loop % 1000  == 0 ? 0 : 1);
//        List<List<Integer>> partition2 = Lists.partition(list,len2);
//        long start2 = System.currentTimeMillis();
//        for (List<Integer> integers: partition2) {
//            new Thread(() -> {
//                integers.forEach(integer -> {int a  = integer;});
//            }).start();
//        }
//        System.out.println("CPU count : "+CPUs*2 + " cost time : "+ String.valueOf(System.currentTimeMillis() - start2));
//        System.out.println("-----------------------------------------------------");
    }
}
