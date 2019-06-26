package MyTest;

import MyMath.IsPalindrome;
import MyMath.ReverseInterge;
import org.junit.Test;

public class testmath {


    @Test
    public void testReverseInt()
    {
        System.out.println(ReverseInterge.reverseInt(123));
        System.out.println(ReverseInterge.reverseInt(-123));
        System.out.println(ReverseInterge.reverseInt(120));
    }

    @Test
    public void testIspalindrome()
    {
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome(123321));
        System.out.println(isPalindrome.isPalindrome(1234321));
        System.out.println(isPalindrome.isPalindrome2(123321));
        System.out.println(isPalindrome.isPalindrome2(1234321));
    }



}
