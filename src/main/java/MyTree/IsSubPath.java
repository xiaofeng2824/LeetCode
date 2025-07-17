package MyTree;

import utils.ListNode;
import utils.TreeNode;

/**
 * https://leetcode.cn/problems/linked-list-in-binary-tree/
 * 二叉树中的链表
 */
public class IsSubPath {
    public static void main(String[] args) {

        ListNode head = ListNode.createTestData("[4,2,8]");
        ListNode.print(head);
        TreeNode root = TreeNode.createTestData("[1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]");
        TreeNode.print(root);


//        ListNode head = ListNode.createTestData("[10,7,4,10,2,6,10,10,10,1,10,6]");
//        ListNode.print(head);
//        TreeNode root = TreeNode.createTestData("[1,10,7,10,8,6,1,10,7,1,10,4,3,9,null,10,10,4,10,7,1,3,7,null,null,7,9,6,3,null,null,8,10,10,3,1,1,null,null,null,null,null,2,null,null,10,3,5,null,null,null,6,null,5,null,null,6,2,5,null,4,null,10,9,10,null,null,null,3,10,8,5,6,null,7,3,null,8,9,6,2,null,8,9,10,10,null,4,6,4,null,null,2,5,6,null,null,null,null,6,null,1,null,null,null,null,8,null,null,10,10,null,null,null,8,null,null,3,10,null,null,10,2,null,null,7,6,null,null,null,null,null,null,null,null,null,null,4,null,null,10,null,2,null,null,1,6,null,null,8,9,null,null,null,8,4,null,null,null,10,4,null,1,null,null,null,null,9,null,null,null,null,null,9,null,10,1,6,null,null,null,null,null,null,null,5,null,2,10,null,null,null,null,null,null,null,6,null,5]");
//        TreeNode.print(root);


        System.out.println(isSubPath(head, root));
    }

    public static boolean isSubPath(ListNode head, TreeNode root) {

        if (root == null) return false;
        // 判断当前节点
        ListNode cur = head;
        TreeNode treeNode = root;

        boolean curRes = helper(cur, treeNode);
        if (curRes) return true;

        // 判断左节点
        boolean leftRes = isSubPath(head, root.left);
        if (leftRes) return true;

        // 判断右节点
        boolean rightRes = isSubPath(head, root.right);
        if (rightRes) return true;

        return false;
    }

    // 单一节点向下遍历
    public static boolean helper(ListNode current, TreeNode treeNode) {
        if (current == null) return true;
        if (treeNode == null) return false;

        if (current.val == treeNode.val) {
            return helper(current.next, treeNode.left) || helper(current.next, treeNode.right);
        } else {
            return false;
        }
    }
}
