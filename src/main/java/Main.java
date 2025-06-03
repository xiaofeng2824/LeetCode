import java.util.HashSet;
import java.util.Scanner;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        List<Integer> nums = new ArrayList();
        int line = in.nextInt();
        while (line-- > 0) { // 注意 while 处理多个 case
            int num = in.nextInt();
            nums.add(num);
        }
        randomNum(nums);
    }

    public static void randomNum(List<Integer> nums){

        if(nums == null || nums.size() == 0) return;

        HashSet<Integer> numSet = new HashSet<Integer>();

        for(Integer num : nums){
            numSet.add(num);
        }

        for(Integer num : numSet){
            System.out.println(num);
        }

        Integer[] numArr = numSet.toArray(new Integer[0]);

        Arrays.sort(numArr);

        for(Integer num : numArr){
            System.out.println(num);
        }
    }
}