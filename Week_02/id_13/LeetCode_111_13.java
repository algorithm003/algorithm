import javafx.util.Pair;

import java.util.*;

/**
 给定一个二叉树，找出其最小深度。

 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

 说明: 叶子节点是指没有子节点的节点。
 *
 * Created by hantao on 2019/6/29.
 */
public class LeetCode_111_13 {

    // 深度优先搜索  递归写法
    public static int minDepth_dfs(TreeNode root) {
        if(root == null) return 0;

        if((root.left == null) && (root.right == null)) return 1;

        int min_Depth = Integer.MAX_VALUE;

        if(root.right !=null){
            min_Depth = Math.min(minDepth_dfs(root.right),min_Depth);
        }

        if(root.left !=null){
            min_Depth = Math.min(minDepth_dfs(root.left),min_Depth);
        }

        return min_Depth+1;

    }


    // 广度优先搜索 使用栈 非递归写法
    public static int minDepth_dfs2(TreeNode root) {

        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        // Pair<TreeNode,Integer> 存放每个节点对应的深度
        Stack<Pair<TreeNode,Integer>> stack = new Stack<Pair<TreeNode,Integer>>();
        stack.add(new Pair<TreeNode,Integer>(root,1));

        int minDepth = Integer.MAX_VALUE;

        while (!stack.isEmpty()){
            Pair<TreeNode,Integer> pair = stack.pop();
            TreeNode childNode = pair.getKey();
            Integer level =  pair.getValue();

            if (childNode.left == null && childNode.right == null){
                minDepth = Math.min(minDepth,level);
            }
            if (childNode.left != null){
                stack.add(new Pair<TreeNode, Integer>(childNode.left,level+1));
            }
            if (childNode.right != null){
                stack.add(new Pair<TreeNode, Integer>(childNode.right,level+1));
            }

        }
        return minDepth;
    }

    // 广度优先搜索 使用队列
    public static int minDepth_bfs(TreeNode root) {

        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        // Pair<TreeNode,Integer> 存放每个节点对应的深度
        LinkedList<Pair<TreeNode,Integer>> queue = new LinkedList<Pair<TreeNode,Integer>>();
        queue.add(new Pair<TreeNode,Integer>(root,1));

        int minDepth = Integer.MAX_VALUE;

        while (!queue.isEmpty()){
            Pair<TreeNode,Integer> pair = queue.poll();
            TreeNode childNode = pair.getKey();
            Integer level =  pair.getValue();

            if (childNode.left == null && childNode.right == null){
                minDepth = Math.min(minDepth,level);
                break; // 广度优先搜索为横向搜索，当找到一个叶子节点则退出

            }
            if (childNode.left != null){
                queue.add(new Pair<TreeNode, Integer>(childNode.left,level+1));
            }
            if (childNode.right != null){
                queue.add(new Pair<TreeNode, Integer>(childNode.right,level+1));
            }

        }
        return minDepth;
    }


    public static void main(String[] args) throws InterruptedException {
        // 数组初始化为二叉树 [3,9,20,11,null,15,7,15,null,null,null,null,null,null]
        TreeNode rightLeaf = new TreeNode(20,new TreeNode(15,null,null),new TreeNode(7,null,null));
        TreeNode rightLeaf3 = new TreeNode(15,null,null);
        TreeNode leftLeaf2 = new TreeNode(11,rightLeaf3,null);
        TreeNode leftLeaf = new TreeNode(9,leftLeaf2,null);
        TreeNode root = new TreeNode(3,rightLeaf,leftLeaf);

        System.out.println(minDepth_bfs(root));

    }


}



