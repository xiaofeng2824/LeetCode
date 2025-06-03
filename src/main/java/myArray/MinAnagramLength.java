package myArray;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/minimum-length-of-anagram-concatenation/
 * 3138. 同位字符串连接的最小长度
 */
public class MinAnagramLength {

    public static void main(String[] args) {
//     String s = "abba";
     String s = "cdef";
     System.out.println(minAnagramLength(s));
    }

    public static  int minAnagramLength(String s) {

        if (s == null || s.length() == 0) return 0;

        char[] chars = s.toCharArray();

        Map<Character,Integer> map = new HashMap<>();
        for (char a : chars){
            Integer count = map.getOrDefault(a, 0);
            map.put(a,count + 1);
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Character a : map.keySet()) {
            min = Math.min(min,map.get(a));
            max = Math.min(max,map.get(a));
        }

        int res = 0;

        for (Character a : map.keySet()) {
             res += map.get(a) == min ? 1 : map.get(a) - min;
        }

        return res;
    }
}
