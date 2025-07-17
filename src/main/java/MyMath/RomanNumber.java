package MyMath;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转化为数字
 * <p>
 * 相关的数字表示含义
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * <p>
 * 几个例子
 * Input: "III"
 * Output: 3
 * <p>
 * Input: "IV"
 * Output: 4
 * <p>
 * Input: "IX"
 * Output: 9
 * <p>
 * Input: "LVIII"
 * Output: 58
 * Explanation: C = 100, L = 50, XXX = 30 and III = 3.
 * <p>
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */

public class RomanNumber {

    public static int roman2Int(String s) {
        Integer sum = 0;

        //构建对应关系
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        sum = map.get(s.charAt(s.length() - 1));
        //将罗马数字转化为数字
        for (int i = s.length() - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                sum -= map.get(s.charAt(i));
            } else {
                sum += map.get(s.charAt(i));
            }
        }

        return sum;
    }

    //测试
    public static void main(String[] args) {

        System.out.println(roman2Int("VII"));
        System.out.println(roman2Int("III"));
        System.out.println(roman2Int("LVIII"));
        System.out.println(roman2Int("MCMXCIV"));
    }
}
