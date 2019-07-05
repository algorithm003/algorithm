package Week_03.id_37;

/**
 * 类描述：
 * 创建人： Sun YongMeng
 * 创建时间：2019/7/5 16:10
 * 修改人：  Sun YongMeng
 * 修改时间：2019/7/5 16:10
 * 修改备注：
 */
public class LeetCode_111_37 {
    /**
     * 给定一个二叉树，找出其最小深度。
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * 说明: 叶子节点是指没有子节点的节点。
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null){ return 0; }
        if (root.left == null && root.right == null){return 1; }
        int min = Integer.MAX_VALUE;
        if (root.left != null){ min = Math.min(minDepth(root.left),min); }
        if (root.right != null){ min = Math.min(minDepth(root.right),min); }
        return min+1;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
