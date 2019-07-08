/**
 * @author jinjw
 * @date 2019/6/30
 * @description 给定一个二叉树，找出其最小深度。最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 */
public class LeetCode_111_34 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int min_dep = Integer.MAX_VALUE;
        if (root.left != null) {
            min_dep = Math.min(minDepth(root.left), min_dep);
        }
        if (root.right != null) {
            min_dep = Math.min(minDepth(root.right), min_dep);
        }
        return min_dep + 1;
    }
}
