package myArray;

/**
 * 题意是给你一个数字数组，高位在前，并且首位不为 0 除非这个数组就是 `[0]`，
 * 让你给该数组低位加一求其结果，那么我们就模拟小学数学那样进位去算即可，
 * 如果一直进位到首位，这种情况也就是都是由 9 组成的数组，
 * 此时我们只要 new 出一个多一个长度的数组即可，并把第 0 个元素赋 1 即可。
 *
 * 例：
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
public class PlusOne {
    public int[] plusOne(int[] nums)
    {
        int p = nums.length - 1;
        //末位数不是9 直接加即可
        if (nums[p] < 9)
        {
            nums[p] = ++nums[p];
        }else{
            //末位数是9 则需要循环进位
            do{
                nums[p--] = 0;
            }while(p >= 0 && nums[p] == 9);

            //首位不为0 直接进位
            if (nums[0] != 0)
            {
               ++nums[p];
            }else
            {
                //首位为0 需要加一位
                nums = new int[nums.length + 1];
                nums[0] = 1;
            }
        }
        return  nums;

    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] arr = {1,2,3};
        int[] arr1 = {4,3,2,1};
        int[] arr2 = {9,9,9,9};
        printf(plusOne.plusOne(arr));
        printf(plusOne.plusOne(arr1));
        printf(plusOne.plusOne(arr2));

    }

    public static void printf(int[] nums)
    {
        for (int i:nums)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
