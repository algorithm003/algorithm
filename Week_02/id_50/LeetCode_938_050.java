package algorithm.Week_02.id_50;

import algorithm.Week_01.id_50.TreeNode;

import java.util.Stack;

/**
 * Created by yu on 2019/6/29.
 * .938 Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive)
 */
public class LeetCode_938_050 {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        }
        if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        }
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }
}
