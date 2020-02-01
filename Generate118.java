import java.util.ArrayList;
import java.util.List;

/**
 * Author: lisiyu
 * Created: 2020/2/1
 */

// LeetCode 118 ----- 杨辉三角
    // 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。

// 1. 第一行是固定的， 就只有1
// 2. 第二行是固定的，就只有两个1
// 3. 任意一行，开头和结尾都是1
// 4. 第 i 行，有 i 列
// 5. 第 i 行的 j 列，这个数字是根据 i -1 行，j -1 列的和 j 列相加

public class Generate118 {
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        // 第一行
        List<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if (numRows == 1) {
            return result;
        }

        // 第二行
        List<Integer> secondLine = new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if (numRows == 2) {
            return result;
        }

        // 第三行往后
        for (int row = 3; row <= numRows; row++) {
            // 为了知道当前行的内容，需要先知道上一行的内容
            // row 本来是从 1 开始计数的
            // row - 1 是把从 1 开始计数的数字转成下标
            // row - 1 - 1 是取到上一行的下标
            List<Integer> preLine = result.get(row-1-1);
            // 创建一个表示当前行的 List
            List<Integer> curLine = new ArrayList<>();
            // 把当前行中填充一些元素
            // 当前行的第 0 列一定是 1
            curLine.add(1);
            // 后续的列都是很久 prevLine 来获取的
            // 如果是针对第三行，
            for (int col = 1; col < row - 1; col++) {
                curLine.add(preLine.get(col-1) + preLine.get(col));
            }
            // 填充当前行的最后一列
            curLine.add(1);
            result.add(curLine);
        }
        return result;
    }
}
