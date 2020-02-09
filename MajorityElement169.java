import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Author: lisiyu
 * Created: 2020/2/9
 */

// LeetCode 169 ----- 多数元素
    // 给定一个大小为 n 的数组，找到其中的多数元素。
    // 多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
    // 你可以假设数组是非空的，并且给定的数组总是存在多数元素。

public class MajorityElement169 {

    // 法 1：直接遍历
    // 时间复杂度 O(n*2)
    // 空间复杂度 O(1)
    public int majorityElement1(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int count = 0;
            for (int j = i + 1; j < len; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
                if (count > (len / 2)) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    // 法 2：哈希表
    // 时间复杂度 O(n)
    // 空间复杂度 O(n)
    public int majorityElement2(int[] nums)  {
        // 第一个 Integer 表示 数组元素，第二个 Integer 表示元素出现的个数
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length / 2;
        for (int i = 0; i <nums.length; i++) {
            // 存在此元素，返回元素个数，不存在此元素，返回 0
            int count = map.getOrDefault(nums[i], 0);
            // 若此元素的个数等于 len，返回此元素
            if (count == len) {
                return nums[i];
            }
            // 新设置一个元素，和它对应的个数
            map.put(nums[i], count + 1);
        }
        return -1;
    }

    // 法 3：位运算
    // 将数组中的元素均写成 二进制形式，每一位分别与 mask = 1，mask <<= 1 相与
    // 统计出每一列上的位 出现 1 的个数
    // 将 1 过半的二进制数保存下来，组合在一起就是数组中过半的元素
    public int majorityElement3(int[] nums) {
        int cur = 0;
        for (int i = 0, mask = 1; i < 32; i++, mask <<= 1) {
            int bit = 0;
            // 计算当前列 1 的个数
            for (int j = 0; j < nums.length; j++) {
                if ((mask & nums[j]) == mask) {
                    bit++;
                }
            }
            // 判断当前列的 1的个数
            if (bit > (nums.length / 2)) {
                cur |= mask;
            }
        }
        return cur;
    }

    // 法 4：摩尔投票法
    public int majorityElement4(int[] nums) {
        int count= 0;
        int candidate = 0;
        for (int num: nums) {
            if (count == 0) {
                candidate = num;
            }
            count += ((num == candidate) ? 1: -1);
        }
        return candidate;
    }

}
