package MyTree;

import utils.TreeNode;

/**
 * 题意是判断一棵二叉树是否是高度平衡的，
 * 所谓二叉树高度平衡指的是二叉树的每个节点的两棵子树的高度差都不超过 1，
 * 那么我们只需计算左右子树的高度，判断其高度差是否不超过 1 即可，
 * 如果超过 1，就代表其不是高度平衡的，立即返回不是即可，我这里用返回 `-1` 代表不是
 */
public class IsBlance {

    //判断二叉树是否是高度平衡的
    public boolean isBlance(TreeNode node) {
        return helper(node) != -1;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;

        //左子树的高度
        int left = helper(node.left);
        //左子树部不对称
        if (left == -1) return -1;
        //右子树的高度
        int right = helper(node.right);
        //右子树不对称
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;
        //深度 + 1
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        IsBlance solution = new IsBlance();
        TreeNode testData = TreeNode.createTestData("[1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5]");
        TreeNode.print(testData);
        System.out.println(solution.isBlance(testData));
    }

}
