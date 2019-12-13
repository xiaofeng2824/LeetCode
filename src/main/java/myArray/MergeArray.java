package myArray;

import java.util.Arrays;

/**
 * 题意是给两个已排序的数组 `nums1` 和 `nums2`，
 * 合并 `nums2` 到 `nums1` 中，两数组元素个数分别为 `m` 和 `n`，
 * 而且 `nums1` 数组的长度足够容纳 `m + n` 个元素，
 * 如果我们按顺序排下去，那肯定要开辟一个新数组来保存元素，
 * 如果我们选择逆序，这样利用 `nums1` 自身空间足矣，
 * 不会出现覆盖的情况，依次把大的元素插入到 `nums1` 的末尾，
 * 确保 `nums2` 中的元素全部插入到 `nums1` 即可
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * Output: [1,2,2,3,5,6]
 */
public class MergeArray {
    //合并两个有序数组
    public int[] merge(int[] nums1,int m,int[] nums2,int n)
    {
        int p = m-- + n-- - 1;
        while(m >= 0 && n >= 0)
        {
            nums1[p--] = nums1[m] > nums2[n]? nums1[m--]:nums2[n--];
        }
        while(n >= 0)
        {
            nums1[p--] = nums2[n--];
        }

        return nums1;
    }

    public static void main(String[] args) {

        MergeArray mergeArray = new MergeArray();

        int[] nums1 = new int[10];
        for (int i = 0; i < 5; ++i) {
            nums1[i] = 2 * i;
        }
        int[] nums2 = new int[5];
        for (int i = 0; i < 5; ++i) {
            nums2[i] = 2 * i + 1;
        }
        System.out.println("nums1: "+Arrays.toString(nums1));
        System.out.println("nums2: "+Arrays.toString(nums2));
        mergeArray.merge(nums1, 5, nums2, 5);
        System.out.println(Arrays.toString(nums1));
    }

}
