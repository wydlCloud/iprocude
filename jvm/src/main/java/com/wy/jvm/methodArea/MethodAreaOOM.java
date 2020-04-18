package com.wy.jvm.methodArea;


import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * @author wy
 * @company 妈妈好网络科技
 * @Classname MethodAreaOOM
 * @Description jdk1.8之前是方法区内存溢出  jdk1.8以及以后是元空间内存溢出
 * 参数命令为：-XX:MaxMetaspaceSize=9m
 * java.lang.OutOfMemoryError
 * @Date 2020/4/18 4:59 下午
 */

public class MethodAreaOOM extends ClassLoader{

    public static void main(String[] args) {
        int j = 0;
        try {
            MethodAreaOOM methodAreaOOM = new MethodAreaOOM();
            for (int i = 0; i < 10000; i++, j++) {
                ClassWriter classWriter = new ClassWriter(0);
                classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "class" + i, null, "java/lang/Object", null);
                byte[] code = classWriter.toByteArray();
                methodAreaOOM.defineClass("class" + i, code, 0,code.length);
            }
        } finally {
            System.out.println(j);
        }

    }

}
