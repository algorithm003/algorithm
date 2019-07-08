package com.panguang.cooltea.pglib;

import java.util.LinkedList;
import java.util.Queue;

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

public class LeetCode_111_20 {

    //方法一：递归遍历找出下一节点的最小深度。
    //时间复杂度： O(n)
    //空间复杂度： O(logN)
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
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


    //方法二：BFS
    //时间复杂度：O(n)
    //空间复杂度：O(n)
    public int minDepth1(TreeNode root) {
        if (root == null) return 0;
        int level = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode curNode = queue.poll();
                if (curNode.left == null && curNode.right == null) return level;
                if (curNode.left != null){
                    queue.offer(curNode.left);
                }
                if (curNode.right != null){
                    queue.offer(curNode.right);
                }
            }
            level++;
        }
        return level;
    }


    //方法三：DFS
    //时间复杂度：O(n)
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth2(root.left);
        int right = minDepth2(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }

}
