package com.wy.other;

/**
 * @author wy
 * @company 中国网络科技
 * @Classname TryCatchTest
 * @Description TODO
 * @ 2020/4/14 5:05 下午
 */

public class TryCatchTest {


    public static void main(String[] args) {
        DemoServiceImpl demoService=new DemoServiceImpl();
        try {
            long test = demoService.test();
        }catch (ArithmeticException e){
            System.out.println(e);
            System.out.println("world");
        }catch (Exception e){
            System.out.println(e);
            System.out.println("spring");
        }
        System.out.println("hello");
    }
}
