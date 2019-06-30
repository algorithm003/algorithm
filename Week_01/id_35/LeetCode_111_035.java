/**
 * @author: Suhb
 * @date: 2019/6/21 9:24
 * @description: 111. 二叉树的最小深度
 */
public class LeetCode_111_035 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {  // 如果左右子树都没有值了，说明已经到了叶子节点了
            return 1;
        }
        if (root.left == null) {    // 左子树为空，右子树不为空，那就取右子树继续下沉的最小节点
            return minDepth(root.right) + 1;
        } else if(root.right == null) { // 右子树为空，左子树不为空，那就取左子树继续下觉的最小节点
            return minDepth(root.left) + 1;
        } else {    // 左右子树都不为空，则取左右子树继续下沉的最小节点
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}
