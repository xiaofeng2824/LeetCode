package MyTest;

import myString.LengthOfLongestSubstring;
import myString.LongestPalindromeSubstring;
import org.junit.Test;

public class testString {

    //测试字符串中最大不重复字符的个数
    @Test
    public void  testLengthOfLongestSubstring()
    {
        int num  = LengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb");
        System.out.println(num);

    }

    //测试字符串中的最大回文子串
    @Test
    public void testLongestPalindromicSubstring()
    {
        //测试数据
        String s = "ababa";
        //最大回文子串
        LongestPalindromeSubstring substring  = new LongestPalindromeSubstring();
        String s1 = substring.longestPalindromeSubstring(s);
        System.out.println(s1);


    }


}
