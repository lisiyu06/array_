/**
 * Author: lisiyu
 * Created: 2020/2/3
 */

// LeetCode 121 ----- 买卖股票的最佳时机
    // 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    // 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
    // 注意你不能在买入股票前卖出股票。

public class MaxProfit121 {

    // 法 1：直接遍历
    // 时间复杂度：O(n*2)，循环了 (n*(n-1)) / 2 次
    // 空间复杂度：O(1)，只使用了两个变量 max 和 cur
    public int maxProfit1(int[] prices) {
        if (prices.length <= 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                int cur = prices[j] - prices[i];
                if (cur > max) {
                    max = cur;
                }
            }
        }
        return max;
    }

    // 法 2
    // 时间复杂度 ：O(n)
    // 空间复杂度：O(1)
    public int maxProfit2(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if ((prices[i] - min) > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }

    // 法 3：动态规划

}
