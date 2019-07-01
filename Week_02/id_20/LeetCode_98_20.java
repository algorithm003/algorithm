
/*
 *
 *   98. 验证二叉搜索树
 *
 *   给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *   假设一个二叉搜索树具有如下特征：
 *   节点的左子树只包含小于当前节点的数。
 *   节点的右子树只包含大于当前节点的数。
 *   所有左子树和右子树自身必须也是二叉搜索树。
 *
 *   链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 *
 *   学号：020
 *
 * */

public class LeetCode_98_20 {

    TreeNode pre;

    /*
     *   中序遍历二叉树，发现不符合条件的子树就不是有效的二叉搜索树
     *   时间复杂度：O(n)
     *
     * */
    public boolean isValidBST(TreeNode root){
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (pre != null && pre.val >= root.val) return false;
        pre = root;
        if (!isValidBST(root.right)) return false;
        return true;
    }

}
