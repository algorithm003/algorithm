/*
 *
 *   783. 二叉搜索树结点最小距离
 *
 *   给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
 *
 *   链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 *
 *   学号：020
 *
 * */

public class LeetCode_783_20 {

    /*
    *   中序遍历二叉树，用变量保存每当前节点与前一节点的最小差值。
    *   时间复杂度：O(n)
    *   空间复杂度：O(1)
    *
    * */

    TreeNode pre;
    int min = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root){
        dfs(root);
        return min;
    }

    public void dfs(TreeNode root){
        if (root == null) return;
        minDiffInBST(root.left);
        if (pre != null){
            int temp = Math.abs(root.val - pre.val);
            min = temp < min ? temp : min;
        }
        pre = root;
        minDiffInBST(root.right);
    }
}
