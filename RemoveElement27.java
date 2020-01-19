/**
 * Author: lisiyu
 * Created: 2020/1/19
 */

// LeetCode 27 ----- 移除元素
    // 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
    // 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
    // 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

public class RemoveElement27 {
    // 时间复杂度 O(n) : i 和 j 至少遍历 2n 步
    // 空间复杂度 O(1) : 没有使用额外的数组空间
    public int removeElement1(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    // 时间复杂度 O(n) : i 和 n 最多遍历 n 次
    // 空间复杂度 O(1) : 没有使用额外的数组空间
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}
