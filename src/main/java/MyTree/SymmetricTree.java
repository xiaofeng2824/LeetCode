package MyTree;

import utils.TreeNode;

import java.util.LinkedList;

/**
 * 验证是否是对称树
 *
 * [1,2,2,3,4,4,3]  true
 *
 * 例：
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * [1,2,2,null,3,null,3] false
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 */
public class SymmetricTree {

    /**
     * 深度搜索
     * @param root
     * @return
     */
    public boolean isSymmtric(TreeNode root)
    {
        return root == null || helper(root.left,root.right);
    }

    public boolean helper(TreeNode left,TreeNode right)
    {
        if (left == null || right == null) return left == right;
        if (left.val != right.val) return false;

        return helper(left.left,right.right) && helper(left.right, right.left);
    }

    /**
     * 宽度搜索
     */

    public boolean isSymmtric1(TreeNode root)
    {
        if (root == null) return true;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);

        TreeNode left,right;
        while(q.size() > 1)
        {
            left = q.pop();
            right = q.pop();

            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;

            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }

        return true;

    }

    public static void main(String[] args) {

        SymmetricTree symmetricTree = new SymmetricTree();
        System.out.println(symmetricTree.isSymmtric(TreeNode.createTestData("[1,2,2,3,4,4,3]")));
        System.out.println(symmetricTree.isSymmtric1(TreeNode.createTestData("[1,2,2,3,4,4,3]")));

        System.out.println(symmetricTree.isSymmtric(TreeNode.createTestData("[1,2,2,null,3,null,3]")));
        System.out.println(symmetricTree.isSymmtric1(TreeNode.createTestData("[1,2,2,null,3,null,3]")));

    }

}
