package com.wy.dataStructure.array;

/**
 * @Classname ArrayConversion
 * @Description TODO
 * @Date 2020/8/21 1:35 下午
 * @Company 杭州光云科技有限公司
 * @Author yunze
 */
public class ArrayConversion {
    public static void main(String[] args) {
        int data[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        // 方式一 定义一个新的数组而后按照逆序的方式保存（会产生无用的垃圾空间）
//        int temp[] = new int[data.length];
//        int foot = data.length - 1;
//        for (int i = 0; i < data.length; i++) {
//            temp[foot--] = data[i];
//        }
        // 在这里temp 赋值给data，主要的目的是可以有利于gc可以回收data数组，不然栈内存一直有指向关于data数据的引用，导致不能进行回收会浪费内存空间，
        // 但是这种情况下，短期内也会造成内存空间的浪费以及进行gc也会消耗系统的性能。基于时间和空间，系统性能方面都会受到影响
        // 但是如果不进行 data=temp; 则在运行期间，data数据一直不会被会受到，因为data的栈中的引用指向一直都是指向的之前的地址，所以不会被进行回收
//        data = temp;
//        printArray(data);

        // 方式二 在一个数组上进行转置,节约内存空间，减少遍历循环的次数，提高性能
        int center = data.length / 2;    //确定转换的次数
        int head = 0;
        int tail = data.length - 1;
        for (int i = 0; i < center; i++) {
            int temp2 = data[head];
            data[head] = data[tail];
            data[tail] = temp2;
            head++;
            tail--;
        }
        printArray(data);
    }

    public static void printArray(int temp[]) {
        for (int x = 0; x < temp.length; x++) {
            System.out.print(temp[x] + "、");
        }
        System.out.println();
    }
}
