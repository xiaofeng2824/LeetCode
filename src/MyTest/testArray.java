package MyTest;

import myArray.MedianOfTwoSortArray;
import myArray.twoNum;
import org.junit.Test;

public class testArray {

    //测试 求两个数组和为目标值的下标
    @Test
    public void testTwoNum()
    {
        int[] arr = {2, 7, 11, 15};

        int target = 9;
        int[] twonum = twoNum.twonum(arr, target);
        int[] ints = twoNum.twonum2(arr, target);

        System.out.println("和为"+target+"的数字是："+twonum[0]+" "+twonum[1]);
        System.out.println("和为"+target+"的数字是："+ints[0]+" "+ints[1]);
    }

    //测试 求两个有序数组的中位数
    @Test
    public void testMidealOfTwoSortArray()
    {
        int[] nums1 = {1,3};
        int[] nums2 = {2,4};

        double midean = MedianOfTwoSortArray.findMedianSortedArrays(nums1, nums2);
        System.out.println("两个数组的中位数是："+midean);
    }
}
