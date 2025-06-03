package other.two;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SpreedTime {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(",");

        int n = (int) Math.sqrt(s.length);
        int[][] mp = new int[n][n];
        int id = 0;
        int cnt0 = 0;
        Queue<int[]> queue = new LinkedList<>();

        // 填充地图并统计未感染区域（0）的数量
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mp[i][j] = Integer.parseInt(s[id]);
                id++;
                if (mp[i][j] == 0) {
                    cnt0++;
                } else {
                    queue.add(new int[] {i, j, 0});
                }
            }
        }

        // 如果没有未感染区域或者全是未感染区域，返回-1
        if (cnt0 == 0 || cnt0 == n * n) {
            System.out.println(-1);
            return;
        }

        // 方向数组，上下左右四个方向
        int[] dir = {0, 1, 0, -1, 0};
        int maxDays = 0;

        // 广度优先搜索（BFS）遍历感染扩展的过程
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int days = current[2];
            maxDays = Math.max(maxDays, days);
            for (int i = 0; i < 4; i++) {
                int xx = x + dir[i];
                int yy = y + dir[i + 1];
                if (xx >= 0 && xx < n && yy >= 0 && yy < n && mp[xx][yy] == 0) {
                    queue.add(new int[] {xx, yy, days + 1});
                    mp[xx][yy] = 1;
                }
            }
        }

        // 输出最终的最大天数，即地图全部感染所需天数
        System.out.println(maxDays);
    }

}
