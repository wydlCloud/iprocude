package com.wy.other.thread;

/**
 * Created on 2019/8/21.
 * Title: Simple
 * Description:
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class Demo1 extends Thread {


    public Demo1(String name){
        super(name);
    }
    @Override
    public void run() {
        while (!interrupted()){
            System.out.println(getName()+"===线程执行。。。");
            try {
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Demo1 demo1 =new Demo1("first-thread");
        Demo1 demo11 = new Demo1("second-thread");

        demo1.start();
        demo11.start();

      /*  try {
            ThreadDemo.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        demo1.interrupt();
        //中断线程 现在stop方法废弃掉的原因是，因为stop方法是一直等待下去，并不是释放锁和资源
     //   threadDemo.stop();

        System.out.println("------------------");
    }
}
