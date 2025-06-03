package myArray;

import java.util.Arrays;

public class MinimumCost {

    public static void main(String[] args) {
      int  m = 3, n = 2; int[] horizontalCut = {1,3}, verticalCut = {5};
        System.out.println(minimumCost(m,n,horizontalCut,verticalCut));
    }

    public static long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut); // 下面倒序遍历
        Arrays.sort(verticalCut);
        long ans = 0;
        int i = 0;
        int j = 0;
        while (i < m - 1 || j < n - 1) {
            if (j == n - 1 || i < m - 1 && horizontalCut[i] < verticalCut[j]) {
                ans += horizontalCut[i++] * (n - j); // 上下连边
            } else {
                ans += verticalCut[j++] * (m - i); // 左右连边
            }
        }
        return ans;
    }
}
