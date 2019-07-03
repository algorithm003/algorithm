package com.panguang.cooltea.pglib;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 *  
 *   102. 二叉树的层次遍历
 * 
 *   给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 
 *   链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 
 *   学号：020
 * 
 * */


public class LeetCode_102_20 {

    List<List<Integer>> resultList = new ArrayList<>();

    //DFS 深度优先搜索，将子节点按照对应层级，分别添加保存在对应的层级的结果数组中
    //时间复杂度：O(n)
    //空间复杂度：O(n)
    public void dfs(TreeNode node, int level) {
        if (node == null) return;
        if (resultList.size() < level + 1){
            //如果当前节点层还没有保存结果的数组，创建一个用于保存结果的新数组
            resultList.add(new ArrayList<Integer>());
        }
        resultList.get(level).add(node.val);    //在对应层的数组保存节点结果
        dfs(node.left, level+1);
        dfs(node.right, level+1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return resultList;
        dfs(root, 0);
        return resultList;
    }



    //BFS 广度优先搜索，逐层从上往下遍历，并且当层的元素保存到当层数组
    //时间复杂度：O(n)
    //空间复杂度：O(n)
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) return resultList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> curentLevel = new ArrayList<>();  //创建一个用于保存结果的新数组
            for (int i = 0; i < levelSize; i++){
                TreeNode curNode = queue.poll();
                curentLevel.add(curNode.val);
                if (curNode.left != null){
                    queue.add(curNode.left);
                }
                if (curNode.right != null){
                    queue.add(curNode.right);
                }
            }
            resultList.add(curentLevel);
        }
        return resultList;
    }

}
