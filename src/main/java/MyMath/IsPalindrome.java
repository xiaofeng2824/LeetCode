package MyMath;

/**
 * 判断一个数是否是回文数
 * examples：
 * Input: 121
 * Output: true
 * <p>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * <p>
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */
public class IsPalindrome {

    /**
     * 直接算出回文数与原数比较
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        //如果数字是负数
        if (x < 0)
            return false;

        int regex = x, reverse = 0;
        while (regex != 0) {
            reverse = reverse * 10 + regex % 10;
            regex /= 10;
        }

        return x == reverse;
    }

    /**
     * 算一半的长度
     * 例如 1234321 4321  和 321
     * 12344321  算得 1234 和 4321
     * <p>
     * 但是 10010 也是相等的 因此排除是10的整数倍的情况
     */

    public boolean isPalindrome2(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0))
            return false;

        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        return x == reverse || x == reverse / 10;
    }
}
