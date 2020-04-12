package com.wy.other.collection.vector;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created on 2019/8/30.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class VectorDemo {

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector();
        for (int i = 0; i < 10000000; i++) {
            vector.add(i);
        }
        long start = System.currentTimeMillis();
        int size = vector.size();
        for (int i = 0; i < size; i++) {
            vector.get(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("---------------------" + (end - start) + "---------------------");


        long start1 = System.currentTimeMillis();
        Iterator iterator = vector.iterator();
        while (iterator.hasNext()) {
            iterator.next();

        }
        long end1 = System.currentTimeMillis();
        System.out.println("-----------" + (end1 - start1) + "--------------------");

        long start2 = System.currentTimeMillis();
        for (Integer integer : vector) {

        }
        long end2 = System.currentTimeMillis();
        System.out.println("-----------" + (end2 - start2) + "--------------------");

        long start3 = System.currentTimeMillis();
        Enumeration enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            enumeration.nextElement();
        }
        long end3 = System.currentTimeMillis();
        System.out.println("-----------" + (end3 - start3) + "--------------------");

    }
}
