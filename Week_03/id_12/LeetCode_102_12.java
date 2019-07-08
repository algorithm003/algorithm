package com.architect.leetcode._102;

import com.architect.leetcode.TreeNode;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author pizhihui
 * @date 2019-07-07
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<TreeNode, Integer>(root, 0));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> front = queue.removeFirst();
            TreeNode node = front.getKey();
            Integer level = front.getValue();

            if (level == res.size()) {
                res.add(new ArrayList<Integer>());
            }

            res.get(level).add(node.val);
            if (node.left != null) {
                queue.addLast(new Pair<TreeNode, Integer>(node.left, level + 1));
            }

            if (node.right != null) {
                queue.addLast(new Pair<TreeNode, Integer>(node.right, level + 1));
            }

        }

        return res;

    }
}



