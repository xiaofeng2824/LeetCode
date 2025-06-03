package other.two;

import java.util.*;

public class SimpleString {

    public static int[] fa = new int[505]; // 并查集数组

    // 并查集查找函数，带路径压缩
    public static int find(int x) {
        if (x == fa[x])
            return x;
        return fa[x] = find(fa[x]);
    }
    // 并查集合并函数，按秩合并
    public static    void merge(int x, int y) {
        int f1 = find(x);
        int f2 = find(y);
        if (f1 > f2) {
            int temp = f1;
            f1 = f2;
            f2 = temp;
        }
        fa[f2] = f1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        for (int i = 0; i < 505; i++) {
            fa[i] = i; // 初始化每个元素为自身的父节点
        }
        List<List<Character>> arr = new
                ArrayList<>(); // 用于存储小括号中的字符组
        StringBuilder s2 = new StringBuilder(); // 输出字符串
        List<Character> same = new ArrayList<>(); // 暂存小括号内的字符
        boolean f = false; // 标记是否在小括号内

        // 遍历输入字符串，提取括号内外的字符
        for (char c : s.toCharArray()) {
            if (c == '(') {
                f = true; // 进入小括号
            } else if (c == ')') {
                if (!same.isEmpty()) {
                    arr.add(new ArrayList<>(same)); // 将括号中的字符组存入arr
                }
                f = false; // 退出小括号
                same.clear(); // 清空暂存字符组
            } else {
                if (f) {
                    same.add(c); // 在括号内，收集字符
                } else {
                    s2.append(c); // 非括号内，直接添加到输出字符串
                }
            }
        }

        Set<Integer> st = new HashSet<>(); // 用于去重所有字符
        for (List<Character> i : arr) { // 将所有括号内的字符加入集合
            for (char j : i) {
                st.add((int) j);
            }
        }

        // 合并每组括号内的字符
        for (List<Character> i : arr) {
            for (int j = 0; j < i.size(); j++) {
                merge(i.get(0), i.get(j)); // 将每组字符合并到一起
            }
        }

        // 将大写字母和对应的小写字母合并
        for (int i = 'A'; i <= 'Z'; i++) {
            if (!st.contains(i))
                continue;
            int j = i - 'A' + 'a';
            if (!st.contains(j))
                continue;
            merge(j, i);
        }

        StringBuilder res = new StringBuilder(); // 存储结果字符串
        for (char i : s2.toString().toCharArray()) {
            res.append((char) find(i)); // 替换为合并后的最小字典序字符
        }

        if (res.length() == 0) { // 如果结果字符串为空，输出0
            System.out.println(0);
        } else {
            System.out.println(res.toString()); // 否则输出结果字符串
        }
    }

}
