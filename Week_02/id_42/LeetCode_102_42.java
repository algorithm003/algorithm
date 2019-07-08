//给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
//
// 例如:
//给定二叉树: [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层次遍历结果：
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
//
//

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution42 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList();
        if (root == null) return ret;

        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while (!q.isEmpty()) {
            int levelCount = q.size();
            List<Integer> list = new ArrayList();
            while (levelCount > 0) {
                TreeNode temp = q.peek();
                list.add(temp.val);
                q.poll();
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
                levelCount--;
            }
            ret.add(list);
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution42 solution = new Solution42();
        String str = "[3,9,20,null,null,15,7]";
        TreeNode root = TreeNode.mkTree(str);

        solution.levelOrder(root);
    }
}