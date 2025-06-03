package MyMath;

import java.util.Optional;

public class PerfectNumberCounter {
    // 检查一个数是否为完数的方法
    public static boolean isPerfectNumber(int num) {


        int sum = 0;
        // 找出该数的所有真因子并求和
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        // 判断真因子之和是否等于该数本身
        return sum == num;
    }

    // 计算指定范围内完数个数的方法
    public static int countPerfectNumbers(int start, int end) {
        int count = 0;
        // 遍历指定范围的所有数
        for (int i = start; i <= end; i++) {
            if (isPerfectNumber(i)) {
                // 如果是完数，则计数器加 1
                System.out.println(i);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int start = 1;
        int end = 1000;
        // 调用方法计算指定范围内完数的个数
        int perfectNumberCount = countPerfectNumbers(start, end);
        System.out.println("在范围 " + start + " 到 " + end + " 内完数的个数是: " + perfectNumberCount);
    }
}
