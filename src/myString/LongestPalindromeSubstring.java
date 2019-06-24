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
    *
    * */

    //保存 更新 回文子字符串的首尾下标 全局变量
      int start,end;


    public  String longestPalindromeSubstring(String s)
    {
        int len = s.length();
        //如果字符串长度 <= 1 字符串本身就是最大的回文字符串
        if(len <= 1) return s;
        //将字符串转化为字符串数组处理
        char[] ss = s.toCharArray();

        for(int i=0;i<len;i++)
        {
            helper(ss,i,i);
            helper(ss,i,i+1);
        }

        return s.substring(start,end+1);
    }

    //求出某个字符的最大回文子串
    public void helper(char[] s,int left,int right)
    {
        while(left >=0 && right < s.length && s[left] == s[right])
        {
            left++;
            right--;
        }

        if(end-start < right-left-2)
        {
            start = left+1;
            end = right-1;
        }

    }

}
