package com.wy.jvm.MemoryStructure.methodArea;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author wy
 * @company 中国网络科技
 * @Classname JavaMethodAreaOOM
 * @Description
 * 参数命令为：-XX:MaxMetaspaceSize=9m
 * 方法区溢出，元空间溢出，因为jdk1.8 元空间是方法区的实现
 * Caused by: java.lang.OutOfMemoryError: Metaspace
 *
 * 方法区用于存放Class的相关信息，如类名，访问修饰符，常量池，字段描述，方法描述等。
 * 对于这些区域的测试，基本的思路是运行时产生大量的类去填满方法区，直到溢出。
 *
 * 下面的例子模拟的场景其实并非纯粹是一个实验，这样的应用经常会出现在实际应用中，当前的很多的主流框架，如spring，在对类进行增强时，都会
 * 使用到cglib这类字节码技术，增强的类越多，就需要越大的方法区保证动态生成的类的Class可以加载入内存
 *
 * 方法区溢出也是一种常见的内存溢出异常，一个类要被垃圾收集器回收掉，判定条件是比较苛刻的。
 * 在经常动态生成大量Class的应用中，需要特别注意类的回收情况。这类场景除了提高的cglib字节码增强和动态语言之外，基于OSGI的应用
 * 即使是同一个类文件，被不同的加载器假造也会被视为不同的类等。
 */

public class JavaMethodAreaOOM {

    public static void main(String[] args) {
        while (true){
            Enhancer enhancer=new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(objects,args);
                }
            });
            enhancer.create();
        }
    }
    static class OOMObject{
    }
}
