import java.util.Arrays;

/**
 * Author: lisiyu
 * Created: 2020/1/31
 */

// LeetCode 88 ----- 合并两个有序数组
    // 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
    // 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
    // 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

public class Merge88 {

    // 法 1：双指针，从前往后
    // 时间复杂度O(m+n)，空间复杂度O(m)
    public void merge1(int[] nums1, int m, int[] nums2, int n) {

        // 拷贝一份 nums1
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        // 定义两个指针，遍历 nums1_copy 和 nums2
        int p1 = 0;
        int p2 = 0;
        // 存放 nums1 数组下标
        int p = 0;

        // 判断当前指针指向的数组元素的大小，将小的元素放置在 nums1 中，大的元素参与下一轮比较
        while (p1 < m && p2 < n) {
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
        }

        // 如果 nums1_copy 或 nums2 提前遍历结束，则将未遍历结束的数组拷贝至 nums1 后
        if (p1 < m) {
            System.arraycopy(nums1_copy, p1, nums1, p1+p2, m+n-p1-p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1+p2, m+n-p1-p2);
        }
    }

    // 法2：双指针，从后往前，不需要额外空间
    // 时间复杂度O(m+n)，空间复杂度O(1)
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        // 定义两个指针，从后向前遍历 nums1 和 nums2
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n -1;

        // 判断
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = (nums1[p1] > nums2[p2]) ? nums1[p1--] : nums2[p2--];
        }

        System.arraycopy(nums2, 0, nums1, 0, p2+1);
    }

    // 法 3：合并后排序
    // 时间复杂度 O((n+m)log(n+m))，空间复杂度O(1)
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

}
