package other;

import java.util.*;

public class MergeTableRecord {

    StringBuilder StringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();

        Map<Integer, Integer> numMap = new TreeMap<>();
        while (count > 0) {
            String line = in.nextLine();
            if (line == null || line.length() == 0) {
                continue;
            }
            String[] strArr = line.split(" ");
            Integer key = Integer.parseInt(strArr[0]);
            numMap.put(key, numMap.getOrDefault(key, 0) + Integer.parseInt(strArr[1]));
            count--;
        }

        for (Integer key : numMap.keySet()) {
            System.out.println(key + " " + numMap.get(key));
        }

        List<String> list = new ArrayList<String>();

        Collections.sort(list);

        list.stream().sorted();

    }
}
