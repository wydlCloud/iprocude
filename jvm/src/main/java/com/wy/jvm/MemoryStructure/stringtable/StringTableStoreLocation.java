package com.wy.jvm.MemoryStructure.stringtable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wy
 * @company
 * @Classname StringTableStoreLocation
 * @Description 验证StringTable存储位置
 * 1.6方法区的实现是永久代
 * 1.8方法区的实现是元空间
 * jdk1.6，串池存储在永久代
 * jdk1.8  串池存储在堆中   java.lang.OutOfMemoryError: Java heap space
 * 在jdk1.6 下参数设置 -XX:MaxPermSize=10m
 * 在jdk1.8 下参数设置
 * -Xmx10m
 * -XX:-UseGCOverheadLimit
 * (因为官网描述如果垃圾回收超过98%的全力去回收，但是还是仅仅回收了2%的垃圾，就任务无药可救，
 * 会抛出GC overhead limit exceeded 异常，这个参数可以关闭这个检查)
 *
 * todo 还有一点需要注意的是，刚开始进行设置-UseGCOverheadLimit参数的时候，忘记了一个"-" ，后来查阅资料发现是
 * 编辑：UseSplitVerifier是Oracle JVM的布尔选项。在-或+之后:。减号禁用该选项，加号启用该选项。
 *
 *
 * todo 其实还有一点不是太明白，下面的list.add（）是往list中添加字面量数据，最后撑满的是list集合满了，抛出的oom
 * 我认为并不是可以验证StringTable存储的位置，这种验证方式我认为是不符合逻辑的。后续要验证这一点。？？？？？？
 * @Date 2020/4/19 3:43 下午
 */

public class StringTableStoreLocation {
    // 验证StringTable 串池存储在堆中，把串池撑满，其实就可以看到到底存储在哪个，抛出的oom肯定是存储位置的oom
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        try {
            for (int j = 0; j < 300000000; j++) {
                String intern = String.valueOf(j).intern();
                // list.add(String.valueOf(j).intern());
                i++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println(i);
        }
    }
}
