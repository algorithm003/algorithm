package week2;

/**
 * @ author: Suhb
 * @ date: 2019/6/25 9:34
 * @ description: 二叉树：111. 二叉树的最小深度
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
        if (root == null) { // 如果节点为空则返回0
            return 0;
        }
        if (root.left == null && root.right == null) {   // 左右子树都为空，说明已经是树子节点了，上一步到这一步即返回1
            return 1;
        }
        /*if (root.left == null) {    // 如果左子树为空，右子树不为空，那右子树继续下钻，并且深度再 + 1
            return minDepth(root.right) + 1;
        } else if (root.right == null) {    // 如果右子树为空，左子树不为空，那左子树继续下钻，并且深度再 + 1
            return minDepth(root.left) + 1;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1; // 如果左右子树都不为空，那左右子树都下钻，并且最他们的最小值再 + 1
        }*/
        return root.left == null ? (minDepth(root.right) + 1) :     // 如果左子树为空，右子树不为空，那右子树继续下钻，并且深度再 + 1
                root.right == null ? (minDepth(root.left) + 1) :    // 如果右子树为空，左子树不为空，那左子树继续下钻，并且深度再 + 1
                        Math.min(minDepth(root.left), minDepth(root.right)) + 1;    // 如果左右子树都不为空，那左右子树都下钻，并且最他们的最小值再 + 1

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
