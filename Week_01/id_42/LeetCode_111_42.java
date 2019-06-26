//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//
// 给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最小深度 2.
//

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left, right;

        left =  root.left != null ?  minDepth(root.left) : Integer.MAX_VALUE;
        right = root.right != null ? minDepth(root.right) : Integer.MAX_VALUE;

        return Math.min(left, right) + 1;
    }

    public static void main(String[] args) {
        Solution111 solution111 = new Solution111();
        TreeNode root = new TreeNode(1);
        solution111.minDepth(root);
    }
}

// 代码还是不够简洁！