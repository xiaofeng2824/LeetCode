package myArray;


//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
// 必须 原地 修改，只允许使用额外常数空间。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[1,3,2]
//
//
// 示例 2：
//
//
//输入：nums = [3,2,1]
//输出：[1,2,3]
//
//
// 示例 3：
//
//
//输入：nums = [1,1,5]
//输出：[1,5,1]
//
//
// 示例 4：
//
//
//输入：nums = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 100
//
// Related Topics 数组 双指针
// 👍 1183 👎 0

import java.util.Arrays;

/**
 * @author caoxiaofeng
 * @date 2021-06-24 09:07
 */
public class NextPermutation {

    // test
    public static void main(String[] args) {

        //int[] arr = {1,2,3};
        //int[] arr = {3,2,1};
        int[] arr = {1, 1, 5};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));

    }

    // 倒序找到nums[i - 1] < nums[i],再找i到nums.length中大于nums[i - 1]的最小值，交换后排序
    public static void nextPermutation(int[] nums) {
        int i = 0;
        for (i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                int min = i;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] < nums[min] && nums[j] > nums[i - 1]) {
                        min = j;
                    }
                }
                int t = nums[min];
                nums[min] = nums[i - 1];
                nums[i - 1] = t;
//                Arrays.sort(nums,i,nums.length);
                break;
            }
        }
        if (i == 0) Arrays.sort(nums);
    }

}
