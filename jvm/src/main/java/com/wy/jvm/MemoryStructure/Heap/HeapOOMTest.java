package com.wy.jvm.MemoryStructure.Heap;

/**
 * @author wy
 * @company
 * @Classname HeapOOMTest
 * @Description TODO
 */

public class HeapOOMTest {
    public static void main(String[] args) {
      Byte[] bytes=new Byte[70360000];
        System.out.println(bytes);
    }
}
