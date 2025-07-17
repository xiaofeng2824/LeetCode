package MyMath;

/**
 * 只用位运算实现加减乘除
 */
public class MathOperation {
    public static void main(String[] args) {

        int a = 3;
        int b = 5;
        System.out.println(add(a, b));

        System.out.println(minus(3, 5));
        System.out.println(multi(3, 5));

    }

    // 位运算实现加法
    public static int add(int a, int b) {
        int sum = a;

        // 进位运算 可能 还有进位，所以需要循环
        while (b != 0) {
            // 不进位的加法使用 或运算
            sum = a ^ b;
            // 进位 使用 & 运算 再向左移一位
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    /**
     * 减法 实现 a - b 实现方式是  a + (- b)
     *
     * @param a
     * @param b
     * @return
     */
    public static int minus(int a, int b) {
        return add(a, negNum(b));
    }

    // 获取相反数 ~n=-(n + 1)
    public static int negNum(int n) {
        return add(~n, 1);
    }

    //  乘法
    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            // b 二进制上是0 就不进位
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            // 进一位
            a <<= 1;
            // b 右移一位
            b >>>= 1;
        }
        return res;
    }

    public static boolean isNeg(int n) {
        return n < 0;
    }

    // 除法
    public static int div(int a, int b) {
        // 负数 转化为正数
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 31; i > -1; i = minus(i, 1)) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }
}
