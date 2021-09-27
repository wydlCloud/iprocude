package com.wy.bubbleSort;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wy
 * @company
 * @Classname BubbleSort
 * @Description
 */
@Slf4j
public class BubbleSort {
    // int[] int=[9,11,8,6,10,3,7]
    public static void bubbleSort(int[] nums) {
        log.info("排序前的数组为:{}",nums);
        // 外层排序的次数
        for (int i = 0; i < nums.length - 1; i++) {
            boolean flag = false;
            // 内存遍历进行两两比较进行交换
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                return;
            }
            log.info("第{}轮排序后的数组为:{}", i + 1, nums);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 11, 8, 6, 10, 3, 7};
        bubbleSort(nums);
    }
}
