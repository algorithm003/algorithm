package Week_03.id_37;

/**
 * 类描述：
 * 创建人： Sun YongMeng
 * 创建时间：2019/7/5 15:56
 * 修改人：  Sun YongMeng
 * 修改时间：2019/7/5 15:56
 * 修改备注：
 */
public class LeetCode_104_37 {
    /**
     * 给定一个二叉树，找出其最大深度。
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * 说明: 叶子节点是指没有子节点的节点
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null){return 0;}
        else{
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left,right);
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
