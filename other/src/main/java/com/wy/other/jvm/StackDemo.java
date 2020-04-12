package com.wy.other.jvm;

public class StackDemo {
    private int stackLength=1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[]args)throws Throwable {
        StackDemo stackDemo = new StackDemo();
        try{
            stackDemo.stackLeak();
        }catch(Throwable e){
            System.out.println("stack length:" + stackDemo.stackLength);
            throw e;
        }

    }
}
