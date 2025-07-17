package MyMath;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Input: 123
 * Output:  321
 * <p>
 * Input: -123
 * Output: -321
 * <p>
 * Input: 120
 * Output: 21
 * <p>
 * 题意是给你一个整型数，求它的逆序整型数，而且有个小坑点，当它的逆序整型数溢出的话，
 * 那么就返回 0，用我们代码表示的话可以求得结果保存在 long 中，最后把结果和整型的两个范围比较即可。
 */
public class ReverseInterge {

    public static int reverseInt(int x) {
        long res = 0;
        for (; x != 0; x = x / 10) {
            res = res * 10 + x % 10;
        }

        return x > Integer.MAX_VALUE || x < Integer.MIN_VALUE ? 0 : (int) res;
    }
}
