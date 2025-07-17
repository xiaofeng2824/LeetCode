package other;

import java.util.Scanner;

/**
 * 近似值
 */
public class Approximation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        float num = in.nextFloat();

        float xiaoshu = num;

        int zhengshu = 0;
        while (xiaoshu > 1) {
            zhengshu++;
            xiaoshu = num - zhengshu;
        }

        if (xiaoshu >= 0.5) {
            System.out.print(++zhengshu);
        } else {
            System.out.print(zhengshu);
        }

    }
}
