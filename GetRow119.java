import java.util.ArrayList;
import java.util.List;

/**
 * Author: lisiyu
 * Created: 2020/2/1
 */

// LeetCode 119 ----- 杨辉三角2
    // 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。

public class GetRow119 {

    public List<Integer> getRow1(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        // 第 0 列
        result.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            int pre = result.get(0);
            for (int j = 1; j < i; j++) {
                int cur = pre;
                pre = result.get(j);
                result.add(j, cur + pre);
            }
            // 最后一列，每行最后一个 1
            result.add(1);
        }
        return result;
    }

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        if (rowIndex == 0) {
            return result;
        }
        result.add(1);
        if (rowIndex == 1) {
            return result;
        }
        for (int row = 2; row <= rowIndex; row++) {
            // 第 0 列
            result.add(1);
            // 第 col 列
            for (int col = row - 1; col > 0; col--) {
                result.set(col, result.get(col) + result.get(col-1));
            }
        }
        return result;
    }
}
