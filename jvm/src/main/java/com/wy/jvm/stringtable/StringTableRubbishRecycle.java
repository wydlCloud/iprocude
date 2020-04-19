package com.wy.jvm.stringtable;

/**
 * @author wy
 * @company 妈妈好网络科技
 * @Classname StringTableRubbishRecycle
 * @Description 串池的垃圾回收
 *
 * -Xmx10m -XX:+PrintStringTableStatistics -XX:+PrintGCDetails -verbose:gc
 *
 * 可以通过查看StringTable statistics:来进行查看entries 的数量来查看是否有进行垃圾回收，
 * 其实是有进行垃圾回收的
 * @Date 2020/4/19 4:08 下午
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
