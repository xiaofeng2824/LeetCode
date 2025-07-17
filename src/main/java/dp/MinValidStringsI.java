package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/minimum-number-of-valid-strings-to-form-target-i/
 */
public class MinValidStringsI {

    public static void main(String[] args) {

        String[] words = {"abc", "aaaaa", "bcdef"};
        String target = "aabcdabc";
        System.out.println(minValidStrings(words, target));
    }

    public static int minValidStrings(String[] words, String target) {

        int n = target.length();

        // dp[i] 表示形成 target 的前 i 个字符所需的最少字符串数
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1); // 初始化为一个较大的数，表示当前无法形成
        dp[0] = 0; // 形成空字符串不需要任何字符串

        // 用于存储每个前缀在 words 中出现的情况
        Map<String, Boolean> prefixMap = new HashMap<>();
        for (String word : words) {
            for (int i = 1; i <= word.length(); i++) {
                String prefix = word.substring(0, i);
                prefixMap.put(prefix, true);
            }
        }

        // 动态规划过程
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String substring = target.substring(j, i);
                if (prefixMap.containsKey(substring)) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n] == Integer.MAX_VALUE - 1 ? -1 : dp[n]; // 如果无法形成 target，则返回 -1
    }
}
