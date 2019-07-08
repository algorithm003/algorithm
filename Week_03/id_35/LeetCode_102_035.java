package week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ author: Suhb
 * @ date: 2019/7/4 16:11
 * @ description: 102. 二叉树的层次遍历
 */
public class LeetCode_102_035 {
    /*给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
    例如:
    给定二叉树: [3,9,20,null,null,15,7],
            3
           / \
          9  20
            /  \
           15   7
    返回其层次遍历结果：
            [
            [3],
            [9,20],
            [15,7]
            ]*/
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        List<List<Integer>> rootResult = new ArrayList<>();
        bfs(rootResult, list);
        return rootResult;
    }

    private void bfs(List<List<Integer>> rootResult, List<TreeNode> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        List<Integer> newList = new ArrayList<>();
        List<TreeNode> nodeList = new ArrayList<>();
        for (TreeNode node : list) {
            newList.add(node.val);
            if (node.left != null) {
                nodeList.add(node.left);
            }
            if (node.right != null) {
                nodeList.add(node.right);
            }
        }
        rootResult.add(newList);
        bfs(rootResult, nodeList);
    }

    public static void main(String[] args) {
        LeetCode_102_035 leetCode_102_035 = new LeetCode_102_035();
        LeetCode_102_035.TreeNode root = leetCode_102_035.new TreeNode(3);
        LeetCode_102_035.TreeNode root1_1 = leetCode_102_035.new TreeNode(9);
        LeetCode_102_035.TreeNode root1_2 = leetCode_102_035.new TreeNode(20);
        root.left = root1_1;
        root.right = root1_2;
        //
        LeetCode_102_035.TreeNode root3_1 = leetCode_102_035.new TreeNode(15);
        LeetCode_102_035.TreeNode root3_2 = leetCode_102_035.new TreeNode(7);
        root1_2.left = root3_1;
        root1_2.right = root3_2;
        List<List<Integer>> list = leetCode_102_035.levelOrder(root);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
