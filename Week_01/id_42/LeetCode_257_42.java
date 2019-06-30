//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
//

import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<String>();
        helper(root, list, new String());
        return list;
    }

    public void helper(TreeNode root, List<String> list, String s) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            list.add(s + root.val);
            return;
        }
        if (root.left != null)
            helper(root.left, list, s + root.val + "->");
        if (root.right != null)
            helper(root.right, list, s + root.val + "->");
    }
}