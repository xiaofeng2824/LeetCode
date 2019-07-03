package MyTree;

import utils.TreeNode;

/**
 *题意是查找二叉树中是否存在从根结点到叶子的路径和为某一值，
 * 利用深搜在遇到叶子节点时判断是否满足即可。
 *
 * Given the below binary tree and `sum = 22`,
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 *
 * return true, as there exist a root-to-leaf path `5->4->11->2` which sum is 22.
 */
public class PathSum {

    public boolean isPathSum(TreeNode root,int sum)
    {
       if (root == null) return false;
       if (root.left == null && root.right == null) return sum == root.val;
       return isPathSum(root.left,sum - root.val) || isPathSum(root.right,sum - root.val);
    }

    public static void main(String[] args) {
        PathSum solution = new PathSum();
        TreeNode testData = TreeNode.createTestData("[5,4,8,11,null,13,4,7,2,null,null,null,1]");
        TreeNode.print(testData);
        System.out.println(solution.isPathSum(testData, 22));
    }
}
