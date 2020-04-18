package com.wy.jvm.threadDiagnosis.dielock;

/**
 * @author wy
 * @company 妈妈好网络科技
 * @Classname DieLock
 * @Description 迟迟拿不到结果  死锁
 * @Date 2020/4/17 5:27 下午
 */
public class DieLock {

   static A a=new A();
   static B b=new B();

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            synchronized (a){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b){
                    System.out.println("获得了a和b");
                }
            }
        }).start();
        Thread.sleep(1000);
        new Thread(()->{
            synchronized (b){
                try {
                    synchronized (a){
                        System.out.println("获得了a和b");
                    }
                }catch (Exception e){

                }
            }
        }).start();
    }

}
