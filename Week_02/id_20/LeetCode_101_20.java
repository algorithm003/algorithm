/*
 *
 *   101. 对称二叉树
 *
 *   给定一个二叉树，检查它是否是镜像对称的。
 *
 *   链接：https://leetcode-cn.com/problems/symmetric-tree/
 *
 *   学号：020
 *
 * */


public class LeetCode_101_20 {

    //递归遍历比较同一根节点下的左右子树是否镜像对称。
    //时间复杂度：O(n)
    public boolean isSymmetric(TreeNode root){
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }

}
