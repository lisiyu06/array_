/**
 * Author: lisiyu
 * Created: 2020/1/21
 */

// LeetCode 53 ----- 最大子序和
    // 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

public class MaxSubArray53 {
    // 1. 直接遍历法
//    public int maxSubArray1(int[] nums) {
//        int start = 0;
//        int end = 0;
//        int max = Integer.MIN_VALUE;
//        for (start = 0; start < nums.length; start++) {
//            int t = 0;
//            for (end = start; end < nums.length; end++) {
//                t += nums[end];
//                if (t > max) {
//                    max = t;
//                }
//            }
//        }
//        return max;
//    }

    // 2. 分治法

    //  求 （中间部分数组）包含 nums[mid] 和 nums[mid + 1] 元素 的数组元素之和
    public int crossSum(int[] nums, int left,int right, int mid) {
        if (left == right) {
            return nums[left];
        }

        // 求包含 nums[mid] 元素 和 数组左边元素 之和的最大值
        int leftSubSum = Integer.MIN_VALUE;
        int curSumL = 0;
        for(int i = mid; i >= left; i--) {
            curSumL += nums[i];
            leftSubSum = Math.max(leftSubSum, curSumL);
        }

        // 求包含 nums[mid + 1] 元素 和 数组右边元素 之和的最大值
        int rightSubSum = Integer.MIN_VALUE;
        int curSumR = 0;
        for(int i = mid + 1; i <= right; i++) {
            curSumR += nums[i];
            rightSubSum = Math.max(rightSubSum, curSumR);
        }
        // 两者相加即为 中间部分数组元素之和的最大值
        return leftSubSum + rightSubSum;
    }

    public int helper(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) / 2;

        // 左子数组元素之和
        int leftSum = helper(nums, left, mid);
        // 右子数组元素之和
        int rightSum = helper(nums, mid + 1, right);
        // 包含 nums[mid] 和 nums[mid] 元素 的数组元素之和
        int crossSum = crossSum(nums, left, right, mid);
        // 返回三者的最大值
        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return helper(nums, 0, nums.length - 1);
    }
}