package myString;

/*
 * 字符串的反转
 * */
public class ReverseString {
    public static void main(String[] args) {
        String str = "123456789abcd";
        System.out.println(str);

        String str_reverse = reverse_String(str);

        System.out.println(str_reverse);

    }

    public static String reverse_String(String str) {
        int length = str.length();
        char[] str_CharArray = new char[length];
        str_CharArray = str.toCharArray();

        for (int i = 0; i < length / 2; i++) {
            char tmp = str_CharArray[i];
            str_CharArray[i] = str_CharArray[length - i - 1];
            str_CharArray[length - i - 1] = tmp;
        }

        String revsrseString = new String(str_CharArray);
        return revsrseString;
    }
}