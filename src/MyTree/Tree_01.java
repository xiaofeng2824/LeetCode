package MyTree;

import utils.TreeNode;

/*
* 给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3
* */
public class Tree_01 {



    //求树的深度
    public static  int maxDepth(TreeNode root) {

        //递归遍历树，求树的深度

        if(root == null)
            return 0;
        else
        {
            //int leftdepth  = 1 + maxDepth(root.left);
            //int rightdepth = 1 + maxDepth(root.right);
            return  maxDepth(root.left) > maxDepth(root.right)?
                    maxDepth(root.left) + 1 :maxDepth(root.right) + 1;
        }

        /*
        * if (root == null) return 0;
          return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        * */


    }
}
