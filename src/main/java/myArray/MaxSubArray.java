package myArray;



/**
 * 求数组的最大子序和
 * examples：
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6
 */
public class MaxSubArray {

    /**
     * 动态规划：当部分序列和大于0 一直加下一个元素即可，
     * 并且和当前最大值进行比较 如果部分序列和小于0 就从当前元素算起
     * @param nums
     * @return
     */
    public  int maxSubArray(int[] nums)
    {
        int len = nums.length,dp = nums[0],max = dp;
        for (int i = 1;i < len;i++)
        {
            //如果当前序列和大于0 一直往下加下一位，否则就从当前位置重新计算
            dp = nums[i] + (dp > 0 ? dp:0);
            //比较当前子序列和与最大值
            if(dp > max) max = dp;
        }
        return max;

    }

    /**
     * 分治法：把问题分割成更小的，最后再合并即可
     * 把nums 一分为二，就有两种情况，一种最大序列包括中间的值
     * 一种就是不包括 或左边  或右边
     * 当最大序列在中间的时候我们把它两侧的最大和算出即可
     * 当在两边继续分治即可
     * @param
     */

    public  int maxSubArray1(int[] nums)
    {
        return helper(nums,0,nums.length - 1);
    }

    private  int helper(int nums[],int left,int right)
    {
        if (left >= right) return nums[left];
        int mid =  (left + right) >> 1;
        //递归分治
        int leftAns = helper(nums,left,mid);
        int rightAns = helper(nums,mid+1,right);
        int leftMax = nums[mid];
        int rightMax = nums[mid+1];

        int temp = 0;
        for (int i=mid;i>=left;i--)
        {
            temp += nums[i];
            if (temp > leftMax) leftMax = temp;
        }
        temp = 0;
        for (int i = mid +1; i <= right ; i++) {
            temp += nums[i];
            if(temp > rightMax) rightMax = temp;

        }

        return Math.max(Math.max(leftAns,rightAns),leftMax + rightMax);


    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray.maxSubArray(nums));
        System.out.println(maxSubArray.maxSubArray1(nums));


    }
}
