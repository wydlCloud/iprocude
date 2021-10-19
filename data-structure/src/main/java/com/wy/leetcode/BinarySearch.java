package com.wy.leetcode;

/**
 * @author wy
 * @company
 * @Classname BinarySearch
 * @Description 二分查找
 */

public class BinarySearch {
    // nums = [-1,0,3,5,9,12], target = 9
    public static void main(String[] args) {
        int[] ints=new int[]{-1,0,3,5,9,12};
        int search = search(ints, 9);
        System.out.println(search);
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        // 数组肯定是排好序的，所以就意味着二分  那就是  hig+low / 2 就是二分
        // 如果目标值target > 中间值 那就在右边  反之 如果小于，那就在左边
//        如果 {nums}[i] = {target}nums[i]=target，则下标 ii 即为要寻找的下标；
//        如果 {nums}[i] > {target}nums[i]>target，则 {target}target 只可能在下标 ii 的左侧；
//        如果 {nums}[i] < {target}nums[i]<target，则 {target}target 只可能在下标 ii 的右侧。
        while (high > low) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == target) {
                return nums[mid];
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        return -1;
    }
}
