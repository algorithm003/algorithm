/**
 * 111. 二叉树的最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
class Solution {
    public int minDepth(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root == null) {
            return 0;
        } else {
            stack.add(new Pair(root,1));
        }

        Integer current_depth=0;
        // 循环第一种终止条件
        while(!stack.isEmpty()){
            Pair<TreeNode,Integer> current= stack.poll();
            root=current.getKey();
            current_depth= current.getValue();
            if(root.left==null&&root.right==null){
                // 循环第二终止条件，通过bfs最先找到叶子节点即可终止循环
                break;
            }
            if(root.left!=null){
                stack.add(new Pair(root.left,current_depth+1));
            }
            if(root.right!=null){
                stack.add(new Pair(root.right,current_depth+1));
            }
        }      

        return current_depth;
    }
    /**
     * 深度优先就是从list end获取节点，广度就是从head获取节点
     */
}
 