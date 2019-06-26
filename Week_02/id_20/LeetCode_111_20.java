package com.panguang.cooltea.pglib;

/*
 *
 *   111. 二叉树的最小深度
 *
 *   给定一个二叉树，找出其最小深度。
 *   最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *   说明: 叶子节点是指没有子节点的节点。
 *
 *   链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 *
 *   学号：020
 *
 * */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class LeetCode_111_MinimumDepthOfBinaryTree {

    // DFS递归找出下一节点的最小深度。
    //时间复杂度： O(n), 只遍历了一遍节点
    //空间复杂度： O(logN)
    public int minDepth(TreeNode root) {

        if (root == null){
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int minLeftDepth = 0;
        if (root.left != null) {
            minLeftDepth = Math.min(minDepth(root.left), Integer.MAX_VALUE);
        }

        int minRightDepth = 0;
        if (root.right != null) {
            minRightDepth = Math.min(minDepth(root.right), Integer.MAX_VALUE);
        }

        return (minLeftDepth < minRightDepth ? minLeftDepth : minRightDepth) + 1;

    }

}
