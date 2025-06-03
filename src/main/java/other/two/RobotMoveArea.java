package other.two;

import java.util.Scanner;

public class RobotMoveArea {

    static int n, m;
    static int[][] g;
    static boolean[][] vis;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        g = new int[n][m];
        vis = new boolean[n][m];

        // 读取网格数据
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = sc.nextInt();
            }
        }

        int res = 0;
        // 遍历整个网格
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j]) {
                    res = Math.max(res, dfs(i, j));
                }
            }
        }

        // 输出结果
        System.out.println(res);
    }

    // 深度优先搜索函数
    private static int dfs(int x, int y) {
        vis[x][y] = true;
        int now = 1;
        // 遍历四个方向的邻居网格
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 检查邻居网格是否在边界内且未被访问
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !vis[nx][ny]) {
                // 检查邻居网格和当前网格的值差是否小于等于1
                if (Math.abs(g[nx][ny] - g[x][y]) <= 1) {
                    now += dfs(nx, ny);
                }
            }
        }
        return now;
    }
}
