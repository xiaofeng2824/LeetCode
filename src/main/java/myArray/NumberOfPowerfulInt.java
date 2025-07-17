package myArray;

public class NumberOfPowerfulInt {


    public static void main(String[] args) {

        /**
         * 20
         * 120
         * 220
         * 320
         * 420
         * 520
         * 1020
         * 1120
         */
        // long start = 1829505, finish = 1255574165; int limit = 7;String s = "11223";

        long start = 20, finish = 1159;
        int limit = 5;
        String s = "20";

        long startTime = System.currentTimeMillis();
        long count = numberOfPowerfulInt(start, finish, limit, s);
        long endTime = System.currentTimeMillis();

        System.out.println("时间:" + (endTime - startTime));
        System.out.println("count:" + count);

    }


    public static long numberOfPowerfulInt(long start, long finish, int limit, String s) {

        long sum = 0;
        long num = Integer.parseInt(s);

        // 边界判断
        if (finish < num) return sum;

        int minLength = s.length();
        int maxLength = String.valueOf(finish).length();

        long step = (long) Math.pow(10, s.length());

        for (int i = 0; i < maxLength - minLength; i++) {
            for (int j = 0; j <= limit; j++) {

            }

        }
        return sum;
    }


    // 暴力计算
    public static long numberOfPowerfulInt2(long start, long finish, int limit, String s) {

        long sum = 0;
        long num = Integer.parseInt(s);

        // 边界判断
        if (finish < num) return sum;

        long step = (long) Math.pow(10, s.length());

        for (long i = start; i <= finish; ) {
            if (limitNumber(i, limit) && endWith(i, s)) {
                System.out.println(i);
                sum++;
            }

            if (sum > 0) {
                i = step + i;
            } else {
                i++;
            }
        }
        return sum;
    }

    private static boolean endWith(long i, String s) {
        String numStr = String.valueOf(i);
        return numStr.endsWith(s);
    }


    public static boolean limitNumber(Long number, int limit) {
        while (number > 0) {
            long num = number % 10;
            if (num > limit) {
                return false;
            }
            number /= 10;
        }
        return true;
    }
}
