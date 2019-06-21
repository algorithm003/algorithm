import java.util.IllegalFormatCodePointException;

/**
 * @author: wck
 * @date: 2019/6/21 16:05
 * @description: 111.二叉树最小深度
 */

public class LeetCode_111_36 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Method {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;//为空则一个数字都没有，节点数为0
            }

            if ((root.left == null) && (root.right == null)) {
                return 1;//下一层子节点全为空的时候，到此为止，就不继续寻找下一层
            }

            int min_depth = Integer.MAX_VALUE;
            if (root.left != null) {
                min_depth = Math.min(minDepth(root.left), min_depth);
            }

            if (root.right != null) {
                min_depth = Math.min(minDepth(root.right), min_depth);
            }
            return min_depth + 1;
        }
    }

}


