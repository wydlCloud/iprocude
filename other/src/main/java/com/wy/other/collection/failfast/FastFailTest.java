package com.wy.other.collection.failfast;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wy
 * @Classname FastFailTest
 * @Description fail-fast机制
 * @company
 */

public class FastFailTest {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            list.add("fail-fast===" + i);
        }

//遍历
        new Thread(() -> {
            for (String s : list) {
                System.out.println(s);
            }
        }).start();
//add()  添加元素，改变数组结构
        new Thread(() -> {
            try {
                Thread.sleep(10);
                list.add("fail-fast===" + 10001);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
