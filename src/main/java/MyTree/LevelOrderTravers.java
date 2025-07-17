package MyTree;

import utils.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 题意是从下往上按层遍历二叉树，每一层是从左到右，按层遍历，很明显，
 * 宽搜第一时间符合，因为是从下往上，所以插入的时候每次插到链表头即可
 * <p>
 * 例子：
 * [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class LevelOrderTravers {

    /**
     * 宽度搜索 层次遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> list = new LinkedList<>();
        //保存每一个节点的值
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);


        while (!q.isEmpty()) {
            int size = q.size();
            //节点的值
            List<Integer> sub = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                sub.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            list.add(0, sub);
        }
        return list;
    }

    /**
     * 深度搜索
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        helper(list, root, 0);
        return list;
    }

    private void helper(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null) return;
        if (level >= list.size()) {
            list.add(0, new LinkedList<>());
        }

        helper(list, root.left, level + 1);
        helper(list, root.right, level + 1);
        list.get(list.size() - level - 1).add(root.val);
    }

    public static void main(String[] args) {
        LevelOrderTravers orderTravers = new LevelOrderTravers();

        System.out.println(orderTravers.levelOrderBottom(TreeNode.createTestData("[]")));
        System.out.println(orderTravers.levelOrderBottom(TreeNode.createTestData("[1,2,2,3,4,4,3]")));
        System.out.println(orderTravers.levelOrderBottom(TreeNode.createTestData("[9,-42,-42,null,76,76,null,null,13,null,13]")));

        System.out.println(orderTravers.levelOrderBottom1(TreeNode.createTestData("[]")));
        System.out.println(orderTravers.levelOrderBottom1(TreeNode.createTestData("[1,2,2,3,4,4,3]")));
        System.out.println(orderTravers.levelOrderBottom1(TreeNode.createTestData("[9,-42,-42,null,76,76,null,null,13,null,13]")));


    }

}
