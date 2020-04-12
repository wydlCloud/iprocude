package com.wy.other.thread.communication;

/**
 * Created on 2019/8/26.
 * Title: Simple
 * Description:线程间的通信（需要理解wait()方法需要和synchronized使用，不然运行会报错）
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class Demo {
    private volatile int signal;

    public void setSignal(int signal) {
        this.signal = signal;
    }

    public int getSignal() {
        return signal;
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        new Thread(() -> {
            synchronized (demo) {
                System.out.println("修改状态的线程执行...");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                demo.setSignal(1);
                demo.notify();
            }
        }).start();

        new Thread(() -> {
            System.out.println("模拟代码的执行...");
            //等待signal为1线程执行，否则不能执行,
            // 1.这种方式对性能是很有损耗的，可以通过sleep休眠一下，在休眠的时候是不占用CPU资源的
            //2.
            synchronized (demo) {
                while (demo.getSignal() != 1) {
                /*try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                    try {
                        demo.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //当线程为1的时候执行代码
                System.out.println("状态值修改成功...");
            }
        }).start();
    }
}
