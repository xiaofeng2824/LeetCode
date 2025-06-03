package other.two;

import java.util.*;


class Node {
    int val;
    Node left, right;
    int last;

    Node(int v) {
        val = v;
        left = right = null;
        last = 0;
    }
}

public class CalculateTreeNode {

    // 构建树的递归函数
    public static Node buildTree(int[] pre, int[] mid) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < mid.length; ++i) {
            int val = mid[i];
            mp.putIfAbsent(val, new ArrayList<>());
            mp.get(val).add(i);
        }

        int i[] = {0};
        Map<Integer, Integer> c = new HashMap<>();
        int index[] = new int[pre.length];

        for (int k = 0; k < pre.length; ++k) {
            int val = pre[k];
            c.put(val, c.getOrDefault(val, 0) + 1);
            index[k] = c.get(val) - 1;
        }

        return build(0, mid.length - 1, pre, mp, index, i);
    }

    private static Node build(int lc, int rc, int[] pre,
                              Map<Integer, List<Integer>> mp, int[] index, int[] i) {
        if (i[0] >= pre.length) return null;
        int val = pre[i[0]];
        int idx = mp.get(val).get(index[i[0]]);
        Node now = new Node(val);
        if (lc <= idx - 1) {
            i[0]++;
            now.left = build(lc, idx - 1, pre, mp, index, i);
        }
        if (rc >= idx + 1) {
            i[0]++;
            now.right = build(idx + 1, rc, pre, mp, index, i);
        }
        return now;
    }

    // 深度优先遍历，为每个节点计算 last 值
    public static void dfs(Node now) {
        if (now.left != null) {
            dfs(now.left);
            now.last += now.left.last + now.left.val;
        }
        if (now.right != null) {
            dfs(now.right);
            now.last += now.right.last + now.right.val;
        }
    }

    // 中序遍历，获取每个节点的 last 值
    public static void zhong(Node now, List<Integer> ans) {
        if (now == null) return;
        zhong(now.left, ans);
        ans.add(now.last);
        zhong(now.right, ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tmp = sc.nextLine().split(" ");
        int n=tmp.length;
        int[] mid = new int[n];
        int[] pre = new int[n];
        for (int i = 0; i < n; ++i) mid[i] = Integer.parseInt(tmp[i]);
        tmp = sc.nextLine().split(" ");
        for (int i = 0; i < n; ++i) pre[i] = Integer.parseInt(tmp[i]);

        Node root = buildTree(pre, mid);

        dfs(root);

        List<Integer> ans = new ArrayList<>();
        zhong(root, ans);

        for (int i = 0; i < ans.size(); ++i) {
            if (i > 0) System.out.print(" ");
            System.out.print(ans.get(i));
        }
        System.out.println();
    }
}
