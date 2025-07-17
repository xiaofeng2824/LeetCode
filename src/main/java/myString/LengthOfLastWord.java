package myString;

/**
 * 计算最后一个单词的长度
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        //字符串长度
        int p = s.length() - 1;

        //最后一个单词的最后一个字母
        while (p >= 0 && s.charAt(p) == ' ') p--;
        int end = p;
        //最后一个单词的第一个字母
        while (p >= 0 && s.charAt(p) != ' ') p--;
        return end - p;

    }

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        System.out.println(lengthOfLastWord.lengthOfLastWord("Hello world"));
        System.out.println(lengthOfLastWord.lengthOfLastWord("I love you "));

    }

}
