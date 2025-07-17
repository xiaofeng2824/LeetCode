package myArray;


//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。
//
// 进阶：
//
//
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
//
//
//
//
// 示例 1：
//
//
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4]
//
// 示例 2：
//
//
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1]
//
// 示例 3：
//
//
//输入：nums = [], target = 0
//输出：[-1,-1]
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// nums 是一个非递减数组
// -109 <= target <= 109
//
// Related Topics 数组 二分查找
// 👍 1070 👎 0


import java.util.Arrays;

public class SearchRange {

    public static void main(String[] args) {

        int[] arr = {5, 7, 7, 8, 8, 10};
//        int[] arr = {1};

        // 对照组
        System.out.println(Arrays.toString(searchRange(arr, 8)));

        // 优化版本
        System.out.println(Arrays.toString(searchRange2(arr, 8)));


        int[] arr1 = {1};

        // 对照组
        System.out.println(Arrays.toString(searchRange(arr1, 1)));

        // 优化版本
        System.out.println(Arrays.toString(searchRange2(arr1, 1)));


        int[] arr2 = {1, 2, 3, 3, 3, 3, 4, 5, 9};

        // 对照组
        System.out.println(Arrays.toString(searchRange(arr2, 3)));

        // 优化版本
        System.out.println(Arrays.toString(searchRange2(arr2, 3)));


    }

    // 二分查找
    public static int[] searchRange2(int[] nums, int target) {

        int[] res = {-1, -1};

        if (nums == null || nums.length == 0) {
            return res;
        }
        // 二分查找
        res = searchTargetValue(nums, 0, nums.length - 1, target);


        return res;
    }

    // 数组中找到目标值 target
    public static int[] searchTargetValue(int[] nums, int left, int right, int target) {

        int[] res = {-1, -1};
        if (nums[left] == target && nums[right] == target) {
            res[0] = left;
            res[1] = right;
            return res;
        } else if (left == right) {
            return res;
        }

        int mid = (left + right) / 2;

        if (nums[mid] == target) {
            int[] leftArr = searchTargetValue(nums, left, mid, target);
            int[] rightArr = searchTargetValue(nums, mid + 1, right, target);

            //全在左边
            if (rightArr[0] == -1) {
                return leftArr;
                // 全在右边
            } else if (leftArr[1] == -1) {
                return rightArr;
            } else {

                res[0] = leftArr[0];
                res[1] = rightArr[1];
                return res;
            }

        } else if (nums[mid] < target) {
            return searchTargetValue(nums, mid + 1, right, target);
        } else {
            return searchTargetValue(nums, left, mid, target);
        }

    }


    // 对照组
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};

        int p1 = 0;
        int p2 = nums.length - 1;

        while (p1 <= p2) {
            if (nums[p1] == target) {
                break;
            } else {
                p1++;
            }
        }

        while (p1 <= p2) {
            if (nums[p2] == target) {
                break;
            } else {
                p2--;
            }
        }

        if (p1 > p2) {
            return res;
        } else {
            return new int[]{p1, p2};
        }

    }
}
