package com.wy.other.thread.stopThreadUnsafe;

/**
 * Created on 2019/8/26.
 * Title: Simple
 * Description:
 * 如果线上出了这种问题，可不是轻易能解决掉的，很难排查，因为不存在任何错误信息，
 * 但是数据确实是错了，出现了数据污染的情况，除非特别清楚要做什么，不然不能轻易使用stop（）方法
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class StopThreadUnsafe {

    public static User user = new User();
    public static volatile boolean stopName = false;

    public void setStopName() {
        stopName = true;
    }

    public static class User {
        private int id;
        private String name;

        public User() {
            id = 0;
            name = "0";
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User [id=" + id + ",name=" + name + " ]";
        }
    }

    public static class ChangeObjectThread extends Thread {
        @Override
        public void run() {
            while (true) {
                //处理办法，在合适的位置结束，可以避免问题的出现
               /* if (stopName) {
                    System.out.println("退出循环");
                    break;
                }*/
                synchronized (user) {
                    int v = (int) (System.currentTimeMillis() / 1000);
                    user.setId(v);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    user.setName(String.valueOf(v));
                }
                Thread.yield();
            }
        }
    }

    public static class ReadObjectThread extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (user) {
                    if (user.getId() != Integer.parseInt(user.getName())) {
                        System.out.println(user.toString());
                    }
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReadObjectThread().start();
        while (true) {
            Thread thread = new ChangeObjectThread();
            thread.start();
            Thread.sleep(150);
            thread.stop();
        }
    }
}
