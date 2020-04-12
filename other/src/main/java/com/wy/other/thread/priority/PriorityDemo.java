package com.wy.other.thread.priority;

/**
 * @author wy
 * @Classname PriorityDemo
 * @Description 线程优先级测试
 * @Date 2019/8/26 0026 22:36
 * @company
 */

public class PriorityDemo {
    public static class HightPriority extends Thread {
        static int count = 0;

        @Override
        public void run() {
            while (true) {
                synchronized (PriorityDemo.class) {
                    count++;
                    if (count > 1000000) {
                        System.out.println("HightPriority is Complete");
                        break;
                    }
                }
            }

        }
    }

    public static class LowPriority extends Thread {
        static int count = 0;

        @Override
        public void run() {
            while (true) {
                synchronized (PriorityDemo.class) {
                    count++;
                    if (count > 1000000) {
                        System.out.println("LowPriority is Complete");
                        break;
                    }
                }
            }

        }
    }

    public static void main(String[] args) {

        Thread hightPriority = new HightPriority();

        Thread lowPriority = new LowPriority();
        hightPriority.setPriority(Thread.MAX_PRIORITY);
        lowPriority.setPriority(Thread.MIN_PRIORITY);
        lowPriority.start();
        hightPriority.start();


    }
}
