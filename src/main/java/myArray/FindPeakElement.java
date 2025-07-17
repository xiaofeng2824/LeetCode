package myArray;

/**
 * https://leetcode.cn/problems/find-peak-element/
 * 寻找峰值
 */
public class FindPeakElement {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        int[] nums3 = {3, 2, 1};
        System.out.println(findPeakElement(nums));
        System.out.println(findPeakElement(nums2));
        System.out.println(findPeakElement(nums3));
    }

    public static int findPeakElement(int[] nums) {
        return findPeakElement(nums, 0, nums.length - 1);
    }

    public static int findPeakElement(int[] nums, int l, int r) {

        if (nums.length == 1) return 0;

        //递归退出条件
        if (l > r) return -1;
        int mid = (l + r) / 2;

        // 最左侧退出条件
        if (mid == 0 && nums[mid] > nums[mid + 1]) {
            return mid;
        }

        if (mid == nums.length - 1 && nums[mid] > nums[mid - 1]) {
            return mid;
        }

        // 符合条件
        if (mid > 0 && mid < nums.length - 1 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
            return mid;
        }
        int leftIndex = findPeakElement(nums, l, mid - 1);
        if (leftIndex != -1) {
            return leftIndex;
        } else {
            return findPeakElement(nums, mid + 1, r);
        }
    }
}
