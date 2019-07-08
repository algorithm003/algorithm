package com.architect.leetcode._0235;

import com.architect.leetcode.TreeNode;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * LCA 问题, 这里利用二分搜索树的性质,左子树的值是大于右子树的值,其实就是找到分割点.这里迭代法
 * 方法一: 迭代实现
 *    时间复杂度: O(lgn)   相当于二分查找
 *    空间复杂度: O(1) 只用循环,没有用到额外空间
 * @author pizhihui
 * @date 2019-06-30
 */
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (p.val < cur.val && q.val < cur.val) {
                cur = cur.left;
            } else if (p.val > cur.val && q.val > cur.val) {
                cur = cur.right;
            } else {
                return cur;
            }
        }

        return null;
    }

}

/**
 * 方法二: 递归实现
 *   时间复杂度: O(lgn)   相当于二分查找
 *   空间复杂度: O(h) 递归需要用到栈, 最坏情况入栈到叶子节点, 故应该是树的高度.
 *
 */
class Solution2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }

    }

}
