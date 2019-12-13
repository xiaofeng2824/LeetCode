package MyTree;

import utils.TreeNode;

/**
 * 题意是让你算出二叉树中最远的两个节点的距离，
 * 分别计算左右子树的最大高度，然后不断迭代出其和的最大值就是最终结果。
 */
public class DiameterOfBinarytree {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root)
    {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) return  0;
        int l = helper(root.left);
        int r = helper(root.right);

        //max 记录当前节点的左右子树最远距离
        if (l + r > max ) max = l + r;
        //返回当前节点 最大深度
        return Math.max(l ,r) + 1;
    }

    public static void main(String[] args) {
        DiameterOfBinarytree solution = new DiameterOfBinarytree();
        System.out.println(solution.diameterOfBinaryTree(TreeNode.createTestData("[1,2,3,4,5]")));

    }
}
