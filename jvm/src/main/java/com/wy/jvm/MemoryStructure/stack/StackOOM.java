package com.wy.jvm.MemoryStructure.stack;

/**
 * @author wy
 * @company 唯小宝(江苏)网络科技
 * @Classname StackOOM
 * @Description 栈内存溢出OOM
 * 主要是通过创建多个线程的方式来使得栈内存溢出 oom
 * 因为在栈是线程私有的，如果一旦多线程情况下，出现oom，这种情况下，
 * 如果解决，那就是减少最大堆容量或者减小栈内存，方法区的话，因为现在已经是元空间的实现了。
 *
 * 其实分析一些内容也是比较简单的，因为在进行思考的过程中，其实很多内容，比如说：
 * 栈内存溢出 分为两种  一种是flow 一种是oom  其实flow属于是线程私有的虚拟机栈内存溢出，这个时候通过栈帧的循环创建就可以撑爆
 * oom的话，属于是整个栈内存的区域，栈内存的话，在线程创建后，会分配给线程虚拟机栈和本地方法的，每个线程创建，都会为它进行分配的。
 * 这种情况下，那位每个线程分配的内存越大，越容易导致内存溢出的风险。
 * @Date 2020/4/22 11:44 下午
 */

public class StackOOM {
    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            new Thread(() -> {
                dontStop();
            }).start();
        }
    }

    public static void main(String[] args) {
        StackOOM stackOOM=new StackOOM();
        stackOOM.stackLeakByThread();
    }


}
