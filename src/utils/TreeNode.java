package utils;

public class TreeNode {

        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }

        /**
         * 创建测试数据
         *
         * @param data [XX,XX,null,xx]
         * @return {@link TreeNode}
         */
        public static TreeNode createTestData(String data) {
                //如果是[]  返回null  给定的字符串中没有元素
                if (data.equals("[]")) return null;
                //取出子字符串， startindex = 1  endindex = data.length() - 1  即去掉中括号
                data = data.substring(1, data.length() - 1);
                //将子字符串 由 "," 分割为若干个字符串，得到元素的字符串数组
                String[] split = data.split(",");
                //得到字符串的长度 len
                int len = len = split.length;
                //声明一个长度为len的树节点的数组
                TreeNode[] treeNodes = new TreeNode[len];
               // data = data.substring(1, data.length() - 1);
                //将字符串数组中的值赋值给树节点
                for (int i = 0; i < len; i++) {
                        if (!split[i].equals("null")) {
                                treeNodes[i] = new TreeNode(Integer.valueOf(split[i]));
                        }
                }

                //前序建树
                for (int i = 0; i < len; i++) {
                        if (treeNodes[i] != null) {
                                int leftIndex = i * 2 + 1;
                                if (leftIndex < len) {
                                        treeNodes[i].left = treeNodes[leftIndex];
                                }
                                int rightIndex = leftIndex + 1;
                                if (rightIndex < len) {
                                        treeNodes[i].right = treeNodes[rightIndex];
                                }
                        }
                }
                //返回树的根节点
                return treeNodes[0];
        }

        private static final String space = "      ";

        /**
         * 竖向打印二叉树
         *
         * @param root 二叉树根节点
         */
        public static void print(TreeNode root) {
                print(root, 0);
        }

        private static void print(TreeNode node, int deep) {
                if (node == null) {
                        printSpace(deep);
                        System.out.println("#");
                        return;
                }
                print(node.right, deep + 1);
                printSpace(deep);
                printNode(node.val);
                print(node.left, deep + 1);
        }

        private static void printSpace(int count) {
                for (int i = 0; i < count; i++) {
                        System.out.printf(space);
                }
        }

        private static void printNode(int val) {
                StringBuilder res = new StringBuilder(val + "<");
                int spaceNum = space.length() - res.length();
                for (int i = 0; i < spaceNum; i++) {
                        res.append(" ");
                }
                System.out.println(res);
        }
}
