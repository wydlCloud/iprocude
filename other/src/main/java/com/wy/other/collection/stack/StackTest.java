package com.wy.other.collection.stack;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author wy
 * @Classname StackTest
 * @Description 栈 （后进先出  基于数组实现和LinkedList中的push和pop方法是有区别的，
 * 看源码可知 stack的push是放在末尾，LinkedList的push方法是把元素放在队头）
 *
 * 限定仅在表尾进行插入和删除操作的线性表
 * 这一端被称为栈顶，相对地，把另一端称为栈底。
 * 向一个栈插入新元素又称作进栈、入栈或压栈
 * 它是把新元素放到栈顶元素的上面，使之成为新的栈顶元素；从一个栈删除元素又称作出栈或退栈，它是把栈顶元素删除掉，使其相邻的元素成为新的栈顶元素
 * @Date 2019/8/25  15:35
 * @company
 */

public class StackTest {


    public static void main(String[] args) {
        Stack stack = new Stack();
        // 将1,2,3,4,5添加到栈中
        for(int i=1; i<6; i++) {
            stack.push(String.valueOf(i));
        }

        // 遍历并打印出该栈
        iteratorThroughRandomAccess(stack) ;

        // 查找“2”在栈中的位置，并输出
        int pos = stack.search("2");
        System.out.println("num 2 ---------------------："+pos);

        // pop栈顶元素之后，遍历栈
        stack.pop();
        iteratorThroughRandomAccess(stack) ;

        // peek栈顶元素之后，遍历栈
        String val = (String)stack.peek();
        System.out.println("peek----------------------------:"+val);
        iteratorThroughRandomAccess(stack) ;

        // 通过Iterator去遍历Stack
        iteratorThroughIterator(stack) ;
    }

    /**
     * 通过快速访问遍历Stack
     */
    public static void iteratorThroughRandomAccess(List list) {
        String val = null;
        for (int i=0; i<list.size(); i++) {
            val = (String)list.get(i);
            System.out.print(val+" ");
        }
        System.out.println();
    }

    /**
     * 通过迭代器遍历Stack
     */
    public static void iteratorThroughIterator(List list) {

        String val = null;
        for(Iterator iter = list.iterator(); iter.hasNext(); ) {
            val = (String)iter.next();
            System.out.print(val+" ");
        }
        System.out.println();
    }
}
