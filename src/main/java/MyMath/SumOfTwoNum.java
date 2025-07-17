package MyMath;

//给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。

// 示例 1：

//输入：a = 1, b = 2
//输出：3

// 示例 2：
//输入：a = 2, b = 3
//输出：5

// 提示：
//
//
// -1000 <= a, b <= 1000
//
// Related Topics 位运算 数学
// 👍 563 👎 0

// 位运算 实现算数运算
public class SumOfTwoNum {


    //  加法
    public static int add(int a, int b) {
        int sum = a;

        while (b != 0) {
            // 异或 处理 加法
            sum = a ^ b;
            // 处理进位
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    //
    public static void main(String[] args) {
        System.out.println("1 + 2 = " + add(1, 2));
        System.out.println("2 + 3 = " + add(2, 3));
    }
}
