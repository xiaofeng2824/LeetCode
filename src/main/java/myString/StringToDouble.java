package myString;

public class StringToDouble {

    /**
     * 写一个开源基础工具类，
     * 实现String转Double工具类。
     * 不应出现Double.valueOf,String.parseDouble等方式，
     * 不应出现new Double(入参)，不应使用BigDecimal
     */


    public static void main(String[] args) {

    }

    public static Double String2Double(String str) {

        if (str.isEmpty()) return null;

        //去掉前后的空格
        str = str.trim();

        double result = 0;
        // 正数 负数的标识
        boolean isPos = true;
        boolean flag = false;
        double temp = 1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            //判断正数还是负数
            if (i == 0 && (c == '-' || c == '+')) {
                isPos = c == '+' ? true : false;
            } else if (c == '.') {
                flag = true;
            } else if (c >= '0' && c <= '9') {

                // 正数部分
                if (!flag) {

                    if (result > (Double.MAX_VALUE - (c - '0')) / 10) {
                        return isPos ? Double.MAX_VALUE : Double.MIN_VALUE;
                    }
                    result *= 10;
                    result += c - '0';
                } else {
                    // 小数部分
                    temp = temp * 0.1;
                    result += (c - '0') * temp;
                }
            } else {
                return isPos ? result : -result;
            }
        }
        return isPos ? result : -result;

    }
}
