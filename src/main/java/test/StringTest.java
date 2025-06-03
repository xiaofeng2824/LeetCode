package test;

import java.lang.reflect.Field;

public class StringTest {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        String s = new String("abc");

        Field value = s.getClass().getDeclaredField("value");
        value.setAccessible(true);
        value.set(s, "abcd".toCharArray());
        System.out.println(s);
    }
}
