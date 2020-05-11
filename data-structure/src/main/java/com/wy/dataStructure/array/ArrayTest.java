package com.wy.dataStructure.array;

import java.util.UUID;

/**
 * @author wy
 * @company 唯小宝(江苏)网络科技
 * @Classname ArrayTest
 * @Description TODO
 * @Date 2020/4/22 11:08 下午
 */

public class ArrayTest {
    public static void main(String[] args) {
        Array array=new Array(20);
        for (int i=0;i<10;i++){
            array.add(i,i);
        }
        System.out.println("获取集合的元素多少:"+array.getSize());
        System.out.println("获取集合的容量大小:"+array.getCapacity());
        array.addLast(11);
        array.addFirst(-1);
        for (int i=0;i<array.getSize();i++){
            System.out.println(array.get(i));
        }
    }
}
