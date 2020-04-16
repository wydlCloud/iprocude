package com.wy.other.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created on 2019/8/2.
 * Title: Simple
 * Description:性能测试
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class ForTst {

    public static void main(String[] args) {
        List<Integer> ints = new ArrayList();
        for (int i = 0; i < 100000; i++) {
            ints.add(i);
        }
        long start = System.currentTimeMillis();
        int size = ints.size();
        for (int i = 0; i < size; i++) {
            ints.get(i);
        }
        System.out.println("fori cost time : " + String.valueOf(System.currentTimeMillis() - start));
        System.out.println("-----------------------------------------------------");
        long start2 = System.currentTimeMillis();
        for (Integer i: ints) {
            ints.get(i);
        }
        System.out.println("foreach cost time : " + String.valueOf(System.currentTimeMillis() - start2));
        System.out.println("-----------------------------------------------------");
        long start3 = System.currentTimeMillis();
        Iterator iterator = ints.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        System.out.println("iterator cost time : " + String.valueOf(System.currentTimeMillis() - start3));
        System.out.println("-----------------------------------------------------");
        long start4 = System.currentTimeMillis();
        ints.stream().forEach(integer -> {int  a = integer;});
        System.out.println("steam cost time : " + String.valueOf(System.currentTimeMillis() - start4));
        System.out.println("-----------------------------------------------------");
        long start5 = System.currentTimeMillis();
        ints.forEach(integer -> {int  a = integer;});
        System.out.println("InterfaceForEach cost time : " + String.valueOf(System.currentTimeMillis() - start5));
        System.out.println("-----------------------------------------------------");
    }



}
