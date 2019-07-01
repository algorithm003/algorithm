package com.architect.leetcode._0236;

import com.architect.leetcode.TreeNode;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @author pizhihui
 * @date 2019-06-30
 */

/**
 * 其实祖先的问题,就是区分左右子树,如果是分开的,就是 root,否则就在一边的树上去找, 找到就返回
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(h)
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else {
            return left != null ? left : right;
        }

    }
}

