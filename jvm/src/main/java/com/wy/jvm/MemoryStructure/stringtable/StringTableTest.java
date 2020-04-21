package com.wy.jvm.MemoryStructure.stringtable;

import java.text.MessageFormat;

/**
 * @author wy
 * @company 妈妈好网络科技
 * @Classname StringTableTest
 * @Description TODO
 * @Date 2020/4/20 8:29 下午
 */

public class StringTableTest {
    public static void main(String[] args) {
        String s=new String("1");
        String intern = s.intern();
        String s1="1";
        System.out.println(s==s1);
        System.out.println(s==intern);
        System.out.println(s1==intern);


        System.out.println("=============");
        String s2=new String("2");
        String intern1 = s2.intern();
        String s3="2";
        System.out.println(s3==intern1);
        System.out.println(s3==s2);

    }
}
