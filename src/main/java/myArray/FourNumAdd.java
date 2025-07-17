package myArray;


//给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
//
//
// 0 <= i, j, k, l < n
// nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
//
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
//输出：2
//解释：
//两个元组如下：
//1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1)
// + 2 = 0
//2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1)
// + 0 = 0
//
//
// 示例 2：
//
//
//输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
//输出：1
//
//
//
//
// 提示：
//
//
// n == nums1.length
// n == nums2.length
// n == nums3.length
// n == nums4.length
// 1 <= n <= 200
// -228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228
//
// Related Topics 数组 哈希表
// 👍 451 👎 0

import java.util.HashMap;
import java.util.Map;

public class FourNumAdd {

    // 方法1： 笨方法，四层循环  作为对照组
    public static int fourSumCount1(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                for (int k = 0; k < nums3.length; k++) {
                    for (int l = 0; l < nums4.length; l++) {
                        if (nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }


    // 方法2:   分解成两个相加   a + b = - (c + d)
    public static int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {


        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int a : nums1) {
            for (int b : nums2) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }

        for (int c : nums3) {
            for (int d : nums4) {
                res += map.getOrDefault(-(c + d), 0);
            }
        }

        return res;
    }
    // 取相反数

    public static void main(String[] args) {

        // testcase
        int[] nums1 = {1, 2}, nums2 = {-2, -1}, nums3 = {-1, 2}, nums4 = {0, 2};

//        int[] nums1 = {0}, nums2 = {0}, nums3 = {0}, nums4 = {0};
        //
        System.out.println(fourSumCount1(nums1, nums2, nums3, nums4));

        // 方法2
        System.out.println(fourSumCount2(nums1, nums2, nums3, nums4));
    }
}
