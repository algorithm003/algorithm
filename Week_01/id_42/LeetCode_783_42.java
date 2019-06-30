//给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。 
//
// 示例： 
//
// 
//输入: root = [4,2,6,1,3,null,null]
//输出: 1
//解释:
//注意，root是树结点对象(TreeNode object)，而不是数组。
//
//给定的树 [4,2,6,1,3,null,null] 可表示为下图:
//
//          4
//        /   \
//      2      6
//     / \    
//    1   3  
//
//最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。 
//
// 注意： 
//
// 
// 二叉树的大小范围在 2 到 100。 
// 二叉树总是有效的，每个节点的值都是整数，且不重复。 
// 
//

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution783 {
    public int minDiffInBST(TreeNode root) {
        if (root == null)
            return 0;
        list = new ArrayList<Integer>();
        dfs(root);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            min = Math.min(min, list.get(i + 1) - list.get(i));
        }
        return min;
    }

    List<Integer> list;

    public void dfs(TreeNode root) {
        if (root == null)
            return;
        else {
            dfs(root.left);
            list.add(root.val);
            dfs(root.right);
        }
    }
}