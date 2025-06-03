package other.two;

import java.util.Scanner;

public class LongestWaveSignal {
    public static void main(String[] args) {
        // 读取用户输入的一行字符串 s
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        // 去除字符串两端的空白字符
        s = s.trim();

        // 获取字符串 s 的长度
        int n = s.length();

        // 初始化最大长度为 0
        int MaxLen = 0;

        // 遍历字符串的每一个字符
        for (int i = 0; i < n; i++) {
            // 初始化标志位 flag，用于标识是否遇到连续的 "11"
            int flag = 0;

            // 如果当前字符是 '0'
            if (s.charAt(i) == '0') {
                int j = i + 1;  // 设置 j 为 i 的下一个位置

                // 向后遍历字符串，寻找最长的符合条件的子串
                while (j < n) {
                    // 如果连续遇到两个 '0'，则退出循环，因为此时子串不符合要求
                    if (s.charAt(j) == '0' && s.charAt(j - 1) == '0') {
                        break;
                    }

                    // 如果连续遇到两个 '1'，则设置标志位 flag 为 1
                    if (s.charAt(j) == '1' && s.charAt(j - 1) == '1') {
                        flag = 1;
                    }

                    j++;  // 继续向后遍历
                }

                // 如果找到的子串长度大于等于 3 且未遇到连续的 "11"
                if (j - i >= 3 && flag == 0) {
                    // 更新最大长度 MaxLen
                    if (MaxLen < (j - i)) {
                        MaxLen = j - i;
                    }
                }

                // 将 i 移动到子串的最后一个位置
                i = j - 1;
            }
        }

        // 如果没有找到符合条件的子串，输出 -1
        if (MaxLen == 0) {
            System.out.println("-1");
            return;
        }

        // 构建符合条件的最长子串
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < MaxLen; i++) {
            // 按照 "010101..." 的模式生成子串
            if (i % 2 == 0) {
                ans.append('0');
            } else {
                ans.append('1');
            }
        }

        // 输出结果
        System.out.println(ans.toString());

        scanner.close();
    }

}
