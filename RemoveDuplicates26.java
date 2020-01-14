/**
 * Author: lisiyu
 * Created: 2020/1/14
 */

// LeetCode 26 ----- 删除排序数组中的重复项
    // 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
    // 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

public class RemoveDuplicates26 {
    public int removeDuplicates(int[] nums) {
        int a = 0;
        for (int b = 1; b < nums.length; b++) {
            if (nums[b] != nums[a]) {
                if ((b - a) > 1) {
                    nums[a+1] = nums[b];
                }
                a++;
            }
        }
        return a + 1;
    }
}
