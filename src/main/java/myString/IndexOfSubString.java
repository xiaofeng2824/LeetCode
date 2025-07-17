package myString;

/**
 * 题意是从主串中找到子串的索引，如果找不到则返回-1，
 * 当子串长度大于主串，直接返回-1，然后我们只需要遍历比较即可。
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 */
public class IndexOfSubString {

    public int indexOfSubString(String str, String substr) {
        int len1 = str.length();
        int len2 = substr.length();

        if (len1 < len2)
            return -1;

        for (int i = 0; i < len1; i++) {
            int k = i;
            for (int j = 0; j < len2; j++) {
                if (i + len2 > len1) return -1;

                if (str.charAt(k++) != substr.charAt(j)) {
                    break;
                }
                if (j == len2 - 1) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        IndexOfSubString indexOfSubString = new IndexOfSubString();
        System.out.println(indexOfSubString.indexOfSubString("hello", "ll"));
        System.out.println(indexOfSubString.indexOfSubString("aaaaa", "bba"));

    }

}
