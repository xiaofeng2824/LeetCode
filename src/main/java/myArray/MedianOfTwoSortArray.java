package myArray;
/*
*
题目：Example 1:**
nums1 = [1, 3]
nums2 = [2]
The median is 2.0

**Example 2:**
nums1 = [1, 2]
nums2 = [3, 4]
The median is (2 + 3)/2 = 2.5
* */
public class MedianOfTwoSortArray {

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        //得到两个数组的总长度
        int len = nums1.length + nums2.length;
        //数组长度为偶数 则需要取中间的两个数求平均值
        if(len%2 == 0)
        {
            return (helper(nums1,0,nums2,0,len/2) + helper(nums1,0,nums2,0,len/2 + 1))/2.0;
        }

        //如果长度是偶数
        return helper(nums1,0,nums2,0,len/2 + 1);

    }

    //查找两个有序数组中的第k大的数字
    /*
    * 方法一：两个头指针遍历这两个有序数组 依次比较两个首指针的值  直到找到第k大的数字为止
    *       O(n) = m + n
    *
    * 方法二：首先从nums1中取出 m个元素  从nums2中取出k-m个元素 比较num1[m-1] 与nums[k-m-1]的大小
    *        如果 nums1[m-1] > nums2[k-m-1] 则忽略掉 nums2[0] - nums2[k-m-1]的值
    *          因为数组有序 num2[k-m-1] 不可能是第k大的值
    *          更新 k值为 m+1(k- (k-m-1)) 再次
    *        如果 nums1[m-1] < nums[k-m-1]  同理
    * */

    /*
    * param m : 表示从num1的第m个元素开始找
    * param n ：表示从num2的第n个元素开始找
    * k  ： 两个有序数组中的第n个元素
    * */
    private static int helper(int[] num1,int m,int[] num2,int n,int k )
    {
        //如果num1中没有那么多元素，直接从第二个数组中找
        if(m >= num1.length) return num2[n+k-1];
        if(n >= num2.length) return num1[m+k-1];
        //最后只取第一个数字的时候 取两个数字的最小值即可
        if(k == 1) return Math.min(num1[m],num2[n]);

        // 分别得到 num1  和 num2 的 di x + k/2个元素的下标
        int p1 = m + k/2 -1;
        int p2 = n + k/2 -1;
        //得到取出p1 p2下标的值
        int mid1 = p1 < num1.length?num1[p1]:Integer.MAX_VALUE;
        int mid2 = p2 < num2.length?num2[p2]:Integer.MAX_VALUE;

        //递归调用helper 找到第k个值
        if(mid1 < mid2)
        {
            //忽略掉num1的前m 到 m+k/2-1的元素 因为不可能是第k大的元素
            return helper(num1,m+k/2,num2,n,k-k/2);
        }

        return helper(num1,m,num2,n+k/2,k-k/2);


    }

}
