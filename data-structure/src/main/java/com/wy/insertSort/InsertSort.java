package com.wy.insertSort;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * @author wy
 * @company
 * @Classname InsertSort
 * @Description TODO
 */

public class InsertSort {


    public static void insertSort(int[] nums) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(nums, nums.length);

        int i1 = nums.length - 1;
        for (int i = 1; i <= i1; i++) {
            // 当前要排序的值
            int temp = arr[i];
            // 这一步需要处理i之前的所有数据，进行比较，直到找到前面的数据比temp小的数据为止
            for (int j = i - 1; j >= 0; j--) {
                int i2 = arr[j];
                if (temp < i2) {
                    // swap
                    arr[j+1] = arr[j];
                    // set value
                    arr[j] = temp;
                }

            }
        }
        System.out.println(JSON.toJSONString(arr));
    }

    public static void main(String[] args) {
        int[] num=new int[]{10,8,11,20,3};
        insertSort(num);
    }

}
