package myArray;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例 1：
//
//
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//
//
// 示例 2：
//
//
//输入：nums = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：[]
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 3000
// -105 <= nums[i] <= 105
//
// Related Topics 数组 双指针
// 👍 3426 👎 0
public class SumOfThreeNum {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        long start = System.currentTimeMillis();
        List<List<Integer>> lists = threeSum(nums);
        long end = System.currentTimeMillis();

        System.out.println("对照组运行时间: "+(end - start));
        System.out.println(lists);


        long start1 = System.currentTimeMillis();
        List<List<Integer>> lists1 = threeSum2(nums);
        long end1 = System.currentTimeMillis();

        System.out.println("实验组运行时间: "+(end1 - start1));
        System.out.println(lists1);
    }


    // 对照组  时间复杂度 O(n^3)
    public static  List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> threeSum = new ArrayList<>();

        for (int i = 0; i < nums.length - 2 ;i++){

            for (int j=i+1;j < nums.length - 1 ;j++){

                for (int k = j+1;k < nums.length;k++){

                    if ((nums[i] + nums[j] + nums[k]) == 0 ){
                        List<Integer> num = new ArrayList<>();
                        num.add(nums[i]);
                        num.add(nums[j]);
                        num.add(nums[k]);
                        num.sort((o1,o2)->{
                            return o1.compareTo(o2);
                        });
                        if (!threeSum.contains(num)){
                            threeSum.add(num);
                        }
                    }
                }
            }
        }
        return threeSum;
    }


    // 优化版本1  时间复杂度 O(n^2)  双指针写法
    public static  List<List<Integer>> threeSum2(int[] nums) {

        // 返回体
        List<List<Integer>> lists = new ArrayList<>();

        // 排序
        Arrays.sort(nums);

        // 一次遍历
        for (int i = 0; i < nums.length; i++) {
            // 三个数 和为0, 必然有一个负数  num[i] 肯定为负数
            if (nums[i] > 0) {
                return lists;
            }
            // 避免重复项
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 双指针定义
            int L = i + 1;
            int R = nums.length - 1;

            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    // 避免重复项
                    while (L < R && nums[L + 1] == nums[L]) {
                        L++;
                    }
                    while (L < R && nums[R - 1] == nums[R]) {
                        R--;
                    }
                    L++;
                    R--;
                } else if (sum > 0) {
                    R --;
                } else {
                    L ++;
                }
            }

        }
        return lists;
    }

}
