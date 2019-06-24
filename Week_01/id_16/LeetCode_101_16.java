public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return symmetricHelper(root.left, root.right);
    }

    private boolean symmetricHelper(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }

        if (leftNode != null && rightNode != null) {
            return (leftNode.val == rightNode.val)
                    && symmetricHelper(leftNode.left, rightNode.right)
                    && symmetricHelper(leftNode.right, rightNode.left);
        }
        else {
            return false;
        }
    }
}
