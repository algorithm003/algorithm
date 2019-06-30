/**
 * @author: Suhb
 * @date: 2019/6/20 17:54
 * @description: 101. 对称二叉树
 */
public class LeetCode_101_035 {
        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }



    public boolean isSymmetric(TreeNode root) {
        return isSame(root, root);  // 判断当前两值是否一样
    }

    public boolean isSame(TreeNode leftNode, TreeNode rightNode) {
        if(leftNode == null && rightNode == null) { // 如果两值都为空，说明上一层都是一样的
            return true;
        } else if (leftNode == null || rightNode == null) { // 如果其中有一个为空，一个不为空，说明肯定就不是相对称的了
            return false;
        }
        // 条件1，两值必须是一致的、条件2：如果还有左右子树，判断是否左右对称，即：左边的左子树是否等于右边的右子树，同时左边的右子树是否等于右边的左子树
        return (leftNode.val == rightNode.val) && isSame(leftNode.left, rightNode.right) && isSame(leftNode.right, rightNode.left);
    }
}
