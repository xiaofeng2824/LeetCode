package MyTest;

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


}
