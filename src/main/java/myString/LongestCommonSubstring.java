package myString;

//最长公共子串


public class LongestCommonSubstring {
    public static void main(String[] args) {
        String[] str_arr = {"a", "b"};
        String str = longestCommonPrefix(str_arr);
        System.out.println(str);
    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0 || strs[0].length() == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        String str;
        int length = strs[0].length();

        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < length) {
                length = strs[i].length();

            }
        }
        int j = 0;
        int n = 0;
        while (j < length) {

            for (int i = 1; i < strs.length; i++) {

                if (strs[i].charAt(j) != strs[0].charAt(j)) {
                    return strs[0].substring(0, j);
                }

            }
            j++;

        }

        return strs[0];
    }
}