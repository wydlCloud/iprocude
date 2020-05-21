package com.wy.jvm.MemoryStructure.stringtable;

/**
 * @author wy
 * @company 中国网络科技
 * @Classname StringTableRubbishRecycle
 * @Description 串池的垃圾回收
 *
 * -Xmx10m -XX:+PrintStringTableStatistics -XX:+PrintGCDetails -verbose:gc
 *
 * 可以通过查看StringTable statistics:来进行查看entries 的数量来查看是否有进行垃圾回收，
 * 其实是有进行垃圾回收的
 */

public class StringTableRubbishRecycle {
    public static void main(String[] args) {
        int i = 0;
        try {
            for(int j=0;j<100000;j++){
                String.valueOf(j).intern();
                i++;
            }
        } catch (Throwable e) {
           e.printStackTrace();
        }finally {
            System.out.println(i);
        }
    }
}
