package myString;

/*
 * 有效的字母异位词
 * */
public class String_04 {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagarma";
        boolean flag = isAnagram(s, t);
        System.out.println(flag);
    }

    public static boolean isAnagram(String s, String t) {

        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}