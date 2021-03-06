/**
 * Author: lisiyu
 * Created: 2020/2/10
 */

// LeetCode 189 ----- 旋转数组
    // 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
    // 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
    // 要求使用空间复杂度为 O(1) 的 原地 算法。

public class Rotate189 {

    // 法 1：直接遍历
    // 时间复杂度：O(n*k)
    // 空间复杂度：O(1)
    public void rotate1(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int cur = nums[nums.length - 1];
            for (int j = 0; j < nums.length;j++) {
                int temp = nums[j];
                nums[j] = cur;
                cur = temp;

            }
        }
    }

    // 法 2：反转数组
    // k % n 个元素将会被移到数组头部，前面元素向后顺移
    // 1) 将数组中所有元素反转
    // 2) 将反转后的数组的前 K 个元素反转
    // 3) 将反转后的数组的后 n-k 个元素反转
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

}
