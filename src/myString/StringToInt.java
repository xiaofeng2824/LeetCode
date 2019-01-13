package myString;

/*
* 字符串转换整数
* */
import java.lang.String;
public class StringToInt
{
    public static void main(String[] args)
    {
        String str = "42";
        int nub = atoi(str);
        System.out.println(nub);   
    }

    public static int atoi(String str)
    {
        if(str.isEmpty()) return 0;
        
        str = str.trim();
        int result = 0;
        boolean isPos = true;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(i==0 && (c=='-'||c=='+')){
                isPos = c=='+'?true:false;
            } else if (c>='0' && c<='9'){
                // ���������
                if(result>(Integer.MAX_VALUE - (c - '0'))/10){
                    return isPos? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result *= 10;
                result += c - '0';
            } else {
                return isPos?result:-result;
            }
        }
        return isPos?result:-result;

    }
}