package dp;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/find-the-maximum-length-of-valid-subsequence-i/?envType=daily-question&envId=2025-07-16
 * 有效子序列的最大长度
 */
public class MaximumLength {
    public static void main(String[] args) {

//        int[] nums = {1,2,3,4};
        int[] nums = {1,2,1,1,2,1,2};
        System.out.println(maximumLength(nums));
    }

    public static int maximumLength(int[] nums) {
     return maximumLength(nums, 2);
    }

    public static int maximumLength(int[] nums, int k) {
        int ans = 0;
        for (int m = 0; m < k; m++) {
            int[] f = new int[k];
            for (int x : nums) {
                x %= k;
                f[x] = f[(m - x + k) % k] + 1;
                ans = Math.max(ans, f[x]);
            }
        }
        return ans;
    }

    public int maximumLength2(int[] nums, int k) {
        int ans = 0;
        int[][] f = new int[k][k];
        for (int x : nums) {
            x %= k;
            for (int y = 0; y < k; y++) {
                f[y][x] = f[x][y] + 1;
                ans = Math.max(ans, f[y][x]);
            }
        }
        return ans;
    }
}
