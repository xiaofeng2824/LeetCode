package MyTree;

import utils.TreeNode;

/**
 * 题意是比较两棵二叉树是否相同，那么我们就深搜比较各个节点即可。
 * <p>
 * Input:     1         1
 * / \       / \
 * 2   3     2   3
 * <p>
 * [1,2,3],   [1,2,3]
 * <p>
 * Output: true
 * <p>
 * Input:     1         1
 * /           \
 * 2             2
 * <p>
 * [1,2],     [1,null,2]
 * <p>
 * Output: false
 */
public class IsSameTree {
    public boolean isSametree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val)
            return isSametree(p.left, q.left) && isSametree(p.right, q.right);

        return false;
    }

    public static void main(String[] args) {
        IsSameTree isSameTree = new IsSameTree();
        boolean sametree = isSameTree.isSametree(TreeNode.createTestData("[1,2,3]"), TreeNode.createTestData("[1,2,3]"));
        boolean sametree2 = isSameTree.isSametree(TreeNode.createTestData("[1,2]"), TreeNode.createTestData("[1,null,3]"));

        System.out.println("tree1:" + sametree);
        System.out.println("tree2:" + sametree2);

    }
}
