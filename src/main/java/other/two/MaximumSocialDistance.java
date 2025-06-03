package other.two;

/**
 * 最大社交距离
 */
public class MaximumSocialDistance {

    // 计算每个座位的位置得分，用于选出最佳座位
    public static int calc(int n, int i, int[] use) {
        if (use[i] == 1) {
            return -10000; // 如果座位已被使用，返回一个很小的值，表示该位置不适合
        }
        int now = 10000; // 初始化当前位置得分为很大值，逐步计算最小距离
        int lc = i, rc = i; // 左右最近的已使用座位
        int j = i - 1;
        while (j >= 0) {
            if (use[j] == 1) {
                lc = j; // 找到左边最近的已使用座位
                break;
            }
            --j;
        }
        j = i + 1;
        while (j < n) {
            if (use[j] == 1) {
                rc = j; // 找到右边最近的已使用座位
                break;
            }
            ++j;
        }
        if (lc == i) {
            now = rc -
                    i; // 如果左边没有已使用座位，使用右边距离作为得分
        } else if (rc == i) {
            now = i - lc; // 如果右边没有已使用座位，使用左边距离作为得分
        } else {
            now = Math.min(rc - i, i -
                    lc); // 否则使用左右距离的最小值作为得分
        }
        return now;
    }

    // 计算最后一个员工会坐在哪个位置
    public static int conferenceSeatDistance(int seatNum, int[] seatOrLeave) {
        int n = seatNum;
        int[] use = new int[n]; // 记录每个座位是否已被使用
        int last = 0; // 记录最后一个入座的位置
        for (int x : seatOrLeave) {
            if (x < 0) {
                use[-x] = 0; // 员工离开，更新座位状态为未使用
                continue;
            }
            int now = -10000;
            for (int i = 0; i < n; ++i) {
                now = Math.max(now, calc(n, i, use)); // 计算并找到最佳分数
            }
            if (now < 0) {
                last = -1; // 如果没有可用座位
                continue;
            }
            for (int i = 0; i < n; ++i) {
                if (now == calc(n, i, use)) {
                    last = i; // 分配座位给员工
                    use[i] = 1; // 更新座位状态为已使用
                    break;
                }
            }
        }
        return last; // 返回最后一个员工入座的位置
    }

    public static void main(String[] args) {
        System.out.println(conferenceSeatDistance(10, new int[] { 1, 1, 1, 1, -4, 1 })); // 5
    }

}
