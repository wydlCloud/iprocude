package com.wy.concurrent.sort;

import java.util.Arrays;

/**
 * Created on 2019/9/10.
 * Title: Simple
 * Description:
 * 算法思想：
 * 基于分治的思想，是冒泡排序的改进。首先在数组中选择一个基准点（该基准点可能影响快速排序的效率，后面讲解选取的方法），
 * 然后分别从数组的两端扫描数组，设两个指示标志（low执行起始位置，high指向结束位置），首先从后半部分开始，如果发现有元素
 * 比该基准点值小，就交换low和high 的值，然后从前半部分开始扫描，发现有元素大于基准点的值，就交换low和high的位置的值，如此往复循环，
 * 直到low》=high，然后把基准点的值放到high这个位置。一次排序就完成了，以后采用递归的方式分别对前半部分和后半部分排序，
 * 当前半部分和后半部分均有序时该数组就自然有序了。
 * <p>
 * 快速排序算法的特点
 * 快速排序的时间主要耗费在划分操作上，对长度为k的区间进行划分，共需k-1次关键字的比较；
 * 最坏情况是每次划分选取的基准都是当前无序区中关键字最小(或最大)的记录，划分的结果是基准左边的子区间为空(或右边的子区间为空)，而划分所得的另一个非空的子区间中记录数目，仅仅比划分前的无序区中记录个数减少一个。时间复杂度为O(n*n)；
 * 在最好情况下，每次划分所取的基准都是当前无序区的"中值"记录，划分的结果是基准的左、右两个无序子区间的长度大致相等。总的关键字比较次数：O(nlogn)；
 * 尽管快速排序的最坏时间为O(n*n)，但就平均性能而言，它是基于关键字比较的内部排序算法中速度最快者，快速排序亦因此而得名。它的平均时间复杂度为O(nlogn)。
 * Copyright: Copyright(c) 2019
 * Company:
 *
 * @author wy
 */
public class QuickSortDemo {

    public static void main(String[] args) {
        final int max = 15;
        int[] nums = new int[max];
        System.out.println("--------------使用的是选择排序算法---------------");
        for (int i = 0; i < max; i++) {
            nums[i] = (int) ((Math.random()) * 10 + 5);
        }
        System.out.println("---------------排序之前的数组为--------------------");
        System.out.println(Arrays.toString(nums));
        System.out.println("---------------快排之后的数组为---------------------");
        QuickSortDemo quickSortDemo = new QuickSortDemo();
        int left = 0;
        int right = nums.length - 1;
        quickSortDemo.quickSort(nums,left,right);
        System.out.println(Arrays.toString(nums));


    }

    public void quickSort(int[] nums,int left,int right) {
        //进行快速排序
        if (left < right) {
            //先分割开来
            int middle = getCompare(nums, left, right);
            //然后对左边进行排序
            quickSort(nums, left, middle - 1);
            //然后对右边进行排序
            quickSort(nums, middle + 1, right);
        }
    }

    private int getCompare(int[] nums, int left, int right) {
        //1.取基准点,取左边数据为基准点，从右边开始往左走
        int base = nums[left];
        while (left < right) {
            //从右往左走
            while (left < right && nums[right] >= base) {
                right--;
            }
            nums[left] = nums[right];
            //从左往右走
            while (left < right && nums[left] <= base) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = base;
        return left;
    }

}
