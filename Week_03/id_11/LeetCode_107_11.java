import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层次遍历 II
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null)
            return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            ArrayList<Integer> resTemp = new ArrayList<Integer>();
            while (count-- > 0) {
                TreeNode node = queue.poll();
                if (node != null) {
                    resTemp.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (resTemp.size()>0) {
                res.addFirst(resTemp);
    
            }
        }
        return res;
    }
}

