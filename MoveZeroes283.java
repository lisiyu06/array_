/**
 * Author: lisiyu
 * Created: 2020/2/23
 */
public class MoveZeroes283 {
    public void moveZeroes(int[] nums) {
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
}
