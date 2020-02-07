import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: lisiyu
 * Created: 2020/2/4
 */

// LeetCode 217 ----- 存在重复元素
    // 给定一个整数数组，判断是否存在重复元素。
    // 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。

public class ContainsDuplicate217 {

    // 法 1：直接遍历
    // 时间复杂度 O(n*2)，空间复杂度O(1)
    public boolean containsDuplicate1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // 法 2：排序法
    // 时间复杂度O(n log(n))，空间复杂度 O(1) ----(按照排序来计算复杂度)
    public boolean containsDuplicate2(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }

    // 法 3：哈希表
    // 时间复杂度 O(n)，插入和查找各使用 n 次
    // 空间复杂度 O(n)
    public boolean containsDuplicate3(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
