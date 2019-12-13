package MyMath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 杨辉三角
 */
public class YangHuiTriangle {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return Collections.emptyList();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    sub.add(1);
                } else {
                    List<Integer> upSub = list.get(i - 1);
                    sub.add(upSub.get(j - 1) + upSub.get(j));
                }
            }
            list.add(sub);
        }
        return list;
    }

    public static void main(String[] args) {
        YangHuiTriangle solution = new YangHuiTriangle();
        List<List<Integer>> generate = solution.generate(5);

        for (List<Integer> list :generate)
        {
            System.out.println(list);
        }
    }

}
