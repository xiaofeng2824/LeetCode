package other;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumConversion {

    public static Map<Character,Integer> charMap = new HashMap<Character,Integer>();

    static{
        charMap.put('0',0);
        charMap.put('1',1);
        charMap.put('2',2);
        charMap.put('3',3);
        charMap.put('4',4);
        charMap.put('5',5);
        charMap.put('6',6);
        charMap.put('7',7);
        charMap.put('8',8);
        charMap.put('9',9);
        charMap.put('A',10);
        charMap.put('B',11);
        charMap.put('C',12);
        charMap.put('D',13);
        charMap.put('E',14);
        charMap.put('F',15);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        String numStr = in.nextLine();

        int num = printOxNum(numStr);
        System.out.println(num);
    }

    public static int printOxNum(String numStr){

        if(numStr == null || numStr.length() < 3) return 0;

        numStr = numStr.substring(2);
        int index = numStr.length() - 1;

        int sum = 0;
        int pow = 0;
        while(index > -1){
            char c = numStr.charAt(index);
            sum += charMap.get(c) *  Math.pow(16,pow);

            index--;
            pow++;
        }
        return sum;
    }
}
