package myString;

//计算不带重复字符的最长子字符串的长度
/*
* 解题思路：
*   1.hash[] 字符串存储字符串的信息 例：hash[c] = i 表示字符c在字符串第i个字符上
*    如果后面再次出现c字符  字符的位置将会被更新
*   2.设置一个前置指针(哨兵) preP，表示的是重复的字符的位置
*     如果遍历的字符的位置大于preP，那就表示这个字符之前出现过，将preP更新为hash[c]
*   3. i-preP为当前遍历的最大的重复字符的长度 i:遍历的字符的下标，preP重复字符的下标
*      dang i-preP > max 时 将max更新为 i - preP
* */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s)
    {
         int len;
         //如果字符串为空  或者 为空字符串则返回0  此时已经将字符串的长度赋值给len
         if(s == null || ((len = s.length()) == 0))
             return 0;

         //max 为最长子字符串的长度 preP  就是上次 重复字符在hash数组""""的下标
             int preP = 0 , max = 0;
         //hash数组存储字符串中的字符出现的位置
         int[] hash = new int[128];
         for(int i=0;i<len;i++)
         {
             char c = s.charAt(i);
             if(hash[c] > preP)
             {
                 preP = hash[c];
             }

             int l = i-preP + 1;
             //将当前字符的下标存储到hash数组中
             hash[c] = i + 1;
             if(l > max) max = l;
         }

         return max;
    }

}
