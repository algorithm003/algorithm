/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/solution/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian--2/
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 把if里面的多次需要比较的值提前赋值好，效率提高极大
        int pVal = p.val;
        int qVal = q.val;
        int rootVal = root.val;


        // QC: 三目表达式
        if (p == root || q == root)
            return root;
        if (pVal < rootVal && qVal > rootVal)
            return root;
        if (pVal < rootVal && qVal < rootVal)
            // 有返回值的递归每次调用记得赋值或者返回
            return lowestCommonAncestor(root.left, p, q);
        if (pVal > rootVal && qVal > rootVal)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }

}
