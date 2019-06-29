package myArray;

/**
 * 给定一个已排序的数组，找到一个可插入位置的索引
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 */
public class SearchInsertPosition {

    /**
     * 数组有序  即用二分法解决
     * @param nums
     * @param target
     * @return
     */
    public int indexOfTarget(int[] nums,int target)
    {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) >> 1;

        while(left <= right)
        {
            if (target <= nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
            mid = (left + right) >> 1;
        }
        return left;
    }

    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsertPosition.indexOfTarget(nums,5));
        System.out.println(searchInsertPosition.indexOfTarget(nums,2));
        System.out.println(searchInsertPosition.indexOfTarget(nums,7));
        System.out.println(searchInsertPosition.indexOfTarget(nums,0));
    }
}
