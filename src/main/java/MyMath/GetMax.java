package MyMath;


// 不用比较运算符,找出两个数中较大的数
public class GetMax {

    public static void main(String[] args) {

        int max1 = getMax1(3, 5);
        System.out.println(max1);
    }

    // 0  1  得出相反数
    public static int flip(int n) {
        return n ^ 1;
    }

    // 得出一个数的符号位，1: 标识正数，0: 表示负数
    // 原理，服务符号位为 -1  正数符号位是1，将数字右移31位得到符号位
    public static int sign(int n) {
        // 右移31位，取符号位跟1与  得出正负
        return flip((n >> 31) & 1);
    }


    // 取出两个数较大的一个第一种方法  如果 a - b 有溢出，方法一有问题
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

    // 取出两个数较大的一个第二种方法
    public static int getMax2(int a, int b) {
        // 两数之差
        int c = a - b;
        // a 的符号位
        int sa = sign(a);
        // b 的符号位
        int sb = sign(b);
        // c 的符号位
        int sc = sign(c);
        // a b的符号位是否是相同的，1: 不相同  0: 相同
        int difSab = sa ^ sb;
        // a  b 符号位是否是相同的 1: 相同  0: 不相同
        int sameSab = flip(difSab);
        //  a-b 的符号位
        int returnA = difSab * sa + sameSab * sc;
        //  a-b的符号位的相反数
        int returnB = flip(returnA);

        return a * returnA + b * returnB;
    }

}
