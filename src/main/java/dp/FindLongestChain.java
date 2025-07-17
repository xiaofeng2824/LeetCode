package dp;

import java.util.Arrays;

public class FindLongestChain {

    public static void main(String[] args) {

//        int[][] pairs = {{1,2},{2,3},{3,4}};
        int[][] pairs = {{-10, -8}, {8, 9}, {-5, 0}, {6, 10}, {-6, -4}, {1, 7}, {9, 10}, {-4, 7}};
        System.out.println(findLongestChain(pairs));
        System.out.println(findLongestChain1(pairs));
    }


    /**
     * 贪心写法
     *
     * @param pairs
     * @return
     */
    public static int findLongestChain(int[][] pairs) {

        // 边界判断
        if (pairs == null || pairs.length == 0) {
            return 0;
        }
        // 排序 贪心  先结束的先排进来
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        int res = 0;
        int cur = Integer.MIN_VALUE;
        for (int i = 0; i < pairs.length; i++) {
            // 当前时间小于
            if (cur < pairs[i][0]) {
                res++;
                cur = pairs[i][1];
            }
        }
        return res;
    }


    /**
     * 动态规划写法
     *
     * @param pairs
     * @return
     */

    public static int findLongestChain1(int[][] pairs) {

        if (pairs == null || pairs.length == 0) {
            return 0;
        }

        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        return dp[n - 1];
    }
}
