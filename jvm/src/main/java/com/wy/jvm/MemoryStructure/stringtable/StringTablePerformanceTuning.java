package com.wy.jvm.MemoryStructure.stringtable;

import java.io.*;

/**
 * @author wy
 * @company
 * @Classname StringTablePerformanceTuning
 * @Description 性能调优
 * 1.如果项目中，明确清楚字面量的存在特别对的话，可以提前调整StringTable的buckets的数量
 * 因为StringTable是hash结构，所以bucket的大小，决定了hash碰撞的可能性，如果hash碰撞越多，当然链表就会更长，然后会转换为红黑树
 * 所以查询的性能就会降低，这个时候，可以通过调整桶的大小，进行减少hash碰撞，提升维护成本和查询的性能
 *-Xms500m -Xmx500m -XX:+PrintStringTableStatistics -XX:StringTableSize=200000
 *
 * 2.第二种优化方案就是考虑将字符串对象是否入池
 * 因为串池是这样的，如果不入池的话，会创建很多的字符串对象，这个时候，这些对象都会再堆中进行存储，而且可能存在很多的重复的字面量
 * 如果是业务场景允许的场景下，所以可以考虑入池，入池的，字面量是不允许重复的，如果数值重复则不进行存储了，因为已经存在了，所以可以大大降低内存的使用率
 * 也可以提高查询的性能问题，这个可以通过jvisualum抽样器来进行查看，内存和String的存储数量和内存占用。
 * @Date 2020/4/19 4:14 下午
 */

public class StringTablePerformanceTuning {
    public static void main(String[] args) {
        try (BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(""),"UTF-8"))){
            String line=null;
            long l = System.nanoTime();
            while (true){
                if (line==null){
                    break;
                }
                line.intern();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
