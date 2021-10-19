package com.wy.jvm.MemoryStructure.classloader;

import lombok.SneakyThrows;

import java.io.InputStream;

/**
 * @author wy
 * @company
 * @Classname Demo
 * @Description TODO
 */

public class Demo {
    public static void main(String[] args) {
        ClassLoader classLoader = new ClassLoader(){
            @SneakyThrows
            @Override
            protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
                String fileName=name.substring(name.lastIndexOf(".")+1)+".class";
                InputStream resourceAsStream = getClass().getResourceAsStream(fileName);
                if (resourceAsStream==null){
                    return super.loadClass(name);
                }
                byte[] bytes= new byte[resourceAsStream.available()];
                resourceAsStream.read();
                return defineClass(name,bytes,0,bytes.length);
            }
        };
    }
}
