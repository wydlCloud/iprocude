package com.wy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Solution
 * @Description TODO
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * @Date 2020/12/10 4:40 下午
 * @Company 杭州光云科技有限公司
 * @Author yunze
 */
public class Solution1 {

    //    给定 nums = [2, 7, 11, 15], target = 9
//
//    因为 nums[0] + nums[1] = 2 + 7 = 9
//    所以返回 [0, 1]
    // todo 解法1 暴力解决方法  这种方式时间复杂度很高    循环两次，根据乘法法则来进行估算时间复杂度的话  时间复杂度T(n)=O(n^2)  空间复杂度  O(1)
    public static void main(String[] args) {
        int[] nums = {2, 5, 5, 11};
        int target = 10;
        int[] ints = twoSum(nums, target);
        int[] twoSum = twoSum1(nums, target);
        System.out.println("[" + ints[0] + "," + ints[1] + "]");
        System.out.println("[" + twoSum[0] + "," + twoSum[1] + "]");
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int count = nums[i] + nums[j];
                if (count == target) {
                    System.out.println(j);
                    int[] ints = new int[2];
                    ints[0] = i;
                    ints[1] = j;
                    return ints;
                }
            }
        }
        return new int[2];
    }

    // todo 解法2 哈希表降低时间复杂度

    //    思路及算法
//
//    注意到方法一的时间复杂度较高的原因是寻找 target - x 的时间复杂度过高。因此，我们需要一种更优秀的方法，能够快速寻找数组中是否存在目标元素。如果存在，我们需要找出它的索引。
//
//    使用哈希表，可以将寻找 target - x 的时间复杂度降低到从 O(N)O(N) 降低到 O(1)O(1)。
//
//    这样我们创建一个哈希表，对于每一个 x，我们首先查询哈希表中是否存在 target - x，然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配。
    public static int[] twoSum1(int[] nums, int target) {
        // key 每个值
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            // 在此找到target和x的差值即可，这两个值相加
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }

}
