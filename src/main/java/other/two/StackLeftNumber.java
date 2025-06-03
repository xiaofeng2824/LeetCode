package other.two;

import java.util.Scanner;

public class StackLeftNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 定义栈，容量比可能的最大输入数据要大
        long []st = new long[100010];
        // 读取输入字符串，并以空格分隔转化为字符串数组
        String []s = sc.nextLine().split(" ");
        // 将字符串数组转换为长整型数组
        long []arr = new long[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Long.parseLong(s[i]);
        }

        int top = -1;  // 初始化栈顶指针

        // 遍历每个输入的元素
        for (long x : arr) {
            while (true) {
                st[++top] = x;  // 元素入栈
                long sum = 0;
                int index = -1;
                // 从栈顶开始向下检查是否有连续元素的和等于当前元素
                for (int j = top - 1; j >= 0; j--) {
                    sum += st[j];
                    if (sum == x) {
                        index = j;  // 找到满足条件的起始位置
                        break;
                    }
                }
                // 如果找不到，跳出循环
                if (index == -1) break;
                // 重置栈顶指针到找到的位置之前
                top = index - 1;
                // 将当前元素替换为新元素，继续检查
                x *= 2;
            }
        }

        // 输出最终栈中的元素，从栈顶开始输出
        for (int i = top; i >= 0; i--) {
            if (i != top) {
                System.out.print(" ");
            }
            System.out.print(st[i]);
        }
    }
}
