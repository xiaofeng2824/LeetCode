package other.two;

import java.util.*;

public class HorseJump {

    static class Knight {
        int x, y, moves;

        Knight(int x, int y, int moves) {
            this.x = x;
            this.y = y;
            this.moves = moves;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();  // Consume the remaining newline

        String[] g = new String[n];
        List<Knight> ma = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            g[i] = sc.nextLine();
            for (int j = 0; j < m; j++) {
                if (g[i].charAt(j) != '.') {
                    ma.add(new Knight(i, j, Character.getNumericValue(g[i].charAt(j))));
                }
            }
        }

        int[][] dir = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
        int[][] res = new int[n][m];

        for (Knight houre : ma) {
            int[][] dis = new int[n][m];
            for (int[] row : dis) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            dis[houre.x][houre.y] = 0;

            Deque<int[]> q = new ArrayDeque<>();
            q.add(new int[]{houre.x, houre.y});

            while (!q.isEmpty()) {
                int[] current = q.poll();
                int x = current[0], y = current[1];

                for (int[] d : dir) {
                    int dx = x + d[0], dy = y + d[1];
                    if (dx < 0 || dx >= n || dy < 0 || dy >= m) continue;
                    if (dis[dx][dy] != Integer.MAX_VALUE) continue;

                    dis[dx][dy] = dis[x][y] + 1;
                    q.add(new int[]{dx, dy});
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (dis[i][j] == Integer.MAX_VALUE) continue;
                    if (dis[i][j] > houre.moves) {
                        dis[i][j] = Integer.MAX_VALUE;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (dis[i][j] != Integer.MAX_VALUE) {
                        res[i][j] += dis[i][j];
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.min(ans, res[i][j]);
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
