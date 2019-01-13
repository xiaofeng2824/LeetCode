package myArray;

import java.util.HashMap;

/*
* ## Description

Given an array of integers, return **indices** of the two numbers such that they add up to a specific target.

You may assume that each input would have ***exactly*** one solution, and you may not use the same element twice.

**Example:**

```
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```

**Tags:** Array, Hash Table
* */
public class twoNum {

    //给定一个数组，求拿两个数字之和为目标值

    //解法1：遍历两次  arr[i] + arr[j] == target
    //时间复杂度：O(n) = n^2
    public static int[] twonum(int[] nums,int target)
    {
        for(int i=0;i<nums.length;i++)
        {
            for (int j =i+1;j<nums.length;j++)
            {
                if(nums[i] + nums[j] == target)
                    return new int[] {i,j};
            }
        }

        return null;
    }

    //解法2
    /*
    * 使用hashmap来存储   键为目标值减去当前元素值，索引为值
    * 存储之前首先判断nums[0] 是否在map中,如果不存在则存储在map中
    * 时间复杂度为： O(n) = n
    * */

    public static int[] twonum2(int[] nums,int target)
    {
        int len = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<len;i++)
        {
            if(map.containsKey(nums[i]))
            {
                return  new int[] {map.get(nums[i]),i};
            }
            map.put(target-nums[i],i);
        }

        return null;
    }

}
