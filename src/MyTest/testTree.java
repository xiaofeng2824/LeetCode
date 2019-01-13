package MyTest;

import MyTree.Tree_01;
import MyTree.Tree_02;
import org.junit.Test;
import utils.TreeNode;

public class testTree {

    // 01 求树的深度
    @Test
    public void treeDepth()
    {
        //先建树  [3,9,20,null,null,15,7]
        String tree = "[3,9,20,null,null,15,7]";

        // 建树
        TreeNode root = TreeNode.createTestData(tree);

        //打印树
        TreeNode.print(root);

        int i = Tree_01.maxDepth(root);
        System.out.println("树的深度是："+i);
    }

    //02 求是否是二叉搜索树
    @Test
    public void isvalidBST()
    {
        String tree = "[2,1,3]";
        TreeNode root = TreeNode.createTestData(tree);
        TreeNode.print(root);

        boolean validBST = Tree_02.isValidBST(root);
        System.out.println("是否是二叉搜索树:"+validBST);
    }
}
