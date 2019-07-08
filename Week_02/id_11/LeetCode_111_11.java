/**
 * 111. 二叉树的最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/solution/er-cha-shu-de-zui-xiao-shen-du-by-leetcode/
 */
class Solution{
    // 本次用的是深度优先
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        int curDeepth =1;
        stack.add(new Pair(root, curDeepth));
        int min = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pop = stack.pollLast();
            curDeepth = pop.getValue();
            root = pop.getKey();
            if (root.left == null && root.right == null)
                min = Math.min(curDeepth, min);
            if (root.left != null)
                stack.add(new Pair(root.left, curDeepth + 1));
            if (root.right != null)
                stack.add(new Pair(root.right, curDeepth + 1));

        }
        return min;
    }

    /**
     * 深度优先就是从list end获取节点，广度就是从head获取节点
     */
}