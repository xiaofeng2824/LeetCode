package myString;

import java.util.ArrayList;
import java.util.List;

public class ZConvert {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 3));
    }

    public static String convert(String s, int numRows) {

        if (numRows < 2) return s;

        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) res.append(row);
        return res.toString();
    }
}
