/**
 * Author: lisiyu
 * Created: 2020/1/21
 */

// LeetCode 53 ----- 最大子序和
    // 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

public class MaxSubArray53 {
    // 1. 直接遍历法
    public int maxSubArray1(int[] nums) {
        int start = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;
        for (start = 0; start < nums.length; start++) {
            int t = 0;
            for (end = start; end < nums.length; end++) {
                t += nums[end];
                if (t > max) {
                    max = t;
                }
            }
        }
        return max;
    }
}