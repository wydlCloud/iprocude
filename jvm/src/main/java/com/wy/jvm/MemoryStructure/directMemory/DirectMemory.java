package com.wy.jvm.MemoryStructure.directMemory;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author wy
 * @company
 * @Classname DirectMemory
 * @Description 直接内存
 * 参数配置
 * -Xmx20M -XX:MaxDirectMemorySize=10M
 * @Date 2020/4/19 4:24 下午
 */

public class DirectMemory {

    private static final int _1MB=1024*1024;
    public static void main(String[] args) throws IllegalAccessException {
        Field declaredField = Unsafe.class.getDeclaredFields()[0];
        declaredField.setAccessible(true);
        Unsafe unsafe = (Unsafe) declaredField.get(null);
        while (true){
            unsafe.allocateMemory(_1MB);
            System.out.println("1");
        }

    }
}
