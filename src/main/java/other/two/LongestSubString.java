package other.two;

import java.util.Scanner;

public class LongestSubString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char ch = scanner.nextLine().charAt(0);
        String s = scanner.nextLine();
        int[] cnt = new int[200]; // 初始化计数数组，用于记录每个字符在当前子串中的出现次数
        int lc = 0; // 左指针，表示当前子串的起始位置
        int res = 0; // 用于存储满足条件的最长子串的长度

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) { // 如果当前字符是指定的字符
                lc = i + 1; // 更新左指针，跳过当前字符
                cnt = new int[200]; // 重置计数数组
            } else {
                cnt[s.charAt(i)]++; // 增加当前字符的计数
                while (cnt[s.charAt(i)] > 2) { // 如果当前字符在子串中出现超过2次
                    cnt[s.charAt(lc)]--; // 移动左指针并减少对应字符的计数
                    lc++; // 移动左指针，缩小子串范围
                }
                res = Math.max(res, i - lc + 1); // 更新最长子串的长度
            }
        }

        System.out.println(res); // 输出满足条件的最长子串的长度
        scanner.close();
    }
}
