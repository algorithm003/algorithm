package Week_02.id_37;

/**
 * 类描述：
 * 创建人： Sun YongMeng
 * 创建时间：2019/6/27 15:20
 * 修改人：  Sun YongMeng
 * 修改时间：2019/6/27 15:20
 * 修改备注：
 */
public class LeetCode_101_37 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 101. 对称二叉树
     * 判断是否是对称二叉树
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return result(root,root);
    }

    private boolean result(TreeNode left,TreeNode right){
        return  left == null && right == null ? true : left == null || right == null ? false : left.val == right.val ? result(left.left,right.right) && result(left.right,right.left) : false;
    }
}
