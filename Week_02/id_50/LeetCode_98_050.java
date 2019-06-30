package algorithm.Week_02.id_50;

import algorithm.Week_01.id_50.TreeNode;

import java.util.*;

/**
 * Created by yu on 2019/6/29.
 * .98. 验证二叉搜索树
 */
public class LeetCode_98_050 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && pre.val >= root.val) {
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }
}
