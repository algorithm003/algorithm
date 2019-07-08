public class LeetCode_235_16 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root != null && p != null && q != null) {
            //在根两侧的情况
            if ((p.val <= root.val && q.val >= root.val)
                    || (p.val >= root.val && q.val <= root.val)) {
                return root;
            } else if (p.val < root.val && q.val < root.val) { //全在左侧的情况
                return lowestCommonAncestor(root.left, p, q);
            } else if (p.val > root.val && q.val > root.val) { //全在右侧的情况
                return lowestCommonAncestor(root.right, p, q);
            }
        }

        return root;
    }
}
