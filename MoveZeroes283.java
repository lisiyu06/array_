/**
 * Author: lisiyu
 * Created: 2020/2/23
 */

// LeetCode 283 ----- 移动零
    // 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

public class MoveZeroes283 {

    // 法 1
    public void moveZeroes1(int[] nums) {
        // 只记录非 0 的数字，修改原数组，将其按顺序放置在数组前面
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
        }
        // 将数组后面的位置全都置为 0
        for (int j = i; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    // 法 2：
    // 将不等于 0 的数放在 0 的左边，等于0 的自然就在右边了
    public void moveZeroes2(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[a];
                nums[a] = temp;
                a++;
            }
        }

    }
}
