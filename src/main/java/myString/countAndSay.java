package myString;

/**
 * 例子：
 * 1：一个1 -> 11
 * 11 两个1 -> 21
 * 21 一个2一个1 -> 1211
 */
public class countAndSay
{
    public static void main(String[] args)
    {
        int n =5;
        String str = countAndSay(n);
        System.out.println(str);
    }

    public static String countAndSay(int n)
    {
       if(n<=0) return "-1";
       String result = "1";
       for(int i=1;i<n;i++)
       {
           StringBuilder builder = new StringBuilder();
           int index = 0;

           while(index < result.length())
           {
               //取出字符串每位数字
               char val = result.charAt(index);
               //记录字符串数字出现的次数
               int count= 0;

               //判断是否有同样的字符
               while(index < result.length() && result.charAt(index) == val)
               {
                   index++;
                   count++;
               }
               //拼有几个字符
               builder.append(String.valueOf(count));
               builder.append(val);
           }

           result = builder.toString();
       }

       return result;



    }

  
}