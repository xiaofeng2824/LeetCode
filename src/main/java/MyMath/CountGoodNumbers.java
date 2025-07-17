package MyMath;

import java.util.Arrays;
import java.util.List;

public class CountGoodNumbers {

    /**
     * https://leetcode.cn/problems/count-good-numbers/submissions/621933893/?envType=daily-question&envId=2025-04-13
     * 1922 统计好数字的数目
     */
    public static List<Long> zhiShuList = Arrays.asList(2L, 3L, 5L, 7L);

    public static void main(String[] args) {

        System.out.println(countGoodNumbers2(1));
        System.out.println(countGoodNumbers2(4));
        System.out.println(countGoodNumbers2(50));
        System.out.println(countGoodNumbers2(10));
        System.out.println(countGoodNumbers(10));

//        System.out.println();

    }


    public static int countGoodNumbers(long n) {

        long start = (long) Math.pow(10, n - 1);
        long end = (long) Math.pow(10, n);

        int count = 0;

        for (long i = 0; i < end; i++) {
            if (isGoodNumber(i, n)) {
                count++;
                count = count % 1000000007;
            }
        }
        return count;
    }

    // 判断是否是一个好数字
    private static boolean isGoodNumber(long num, long n) {
        String str = String.valueOf(num);
        if (str.length() < n) {
            str = String.format("%0" + n + "d", num);
        }

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char charNum = chars[i];
            Long value = Long.valueOf(charNum) - '0';
            if (i % 2 == 0) {
                if (!(value % 2 == 0)) {
                    return false;
                }
            } else {
                if (!isZhiShu(value)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isZhiShu(long num) {
        return zhiShuList.contains(num);
    }


    // 方法2 ：
    public static int countGoodNumbers2(long n) {

        long res = 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                res *= 5;
            } else {
                res *= 4;
            }
        }
        res %= 1000000007;
        return (int) res;
    }
}
