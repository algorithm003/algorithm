package Week_02.id_37;

/**
 * 类描述：111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * 创建人： Sun YongMeng
 * 创建时间：2019/6/25 22:30
 * 修改人：  Sun YongMeng
 * 修改时间：2019/6/25 22:30
 * 修改备注：
 */
public class LeetCode_111_37 {
    /**
     * 使用递归遍历节点深度.对比左右节点最小深度并返回
     * 时间复杂度O(n)
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null){return 0;}
        if (root.left == null && root.right == null){return 1;}
        int minNum = Integer.MAX_VALUE;
        if (root.left != null){minNum = Math.min(minDepth(root.left),minNum);}
        if (root.right != null) {minNum = Math.min(minDepth(root.right),minNum);}
        return ++ minNum;
    }

    class TreeNode{
        int val;TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
