import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: lisiyu
 * Created: 2020/2/13
 */

// LeetCode 268 ----- 缺失数字
    // 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。

public class MissingNumber268 {

    // 法 1：位运算(异或)
    // 数组元素与数组下标逐个进行异或，结果再与数组长度异或，结果就是缺失的数字
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public int missingNumber1(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= (i ^ nums[i]);
        }
        return missing;
    }

    // 法 2：排序
    // 时间复杂度：O(n\log n) --- 排序：O(n\log n)，遍历数组：O(n)
    // 空间复杂度：O(1)
    public int missingNumber2(int[] nums) {
        Arrays.sort(nums);
        // 缺失的是最后一个数字 n
        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        }
        // 缺失的是前面的数字
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return -1;
    }

    // 法 3：哈希表
    // 时间复杂度：O(n) --- 插入：O(n)，查询：O(1)到O(n)均有可能
    // 空间复杂度：O(n)
    public int missingNumber3(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < nums.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    // 法 4：求和
    // sumAll：数字 0 到 n 之和 ：使用等差数列求和公式：(首项 + 末项) * 项数 / 2 (求和时忽略 0)
    // sumNums：次数组元素之和
    // 两者相减即为缺失的数字
    // 时间复杂度：O(n) --- 求数组元素之和：O(n)，等差数列求和：O(1)
    // 空间复杂度：O(1)
    public int missingNumber4(int[] nums) {
        int sumAll = nums.length * (nums.length + 1) / 2;
        int sumNums = 0;
        for (int num : nums) {
            sumNums += num;
        }
        return sumAll - sumNums;
    }


}
