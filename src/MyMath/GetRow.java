package MyMath;

import java.util.ArrayList;
import java.util.List;

/**
 * 输出杨辉三角的某一行
 */
public class GetRow {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; ++i) {
            res.add(1);
            for (int j = i - 1; j > 0; --j) {
                res.set(j, res.get(j - 1) + res.get(j));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        GetRow solution = new GetRow();
        System.out.println(solution.getRow(5));
    }
}
