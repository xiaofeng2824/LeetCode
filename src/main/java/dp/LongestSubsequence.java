package dp;

import java.util.Arrays;
import java.util.Collections;

public class LongestSubsequence {

    public static void main(String[] args) {
//        int[] nums = {1,2,3,4};
//        int difference = 1;

//        int[] nums = {1,3,5,7};
//        int difference = 1;


        Integer[] nums = {1,5,7,8,5,3,4,2,1};
        int difference = -2;

//        int[] nums = {3,4,-3,-2,-41};
//        int difference = -5;

        System.out.println(longestSubsequence(nums,difference));
        System.out.println(longestSubsequence2(nums,difference));

    }


    public static int longestSubsequence(Integer[] arr, int difference) {

        if (arr == null || arr.length < 2){
            return arr.length;
        }
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);

        int res = Integer.MIN_VALUE;
        for (int i=1;i<arr.length;i++){
            for (int j = 0; j < i; j++) {
                if (arr[i] - arr[j] == difference){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            res = Math.max(res,dp[i]);
        }

        return res;
    }

    public static int longestSubsequence2(Integer[] arr, int difference) {

        if (arr == null || arr.length < 2){
            return arr.length;
        }
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        // 排序
        if (difference >= 0){
            Arrays.sort(arr);
        }else {
            Arrays.sort(arr,Collections.reverseOrder());
        }



        for (int i = 1;i < n;i++){
           if (arr[i] - arr[i-1] == difference){
               dp[i] = dp[i-1] + 1;
           }else {
               dp[i] = dp[i-1];
           }
        }
        return dp[n-1];
    }
}
