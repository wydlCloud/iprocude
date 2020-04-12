package com.wy.other.thread.daemon;

/**
 * @author wy
 * @Classname DaemonThreadTest
 * @Description
 * 守护线程是一种比较特殊的线程，就和它的名字一样，它是系统的守护者，在后台默默地完成一些系统性的服务
 * 比如垃圾回收线程、JIT线程就可以理解为守护线程。与之相对应的就是用户线程，也可以理解为
 * 系统的工作线程，它会完成这个程序应该要完成的业务操作就会结束。如果用户线程全部结束，这也意味着
 * 这个程序实际上已经无事可做了。守护线程要守护的对象已经不存在了，那么整个应用程序就自然应该结束
 * 因此，当一个java应用内，只有守护线程时，java虚拟机就会自然退出
 * @Date 2019/8/26 22:28
 * @company
 */

public class DaemonThreadTest {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("I am alive");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //守护线程要设置在start启动之前，不然的话会【抛出异常，但是可以继续执行，只是
        //把当前线程还是当做工作线程去使用
        thread.setDaemon(true);
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
