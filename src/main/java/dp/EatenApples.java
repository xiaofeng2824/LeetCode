package dp;

import java.util.PriorityQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * https://leetcode.cn/problems/maximum-number-of-eaten-apples/description/
 * 1705 吃苹果的最大数量
 */
public class EatenApples {

    public static void main(String[] args) {
      int[]  apples = {1,2,3,5,2}, days = {3,2,1,4,2};
      System.out.println(eatenApples(apples,days));
    }

    public static int eatenApples(int[] apples, int[] days) {
        int ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < apples.length || !pq.isEmpty(); i++) {

            // 剔除已腐烂的苹果
            while (!pq.isEmpty() && pq.peek()[0] == i) { // 已腐烂
                pq.poll();
            }
            if (i < apples.length && apples[i] > 0) {
                pq.offer(new int[]{i + days[i], apples[i]});
            }
            if (!pq.isEmpty()) {
                // 吃一个最早腐烂的苹果
                ans++;
                if (--pq.peek()[1] == 0) {
                    pq.poll();
                }
            }
        }
        return ans;
    }

}
