package myString;

/**
 * 题意是给你两个二进制串，求其和的二进制串。
 * 我们就按照小学算数那么来做，用 `carry` 表示进位，
 * 从后往前算，依次往前，每算出一位就插入到最前面即可，
 * 直到把两个二进制串都遍历完即可
 * 例：
 * Input: a = "11", b = "1"
 * Output: "100"
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        //carry 进位
        int carry = 0;
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;

        while (p1 >= 0 && p2 >= 0) {
            carry += a.charAt(p1--) - '0';
            carry += b.charAt(p2--) - '0';
            sb.insert(0, (char) (carry % 2 + '0'));
            carry >>= 1;
        }

        while (p1 >= 0) {
            carry += a.charAt(p1--) - '0';
            sb.insert(0, (char) (carry % 2 + '0'));
            carry >>= 1;
        }

        while (p2 >= 0) {
            carry += b.charAt(p2--) - '0';
            sb.insert(0, (char) (carry % 2 + '0'));
            carry >>= 1;
        }
        if (carry == 1) {
            sb.insert(0, '1');
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        AddBinary addBinary = new AddBinary();
        //System.out.println(addBinary.addBinary("11","1"));
        System.out.println(addBinary.addBinary("1010", "1011"));
    }

}
