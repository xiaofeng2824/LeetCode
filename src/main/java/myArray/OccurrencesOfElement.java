package myArray;

import java.util.Arrays;

public class OccurrencesOfElement {

    public static void main(String[] args) {
//        int[] nums = {1,3,1,7}, queries = {1,3,2,4}; int x = 1;

        int[] nums = {1, 2, 3}, queries = {10};
        int x = 5;
        System.out.println(Arrays.toString(occurrencesOfElement(nums, queries, x)));
    }


    public static int[] occurrencesOfElement(int[] nums, int[] queries, int x) {

        int[] counts = new int[nums.length + 1];

        Arrays.fill(counts, -1);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                counts[++count] = i;
            }
        }

        int[] res = new int[queries.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] <= nums.length) {
                res[i] = counts[queries[i]];
            }

        }
        return res;
    }
}
