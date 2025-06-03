package myString;

/**
 * https://leetcode.cn/problems/existence-of-a-substring-in-a-string-and-its-reverse/description/
 *
 * 字符串及其反转中是否存在同一字符串
 */
public class IsSubstringPresent {

    public static void main(String[] args) {

//        String s = "leetcode";
        String s = "abcba";

        System.out.println(isSubstringPresent(s));
    }


    public static boolean isSubstringPresent(String s) {
     if (s == null || s == "" || s.length() == 1) return false;

     // 翻转字符串
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i=chars.length -1;i >= 0;i--){
            sb.append(chars[i]);
        }
        String reverse = new String(sb);

        for (int i=0;i< s.length()-1;i++){
            String subStr = s.substring(i,i+2);
            if (reverse.contains(subStr)){
                return true;
            }
        }
        return false;
    }
}
