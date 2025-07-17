package other;

import java.util.HashSet;
import java.util.Scanner;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 描述
 * 对于明明生成的
 * n
 * n 个
 * 1
 * 1 到
 * 500
 * 500 之间的随机整数，你需要帮助他完成以下任务：
 * ∙
 * <p>
 * ∙删去重复的数字，即相同的数字只保留一个，把其余相同的数去掉；
 * ∙
 * <p>
 * ∙然后再把这些数从小到大排序，按照排好的顺序输出。
 * 你只需要输出最终的排序结果。
 * 输入描述：
 * 第一行输入一个整数
 * n
 * <p>
 * (
 * 1
 * ≦
 * n
 * ≦
 * 1000
 * )
 * n (1≦n≦1000)，代表明明生成的数字个数。
 * 此后
 * n
 * n 行，第
 * i
 * i 行输入一个整数
 * a
 * i
 * <p>
 * (
 * 1
 * ≦
 * a
 * i
 * ≦
 * 500
 * )
 * a
 * i
 * ​
 * (1≦a
 * i
 * ​
 * ≦500)，代表明明生成的随机整数。
 * 输出描述：
 * 输出若干行，每行输出一个整数，代表输入数据排序后的结果。第一行输出最小的数字。
 */
public class RandomNum {

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

    public static void randomNum(List<Integer> nums) {

        if (nums == null || nums.size() == 0) return;

        HashSet<Integer> numSet = new HashSet<Integer>();

        for (Integer num : nums) {
            numSet.add(num);
        }


        Integer[] numArr = numSet.toArray(new Integer[0]);

        Arrays.sort(numArr);

        for (Integer num : numArr) {
            System.out.println(num);
        }
    }
}
