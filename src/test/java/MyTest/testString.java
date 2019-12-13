package MyTest;

import myString.LengthOfLongestSubstring;
import org.junit.Test;

public class testString {

    //测试字符串中最大不重复字符的个数
    @Test
    public void  testLengthOfLongestSubstring()
    {
        int num  = LengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb");
        System.out.println(num);

    }

}
