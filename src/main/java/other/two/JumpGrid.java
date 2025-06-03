package other.two;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class JumpGrid {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 读取输入的总格子数量
        int n = sc.nextInt();

        // 初始化数组来存储每个格子的分数
        long [] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        // 读取最大跳的步长
        int k = sc.nextInt();

        // 使用dp数组来存储到达每个格子的最大得分
        long [] dp = new long[n];

        // 使用一个Map来存储dp值的计数
        Map<Long, Integer> mp = new HashMap<>();

        // 使用一个TreeSet来维护当前最大k范围内的dp值
        // 使用lambda表达式来定义比较器，按降序排序
        TreeSet<Long> st = new TreeSet<>((x, y) -> y.compareTo(x));

        // 初始化第一个格子的dp值等于第一个格子的分数
        dp[0] = arr[0];
        st.add(arr[0]);
        mp.put(arr[0], 1);

        // 遍历从第二个格子到最后一个格子
        for (int i = 1; i < n; i++) {
            // 获取当前最大k范围内的dp值
            long max = st.first();

            // 当前格子的dp值等于最大k范围内的dp值加上当前格子的分数
            dp[i] = max + arr[i];

            // 将当前dp值添加到TreeSet和Map中
            st.add(dp[i]);
            mp.put(dp[i], mp.getOrDefault(dp[i], 0) + 1);

            // 如果当前格子的位置大于等于k，需要维护k范围内的最大值
            if (i >= k) {
                long now = dp[i - k];
                int ci = mp.get(now);

                // 如果dp值的计数为1，移出TreeSet；否则只减少计数
                if (ci == 1) {
                    st.remove(now);
                }
                mp.put(now, ci - 1);
            }
        }

        // 输出到达最后一个格子的最大得分
        System.out.println(dp[n - 1]);
    }
}
