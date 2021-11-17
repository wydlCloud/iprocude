package com.wy.newFeature;

import java.util.function.BinaryOperator;

/**
 * @Author wy
 */
public class Test {
    public static void main(String[] args) {
        Runnable hello_world = () -> System.out.println("hello world");

        Thread thread = new Thread(hello_world);
        thread.start();

        BinaryOperator<Long> binaryOperator = (x, y) -> x + y;
        Long apply = binaryOperator.apply(1L, 2L);
        System.out.println(apply);

        BinaryOperator<Long> longBinaryOperator = (Long x, Long y) -> x + y;
        Long apply1 = longBinaryOperator.apply(1L, 2L);
        System.out.println(apply1);
        String name = getUserName();
        name = forName();
        String finalName = name;
        Runnable runnable = () -> {
            System.out.println("hi" + finalName);
        };
        Thread thread1 = new Thread(runnable);
        thread1.start();


    }


    public static String getUserName() {
        return "zhangsan";
    }

    public static String forName() {
        return "lisi";
    }

}
