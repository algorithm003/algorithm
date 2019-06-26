/**
 * @author: wck
 * @date: 2019/6/21 17:05
 * @description: 101.对称二叉树
 */
public class LeetCode_101_36 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isDuiCheng(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;//层数要相同，必须都有值
        //递归对比，左对右，右对左
        return (t1.val == t2.val)
                && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }

}

// 注意代码格式！