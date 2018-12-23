package myString;

import java.lang.String;
public class String_05
{
    public static void main(String[] args)
    {
        String str = "0P";
        boolean flag = isPalindrome(str);
        System.out.println(flag);
        System.out.println( 'a' - 'A');
        System.out.println('P' - '0');
        
        
    }

    public static boolean isPalindrome(String s)
    {
        int length = s.length();
        if(length == 0)
        return true;

        int i = 0;
        int j = length - 1;

        while(i<j)
        {
            
            while(i<j && !isAlph(s.charAt(i)))
             {
                 i++;
             }
             while(i<j&&!isAlph(s.charAt(j)))
             {
                 j--;
             }

             if(Character.toLowerCase(s.charAt(i))  != Character.toLowerCase(s.charAt(j)) )
             {
                 return false;
             }
             i++;
             j--;
        }
        return true;

    }

    public  static boolean isAlph(char a)
    {
        return ((a>='a'&&a<='z') || (a>='A'&&a<='Z') ||(a>='0'&&a<='9'));
    }
}