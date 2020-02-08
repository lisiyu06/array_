/**
 * Author: lisiyu
 * Created: 2020/2/8
 */

// LeetCode 167 ----- 两数之和2-输入有序数列
    // 给定一个已按照升序排列的有序数组，找到两个数使得它们相加之和等于目标数。
    // 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
    // 说明：返回的下标值（index1 和 index2）不是从零开始的。
    //      你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。

public class TwoSum167 {

    // 法 1：直接遍历
    public int[] twoSum1(int[] numbers, int target) {
        int[] ret = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if ((numbers[i] + numbers[j]) == target) {
                    ret[0] = i + 1;
                    ret[1] = j + 1;
                }
            }
        }
        return ret;
    }

    // 法 2：双指针
    public int[] twoSum2(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if ((numbers[i] + numbers[j]) == target) {
                return new int[]{i + 1, j + 1};
            } else if ((numbers[i] + numbers[j]) < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }
}
