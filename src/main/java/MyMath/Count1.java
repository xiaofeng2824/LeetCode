package MyMath;

/**
 * 计算二进制中1的个数
 */
public class Count1 {

    public static void main(String[] args) {

    }

    // 一次遍历二进制上的每位数字，然后依次相加
    public static int count(int num) {
        int res = 0;
        while (num != 0) {
            // num & 1 得到 二进制上最后一个数字
            res += num & 1;
            // num 右移一位
            num >>>= 1;
        }
        return res;
    }

    // 没太懂
    public static int count2(int num) {
        int res = 0;
        while (num != 0) {
            num &= (num - 1);
            res++;
        }
        return res;
    }

}
