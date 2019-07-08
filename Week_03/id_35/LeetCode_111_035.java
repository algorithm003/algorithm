package week3;

/**
 * @ author: Suhb
 * @ date: 2019/7/4 15:31
 * @ description: 111. 二叉树的最小深度
 */
public class LeetCode_111_035 {
    /*给定一个二叉树，找出其最小深度。
    最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
    说明: 叶子节点是指没有子节点的节点。
    示例:
        给定二叉树 [3,9,20,null,null,15,7],
                3
               / \
              9  20
                /  \
               15   7
        返回它的最小深度  2.*/
    private int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        }
        return root.left == null ? minDepth(root.right) + 1 :
                root.right == null ? minDepth(root.left) + 1 : Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
