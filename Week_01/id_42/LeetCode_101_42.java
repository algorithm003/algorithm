//给定一个二叉树，检查它是否是镜像对称的。 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 说明: 
//
// 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。 
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
class Solution101 {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            else {
                return isSymmetric(root.left, root.right);
            }
        }
        private boolean isSymmetric(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            else if (left == null || right == null) {
                return false;
            }
            return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }

    public static void main(String[] args) {
        Solution101 solution101 = new Solution101();
        String str = "[3,9,20,null,null,15,7]";
        TreeNode root = TreeNode.mkTree(str);
        solution101.isSymmetric(root);
    }
}