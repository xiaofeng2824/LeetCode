package other;

import java.util.Scanner;

/**
 * 描述
 * 对于给定的由小写字母和数字混合构成的字符串
 * s
 * s，你需要按每
 * 8
 * 8 个字符换一行的方式书写它，具体地：
 * ∙
 * <p>
 * ∙书写前8 个字符，换行；
 * ∙
 * <p>
 * ∙书写接下来的8 个字符，换行；
 * ∙重复上述过程，直到字符串被完全书写。
 * 特别地，如果最后一行不满8
 * 8 个字符，则需要在字符串末尾补充0
 * 0，直到长度为
 * <p>
 * 输入描述：
 * 在一行上输入一个长度
 * 1
 * ≦
 * l
 * e
 * n
 * g
 * t
 * h
 * (
 * s
 * )
 * ≦
 * 100
 * 1≦length(s)≦100，由小写字母和数字构成的字符串
 * s
 * s。
 * 输出描述：
 * 输出若干行，每行输出
 * 8
 * 8 个字符，代表按题意书写的结果。
 */
public class SplitPrintString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = in.nextLine();
        splitPrintString(str);
    }

    public static void splitPrintString(String str) {

        // 边界处理
        if (str == null || str.length() == 0) return;

        int index = 0;
        int length = str.length();

        while (index < length) {

            if (index + 8 <= length) {
                String subStr = str.substring(index, index + 8);
                System.out.println(subStr);
            } else {
                String subStr = str.substring(index, length);
                subStr = subStr + String.format("%0" + (8 - subStr.length()) + "d", 0);
                System.out.println(subStr);
            }
            index = index + 8;
        }
    }
}
