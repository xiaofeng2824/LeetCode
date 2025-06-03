package other.two;

import java.util.Scanner;

public class CrossRiver {

    // 表示极大值的常量，用于初始化最小操作次数
    private static final long INF = (long) 1e18;

    // 全局变量
    private static int m, n, x;
    private static int originM, originN;
    private static long minn = INF; // 表示最小操作次数的变量，初始化为极大值

    // 深度优先搜索函数，用来寻找最小操作次数
    private static void dfs(int nowM, int nowN, int ci) {
        // 如果当前羊和狼的数量之和小于等于 x，则更新最小操作次数并返回
        if (nowM + nowN <= x) {
            minn = Math.min(minn, ci + 1);
            return;
        }

        // 遍历所有可能取出 i 只羊和 j 只狼的组合
        for (int i = 0; i <= nowM; i++) {
            for (int j = 0; j <= nowN; j++) {
                // 跳过一些无效的组合（如同时取出 0 或者取出的总量大于 x）
                if (i + j == 0 || i + j > x || (i != nowM && nowM - i <= nowN - j)) continue;
                // 跳过一些无效的组合（如新组合和原始数量差值不符合约束条件）
                if (originM != nowM - i && originM - nowM + i <= originN - nowN + j) continue;
                // 递归调用 dfs 函数
                dfs(nowM - i, nowN - j, ci + 1);
            }
        }
    }

    public static void main(String[] args) {
        // 从标准输入读取 m, n, x 三个整数
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        x = scanner.nextInt();

        // 如果 m 和 n 的和小于等于 x，则立即打印结果 1 并退出
        if (m + n <= x) {
            System.out.println(1);
            return;
        }

        // 保存初始的 m 和 n 值
        originM = m;
        originN = n;

        // 初始调用 dfs 函数来开始深度优先搜索
        dfs(m, n, 0);

        // 输出结果，根据 minn 的值判断是否找到解
        if (minn == INF) {
            System.out.println(0);
        } else {
            System.out.println(minn);
        }
    }
}
