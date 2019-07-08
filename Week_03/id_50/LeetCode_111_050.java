package algorithm.Week_03.id_50;

import algorithm.Week_01.id_50.TreeNode;

/**
 * Created by yu on 2019/7/7.
 * 二叉树的最小深度
 */
public class LeetCode_111_050 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return Math.min(left, right) == 0 ? Math.max(left, right) + 1 : Math.min(left, right) + 1;
    }
}
