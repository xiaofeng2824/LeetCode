package MyMath;

public class GetMax {

    public static void main(String[] args) {

        int max1 = getMax1(3, 5);
        System.out.println(max1);

    }

    public static int flip(int n) {
        return n ^ 1;
    }
    public static int sign(int n) {
        // 右移31位，取符号位跟1与  得出正负
        return flip((n >> 31) & 1);
    }
    public static int getMax1(int a, int b) {
        // 取差值
        int c = a - b;
        // a大小的标志  0 表示小  1 表示大
        int scA = sign(c);
        // b大小的标志  0 表示小  1 表示大  将a的标志 或一下就行
        int scB = flip(scA);
        // 返回最大的数
        return a * scA + b * scB;
    }
}
