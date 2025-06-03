package other;
import java.util.Scanner;

/**
 * 描述
 * 对于给定的由大小写字母、数字和空格混合构成的字符串
 * s
 * s，给定字符
 * c
 * c，按要求统计：
 * ∙
 *
 * ∙若
 * c
 * c 为大写或者小写字母，统计其大小写形态出现的次数和；
 * ∙
 *
 * ∙若
 * c
 * c 为数字，统计其出现的次数。
 *
 * 保证字符
 * c
 * c 要么为字母、要么为数字。
 * 输入描述：
 * 第一行输入一个长度
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
 * 1
 * 0
 * 3
 * 1≦length(s)≦10
 * 3
 *  ，由大小写字母、数字和空格构成的字符串
 * s
 * s。保证首尾不为空格。
 * 第二行输入一个字符
 * c
 * c，保证
 * c
 * c 为大小写字母或数字。
 * 输出描述：
 * 在一行上输出一个整数，代表统计结果。
 */

public class CountCharacter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str =   in.nextLine();
        String charStr = in.nextLine();
        char c = charStr.charAt(0);
        int count =  countCharacter(str,c);
        System.out.println(count);
    }


    public static int countCharacter(String str,Character c){

        // 边界处理
        if(str == null || str.length() == 0) return 0;


        // C 大写转小写
        if(c >= 'A' || c <= 'Z'){
            c = new Character(c.toString().toLowerCase().charAt(0));
        }

        char[] charArr = str.toLowerCase().toCharArray();


        int count = 0;
        for(char a : charArr){
            if(a == c){
                count++;
            }
        }
        return count;
    }
}
