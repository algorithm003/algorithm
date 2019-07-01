/**
 * @author jinjw
 * @date 2019/6/30
 * @description 给定一个二叉树，检查它是否是镜像对称的。例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 */
public class LeetCode_101_34 {
    public boolean isSymmetric(TreeNode root) {
        return ismirror(root, root);
    }

    public boolean ismirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val
                && ismirror(t1.left, t2.right)
                && ismirror(t1.right, t2.left));
    }
}
