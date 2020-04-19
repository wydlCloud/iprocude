package com.wy.jvm.MemoryStructure.stack;

/**
 * @author wy
 * @company
 * @Classname MethodInstanceIsThreadSafe
 * @Description 方法内的局部变量是否是线程安全？验证
 * @Date 2020/4/15 10:35 上午
 */

public class MethodInstanceIsThreadSafe {
public static StringBuilder builder=new StringBuilder();
    // main方法也是一个方法，也会被存储到栈中，这一步不存在线程不安全的问题
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(1);
        stringBuilder.append(2);
        stringBuilder.append(3);
        System.out.println(stringBuilder);
    }

    // 这个方法，局部变量，作用域在自己的方法范围内，并未逃离方法的作用域，因为调用一个方法的时候，会创建一个一个栈帧存储在栈中，
    // 没调用一个方法都会存储，所以方法内部的局部变量，只要未逃离方法的作用域，都不会存在线程不安全的情况，因为是私有的
    public static void m1() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(4);
        stringBuilder.append(5);
        stringBuilder.append(6);
        System.out.println(stringBuilder.toString());
    }

    // 但是这个就存在线程不安全的风险，因为入参是stringBuilder，因为在这个时候，入参是从外部传递过来的，可能会同时存在多个线程同时调用此方法
    // 如果stringBuilder是共享变量，则可能会存在线程不安全的风险，存在线程不安全的情况，
    // 因为多个线程是操作的同一个内存资源，可能会覆盖掉或者追加一定的值，和想达到的预期是不同的
    // 而且这种方式，其实可以理解为，逃离了方法的作用域，就存在线程不安全的风险
    public static void m2(StringBuilder stringBuilder) {
        stringBuilder.append(7);
        stringBuilder.append(8);
        stringBuilder.append(9);
        System.out.println(stringBuilder.toString());
    }


    // 这个方法呢，我的理解是不存在线程安全的风险，因为返回值是stringBuilder，因为如果返回值是stringBuilder，所以可能存在多个线程获取到的是同一个stringBuilder，
   // 我的理解是这样的，这个方法会再调用这个方法的调用栈中，在栈中会添加一个栈帧进去，然后进行通过jvm指定来进行执行方法，这个内部呢有局部变量，是每次调用此方法都会创建该对象
    // 创建的对象是存储在堆中的，但是局部变量是存储在栈中的，ABC三个线程进行调用该方法的时候，都会创建一个新的对象出来，每个对象都是线程调用线程私有的，并发情况下，都会返回不同的对象
    // 另外那个方法如果也是并发调用的话，调用m3方法的时候，其实也是会每次都会放在调用栈中栈帧，这个局部变量也是每次都会创建对象，并指向新的地址的，所以我认为，并发情况下，也不会出现线程不安全的情况的
    // 但是有些人说，这个对象逃离了这个方法的作用域，其他方法获取到此对象了，就可以并发的对这个对象去做事情了，但是什么场景之下可以通过此对象可以并发的去做事情呢，我认为不存在的啊
    // 因为栈是线程私有的，而且栈帧也是在栈中进行入栈的，也是线程私有的，每次调用一个方法，此方法都都会在此方法中添加一个栈帧，此方法也会每次都创建一个对象，并发情况下，也是操作的不同的对象
    // todo 所以我认为这么说是不对的，可能我的理解也是有问题的，后续随着知识的加深再次来验证这个问题？？？？？？？？？？
    public static StringBuilder m3() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(1);
        stringBuilder.append(2);
        stringBuilder.append(3);
        return stringBuilder;
    }

    public static void m4() {
        String s = "hello";
        // 如果是并发请求的情况下是不是存在问题了呢，就是说，从m3获取到了对象，多个线程进行请求的时候，A B 两个线程，A执行到stringBuilder.append("11"); 挂起了，
        // B 线程进来了，
        StringBuilder stringBuilder = m3();

    }
}
