package myString;

//实现子字符串
public class SubString {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";

        int n = strStr(haystack, needle);
        System.out.println(n);

    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0)
            return 0;
        int n = -1;
        int nub = 0;
        int len1 = haystack.length();
        int len2 = needle.length();
        if (len1 < len2)
            return -1;

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int count = 0;
            for (int j = 0; j < needle.length(); j++) {
                n = i;
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                } else {
                    count++;
                }

            }
            if (count == len2) {
                nub = count;
                break;
            }
        }
        if (nub == len2)
            return n;
        else return -1;

    }
}