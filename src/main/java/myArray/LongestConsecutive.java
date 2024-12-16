package myArray;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * https://leetcode.cn/problems/longest-consecutive-sequence
 */
public class LongestConsecutive {

    public static void main(String[] args) {

//        int[] nums = {100,4,200,1,3,2};
//        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int[] nums = {1,2,0,1};
        int len = longestConsecutive(nums);
        System.out.println(len);

    }

    public static int longestConsecutive(int[] nums) {
       if (nums == null || nums.length == 0) return 0;
       if (nums.length == 1) return 1;

        Arrays.sort(nums);

       int len = 0,start = 0,end = 0;
       while (end < nums.length - 1){
           if ( nums[end] == nums[end + 1] - 1 ){
               end++;
           }else if (nums[end] == nums[end + 1]){
               start++;
               end++;
           }else {
               start = end = end + 1;
           }
           len = Math.max(len,end - start + 1);
       }
        return len;
    }

}
