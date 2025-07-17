package myString;

/**
 * 给一个字符串数组 求字符串数组的最长公共前缀
 * 例：
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        int minLen = Integer.MAX_VALUE;

        //先算出字符串数组中最短字符串的位数
        for (String s : strs) {
            minLen = Math.min(minLen, s.length());
        }

        //按最短字符串位数遍历
        for (int i = 0; i < minLen; i++) {

            for (int j = 0; j < len; j++) {
                if (strs[0].charAt(i) != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0].substring(0, minLen);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }
}
