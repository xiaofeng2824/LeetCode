package myArray;


//整数数组 nums 按升序排列，数组中的值 互不相同 。
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
//
//
//
// 示例 1：
//
//
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
//
//
// 示例 2：
//
//
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1
//
// 示例 3：
//
//
//输入：nums = [1], target = 0
//输出：-1
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 5000
// -10^4 <= nums[i] <= 10^4
// nums 中的每个值都 独一无二
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转
// -10^4 <= target <= 10^4
//
//
//
//
// 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
// Related Topics 数组 二分查找
// 👍 1413 👎 0
public class Search {

    public static void main(String[] args) {

        int[] nums = {4,5,6,7,0,1,2};
        int[] nums2 = {4,5,6,7,8,0,1,2};
        int[] nums4 = {1,2,3,4,5,6,7,8};

        int[] nums3 = {1};

        // O(n) 的写法
        System.out.println(search(nums,0));
        System.out.println(search(nums2,3));
        System.out.println(search(nums3,0));

        // 测试 数组中最小值下标
//        System.out.println(minValue(nums,0,nums.length - 1));
//        System.out.println(minValue(nums2,0,nums2.length - 1));
//        System.out.println(minValue(nums3,0,nums3.length - 1));


        System.out.println("----");
        // 测试有序数组中找到 target value
//        System.out.println(searchTargetValue(nums4,0,nums4.length-1,5));

        System.out.println(search2(nums,0));
        System.out.println(search2(nums2,3));
        System.out.println(search2(nums3,0));



    }

    // O(n)的写法
    public static int search(int[] nums, int target) {
        int index = -1;

        for (int i=0;i<nums.length ;i++){
           if (nums[i] == target){
               return i;
           }
        }

        return index;
    }

    // 进阶写法

    public static int search2(int[] nums, int target) {

        if (nums.length == 1){
            return  nums[0] == target ? 0 : -1;
        }

        // 先要找到 k值  最小值的位置
        int minIndex = minValue(nums, 0, nums.length - 1);

        int leftMinIndex = searchTargetValue(nums,0,minIndex,target);
        int rightMinIndex = searchTargetValue(nums,minIndex, nums.length ,target);


        return leftMinIndex == -1 ? rightMinIndex : leftMinIndex;
    }

    // 数组中找到目标值 target
    public static int searchTargetValue(int[] nums,int left,int right,int target){

         if (left == right){
             return  -1;
         }

        int mid = (left + right)/2;

        if (nums[mid] == target){
            return  mid;
        }

        if (nums[mid] < target){
            return  searchTargetValue(nums,mid + 1,right,target);
        }else {
            return  searchTargetValue(nums,left,mid,target);
        }

    }

    // 返回最小值的下标
    public static int minValue(int[] nums,int left,int right){

        // 递归出口
        if (left == right){
            return left;
        }

        int mid = (left + right)/2 ;
        int leftMinIndex = minValue(nums,left,mid);
        int rightMinIndex = minValue(nums,mid + 1,right);

        return nums[leftMinIndex] < nums[rightMinIndex] ? leftMinIndex : rightMinIndex;

    }


}
