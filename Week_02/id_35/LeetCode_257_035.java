package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ author: Suhb
 * @ date: 2019/6/25 16:32
 * @ description: 递归：257. 二叉树的所有路径
 */
public class LeetCode_257_035 {
    /*给定一个二叉树，返回所有从根节点到叶子节点的路径。
    说明: 叶子节点是指没有子节点的节点。
    示例:
    输入:

            1
          /   \
         2     3
          \
           5
    输出: ["1->2->5", "1->3"]
    解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3*/
    private List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        return getPaths(root, String.valueOf(root.val), new ArrayList<String>());
    }

    private List<String> getPaths(TreeNode root, String s, List<String> list) {
        if (root == null || (root.left == null && root.right == null)) {    // 如果左右子树为空，即叶子节点，则返回路径
            list.add(s);
            return list;
        }
        if (root.left != null) {    // 如果左子树不为空，继续下钻
            getPaths(root.left, s + "->" + root.left.val, list);
        }
        if (root.right != null) {   // 如果右子树不为空，继续下钻
            getPaths(root.right, s + "->" + root.right.val, list);
        }
        return list;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        LeetCode_257_035 leetCode_257_035 = new LeetCode_257_035();
        LeetCode_257_035.TreeNode root = leetCode_257_035.new TreeNode(1);
        LeetCode_257_035.TreeNode rootLeft = leetCode_257_035.new TreeNode(2);
        root.left = rootLeft;
        LeetCode_257_035.TreeNode rootRight = leetCode_257_035.new TreeNode(3);
        root.right = rootRight;
        LeetCode_257_035.TreeNode root2Right = leetCode_257_035.new TreeNode(5);
        rootLeft.right = root2Right;
        System.out.println(leetCode_257_035.binaryTreePaths(root));
    }
}
