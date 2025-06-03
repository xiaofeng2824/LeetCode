package other.two;

import java.util.Scanner;

public class StudentSquare {

    // 检查坐标是否在矩阵范围内
    static boolean ok(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nm = sc.nextLine().split(",");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[][] g = new int[n][m];  // 初始化矩阵

        // 读取矩阵数据
        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(",");
            for (int j = 0; j < m; j++) {
                if (line[j].trim().equals("M")) {
                    g[i][j] = 1;  // 'M' 表示男生，用1来表示
                }
            }
        }

        // 四个方向的位移：水平、垂直、对角线、反对角线
        int[][] d = {{1, 0}, {0, 1}, {1, 1}, {1, -1}};
        int mx = 0;  // 用于存储最长相连男生的数量

        // 遍历矩阵的每一个元素
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 0) continue;  // 如果当前坐标不是男生，则跳过
                for (int k = 0; k < 4; k++) {
                    int di = i - d[k][0], dj = j - d[k][1];
                    if (ok(di, dj, n, m) &&
                            g[di][dj] == 1) continue;  // 如果前一个坐标在范围内且是男生，则跳过
                    int c = 1;  // 初始化当前方向相连男生的数量
                    di = i + d[k][0];
                    dj = j + d[k][1];
                    while (ok(di, dj, n, m) && g[di][dj] == 1) {
                        c++;  // 累加相连男生的数量
                        di += d[k][0];
                        dj += d[k][1];  // 继续移动到下一个坐标
                    }
                    mx = Math.max(mx, c);  // 更新最大相连男生的数量
                }
            }
        }

        System.out.println(mx);  // 输出结果
    }

}
