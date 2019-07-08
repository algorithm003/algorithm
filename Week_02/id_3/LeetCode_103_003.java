package com.zzm;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/

    给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）
   例如：
   给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

   返回锯齿形层次遍历如下：

[
  [3],
  [20,9],
  [15,7]
]

 */
public class LeetCode_103_003 {


    public static  List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        helper(res,root,0);

        return res;
    }

    public static void helper(List<List<Integer>> res, TreeNode root, int depth) {

        if (null == root){
            return;
        }

        if (depth == res.size()){
            res.add(new ArrayList());
        }
        if (depth % 2 == 0) {
            res.get(depth).add(root.val);
        }else {
            res.get(depth).add(0,root.val);
        }

        helper(res,root.left,depth++);
        helper(res,root.right,depth++);
    }

}
