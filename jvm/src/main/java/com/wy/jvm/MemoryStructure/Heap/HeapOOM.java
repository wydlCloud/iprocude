package com.wy.jvm.MemoryStructure.Heap;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author wy
 * @company
 * @Classname HeapOOM
 * @Description 堆内存溢出  -Xmx16m  设置堆内存的参数配置
 * 堆内存溢出：
 * 由于jvm存在垃圾回收，为什么堆内存还会溢出呢？
 * 当然垃圾回收是需要条件的，在满足对象不再被使用的时候，根据jvm的垃圾回收机制，才会进行回收对象，但是如果对象一直被使用，就不能被进行垃圾回收
 * 引用计数法，可达性分析算法两种计算是否回收对象的算法。 jvm默认选择的是可达性分析，引用计数法解决不掉循环引用的问题。后续进行深入理解
 */

public class HeapOOM {

    public static void main(String[] args) {
        int i = 0;
        List<String> list = Lists.newArrayList();
        String oom = "乌云";
        try {
            while (true) {
                oom = oom + oom;
                list.add(oom);
                i++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println(i);
        }
    }

}
