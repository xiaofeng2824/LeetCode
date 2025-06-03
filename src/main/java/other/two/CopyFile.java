package other.two;

import java.util.Scanner;

public class CopyFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 读取输入的物品数量

        int Max = 2880; // 定义背包的容量为 2880
        long[] dp = new long[Max + 1]; // 定义动态规划数组，长度为 Max + 1

        // 遍历每个物品
        for (int i = 1; i <= n; i++) {
            int x = scanner.nextInt(); // 读取每个物品的体积

            // 计算当前物品应该放入的最小块数（每块 512 单位大小）
            int kuai = x / 512;
            if (x % 512 != 0) {
                kuai += 1; // 如果有余数则块数加 1
            }

            // 从最大容量到当前物品的块数，倒序更新 dp 数组
            for (int j = Max; j >= kuai; j--) {
                // 状态转移方程：选择当前物品或不选择当前物品
                dp[j] = Math.max(dp[j], dp[j - kuai] + x);
            }
        }

        // 输出在容量为 Max 的情况下所能放入的物品的最大体积
        System.out.println(dp[Max]);

        scanner.close();
    }
}
