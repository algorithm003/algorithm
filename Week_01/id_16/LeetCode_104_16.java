
public class LeetCode104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return traverse(root, 1);
    }

    private int traverse(TreeNode node, int level) {
        if (node.left == null && node.right == null) {
            return level;
        }

        int leftDepth = 0;
        int rightDepth = 0;

        if (node.left != null) {
            leftDepth = traverse(node.left, level + 1);
        }

        if (node.right != null) {
            rightDepth = traverse(node.right, level + 1);
        }

        return Math.max(leftDepth, rightDepth);
    }
}
