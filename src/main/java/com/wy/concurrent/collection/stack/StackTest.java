package com.wy.concurrent.collection.stack;

import java.util.Stack;

/**
 * @author wy
 * @Classname StackTest
 * @Description 栈 （后进先出  基于数组实现和LinkedList中的push和pop方法是有区别的，
 * 看源码可知 stack的push是放在末尾，LinkedList的push方法是把元素放在队头）
 * @Date 2019/8/25  15:35
 * @company
 */

public class StackTest {


    public static void main(String[] args) {
        Stack<String> stack = new Stack();
        for (int i = 1; i <= 5; i++) {
            stack.push("stack---" + i);
        }
        System.out.println(stack);

        System.out.println("-------------------------------------------------------------------");
        for (int i = 1; i <= 5; i++) {
            System.out.println(stack.pop());
        }
    }
}
