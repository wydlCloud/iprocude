package com.wy.jvm.stack;

/**
 * @author wy
 * @company
 * @Classname StackFlowError
 * @Description 演示栈溢出 分为两种 1.栈太深，导致溢出  2.栈帧太大直接溢出（这个不大好验证）
 * 设置栈的大小
 * -Xss256K
 * The stack size specified is too small, Specify at least 160k
 * 设置栈的大小最小为160K
 *
 * @Date 2020/4/15 10:31 上午
 */

public class StackFlowError {
    static int count = 0;

    public static void main(String[] args) {
       try {
           method();
       }catch (StackOverflowError e){
           System.out.println(e);
           System.out.println(count);
       }

    }

    public static void method() {
            count++;
            method();
        }



}
