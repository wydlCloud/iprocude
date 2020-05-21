package com.wy.jvm.MemoryStructure.threadDiagnosis;

/**
 * @author wy
 * @company
 * @Classname ThreadDiagnosis
 * @Description 案例一：cpu占用过多，问题排查
 * <p>
 * nohup java com.wy.jvm.ThreadDiagnosis &
 * top 后台命令，监听后台运行情况，只能定位到进程，定位不到线程
 * ps h(打印这个进程中的线程数) eo（输出感兴趣的内容） pid，tid，% cpu
 * ps H eo pid,tid,%cpu
 * ps H eo pid,tid,%cpu | grep 进程id（pid）  打印出的tid是十进制的
 * ps命令进一步定位是哪个线程引起的cpu占用过高
 * <p>
 * 使用java自带
 * jstack pid(进程id)  可以打印出pid下的线程的状态等信息  但是ps打印出的tid十进制转换为二进制的，所以要换算后进行查询具体的信息
 * <p>
 * mac系统不可用，有时间进行排查操作？？？？
 */
// todo  mac系统不可用，有时间进行排查操作？？？？已经使用linux系统进行线程诊断
// 线程诊断
public class ThreadDiagnosis {
    public static void main(String[] args) {
        new Thread(null, () -> {
            System.out.println("1.......");
            while (true) {

            }
        }, "thread1").start();

        new Thread(null, () -> {
            System.out.println("2......");
            try {
                Thread.sleep(100000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread2").start();

        new Thread(null, () -> {
            System.out.println("3......");
            try {
                Thread.sleep(100000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread3").start();
    }

}
