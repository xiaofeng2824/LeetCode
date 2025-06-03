package other.two;

import java.util.*;

public class LetterCombination {

    // 字典 mp 用于存储数字字符与对应字母串的映射
    static Map<Character, String> mp = new HashMap<>();
    // 集合 st 用于存储禁止出现的字符
    static Set<Character> st = new HashSet<>();
    // 列表 res 用于存储结果字符串
    static List<String> res = new ArrayList<>();

    // 初始化函数，建立数字与其对应字母的映射
    public static void init() {
        mp.put('0', "abc");
        mp.put('1', "def");
        mp.put('2', "ghi");
        mp.put('3', "jkl");
        mp.put('4', "mno");
        mp.put('5', "pqr");
        mp.put('6', "st");
        mp.put('7', "uv");
        mp.put('8', "wx");
        mp.put('9', "yz");
    }

    // 深度优先搜索函数生成所有可能的字母组合
    public static void dfs(int x, String now, int n, String s) {
        // 递归终止条件：当拼接的字符串长度等于输入字符串长度时
        if (x == n) {
            // 集合 mk 用于存储当前组合中出现的禁止字符
            Set<Character> mk = new HashSet<>();
            for (char c : now.toCharArray()) {
                // 检查并存储禁止字符
                if (st.contains(c))
                    mk.add(c);
            }
            // 如果当前组合包含所有的禁止字符，则不加入结果集
            if (mk.size() == st.size())
                return;
            // 当前组合有效，加入结果集
            res.add(now);
            return;
        }
        // 获取当前数字对应的字母串
        String tmp = mp.get(s.charAt(x));
        // 遍历字母串，递归处理后续字符
        for (char c : tmp.toCharArray()) {
            dfs(x + 1, now + c, n, s);
        }
    }

    public static void main(String[] args) {
        init(); // 初始化数字与字母的映射
        Scanner scanner = new Scanner(System.in);
        // 循环读取输入
        while (scanner.hasNext()) {
            String s = scanner.next(); // 读取数字字符串
            String t = scanner.next(); // 读取禁止字符集合
            res.clear(); // 清空上一次运行的结果
            st.clear(); // 清空上一次运行的禁止字符集合
            // 将禁止字符存入集合中
            for (char c : t.toCharArray())
                st.add(c);
            // 进行深度优先搜索组合
            dfs(0, "", s.length(), s);
            // 输出结果
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i) + ",");
            }
            System.out.println();
        }
        scanner.close(); // 关闭 Scanner 对象
    }
    }
