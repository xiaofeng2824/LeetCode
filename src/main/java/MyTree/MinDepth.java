package MyTree;

import utils.TreeNode;

/**
 * 求树的最小深度
 */
public class MinDepth {

    public int minDepth(TreeNode node)
    {
       if (node == null) return 0;
       return helper(node);
    }

    private int helper(TreeNode node) {
        if(node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);

        return left < right ? left+1 :right+1;
    }

    public static void main(String[] args) {
        MinDepth solution = new MinDepth();
        TreeNode testData = TreeNode.createTestData("[1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5]");
        TreeNode.print(testData);
        System.out.println(solution.minDepth(testData));
    }


}
