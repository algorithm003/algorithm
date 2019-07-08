package com.architect.leetcode._0111;

import com.architect.leetcode.TreeNode;

/**
 * @author pizhihui
 * @date 2019-07-07
 */

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int ret = Integer.MAX_VALUE;

        if (root.left != null) {
            ret = Math.min(ret, 1 + minDepth(root.left));
        }
        if (root.right != null) {
            ret = Math.min(ret, 1 + minDepth(root.right));
        }
        return ret;
    }
}


