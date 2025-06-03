package other.two;

import java.util.*;

public class TreeQuery {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        HashMap<String, List<String>> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] s = scanner.nextLine().split(" ");
            if (!mp.containsKey(s[1])) {
                mp.put(s[1], new ArrayList<>());
            }
            mp.get(s[1]).add(s[0]);
        }
        String go = scanner.nextLine();
        List<String> ans = new ArrayList<>();
        Deque<String> que = new LinkedList<>();
        que.add(go);
        while (!que.isEmpty()) {
            String now = que.pollFirst();
            if (mp.containsKey(now)) {
                for (String x : mp.get(now)) {
                    ans.add(x);
                    que.add(x);
                }
            }
        }
        ans.sort(String::compareTo);
        for (String s : ans) {
            System.out.println(s);
        }
        scanner.close();
    }
}
