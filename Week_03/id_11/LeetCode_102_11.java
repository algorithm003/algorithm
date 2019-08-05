import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层次遍历
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
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
                res.add(resTemp);
            }
        }
        return res;
    }
}
