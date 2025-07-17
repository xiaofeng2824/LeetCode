package myString;

//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
//
//
// '.' 匹配任意单个字符
// '*' 匹配零个或多个前面的那一个元素
//
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
//
//
// 示例 1：
//
//
//输入：s = "aa" p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
//
//
// 示例 2:
//
//
//输入：s = "aa" p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
//
//
// 示例 3：
//
//
//输入：s = "ab" p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
//
//
// 示例 4：
//
//
//输入：s = "aab" p = "c*a*b"
//输出：true
//解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
//
//
// 示例 5：
//
//
//输入：s = "mississippi" p = "mis*is*p*."
//输出：false
//
//
//
// 提示：
//
//
// 0 <= s.length <= 20
// 0 <= p.length <= 30
// s 可能为空，且只包含从 a-z 的小写字母。
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
// 保证每次出现字符 * 时，前面都匹配到有效的字符
//
// Related Topics 字符串 动态规划 回溯算法
// 👍 2184 👎 0
public class RegexMatch {


    public static void main(String[] args) {

        String s = "aa", p = "a";
        //String s = "mississippi",p="mis*is*p*.";
        boolean match = isMatch(s, p);
        System.out.println(match);

    }

    /**
     * 1. 先判断第一个字符是否匹配
     * 2. 除开第一个字符，后面字符串依然是一个  子问题  用递归解决
     */
    public static boolean isMatch(String s, String p) {

        // 边界值处理
        if (p.length() <= 0) return s.length() <= 0;

        // 第一个字符是否匹配
        boolean match = (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));


        if (p.length() > 1 && p.charAt(1) == '*') {
            // *号  但是 s中不出现                    s 中出现了p中字符
            return isMatch(s, p.substring(2)) || (match && isMatch(s.substring(1), p));
        } else {
            // 第一个字符match,匹配后面的
            return match && isMatch(s.substring(1), p.substring(1));
        }


    }
}
