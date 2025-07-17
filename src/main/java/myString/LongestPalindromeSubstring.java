package myString;

/*
 * **Example 1:**
 * 题目描述：最长回文子串
 *Input: "babad"
 *Output: "bab"
 *Note: "aba" is also a valid answer.
 *Example 2:**
 *Input: "cbbd"
 *Output: "bb"
 */
public class LongestPalindromeSubstring {

    /*
     * 方法一：对每个字符求最长的回文子串
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        String res = s.substring(0, 1);
        // 中心位置枚举到 len - 2 即可
        for (int i = 0; i < len - 1; i++) {
            String oddStr = centerSpread(s, i, i);
            String evenStr = centerSpread(s, i, i + 1);
            String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (maxLenStr.length() > maxLen) {
                maxLen = maxLenStr.length();
                res = maxLenStr;
            }
        }
        return res;
    }

    //求出某个字符的最大回文子串
    private static String centerSpread(String s, int left, int right) {
        // left = right 的时候，此时回文中心是一个空隙，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是任意一个字符，回文串的长度是偶数
        int len = s.length();
        int i = left;
        int j = right;
        while (i >= 0 && j < len) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        // 这里要小心，跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，因此不能取 i，不能取 j
        return s.substring(i + 1, j);
    }

    public static void main(String[] args) {
        //解答失败: 测试用例:"babad" 测试结果:"ab" 期望结果:"bab" stdout:
        String a = "cbbd";
        String s = longestPalindrome(a);
        System.out.println(s);
    }

}
