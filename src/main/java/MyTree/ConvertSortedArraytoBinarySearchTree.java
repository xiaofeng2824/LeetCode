package MyTree;

import utils.TreeNode;

/**
 * 题意是把一个有序数组转化为一棵二叉搜索树，二叉搜索树具有以下性质：
 *
 * 1. 若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
 * 2. 若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
 * 3. 任意节点的左、右子树也分别为二叉查找树；
 * 4. 没有键值相等的节点。
 *
 * 所以我们可以用递归来构建一棵二叉搜索树，每次把数组分为两半，把数组中间的值作为其父节点，
 * 然后把数组的左右两部分继续构造其左右子树。
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class ConvertSortedArraytoBinarySearchTree {

    //将数组转化为二叉树
    public TreeNode sortedArrayToBST(int[] nums)
    {
        //判空
        if(nums == null || nums.length == 0)
            return null;

        //建树过程
        return helper(nums,0,nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        //递归循环建树
        if (left > right) return null;
        int mid = (left + right) >> 1;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums,left,mid - 1);
        node.right = helper(nums,mid + 1,right);

        //返回根节点
        return node;

    }

    public static void main(String[] args) {
        ConvertSortedArraytoBinarySearchTree convert = new ConvertSortedArraytoBinarySearchTree();
        TreeNode.print(convert.sortedArrayToBST(new int[]{0, 1, 2, 3, 4, 5, 6, 7}));
    }


}
