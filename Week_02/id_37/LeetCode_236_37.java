package Week_02.id_37;

/**
 * 类描述：
 * 创建人： Sun YongMeng
 * 创建时间：2019/6/27 14:42
 * 修改人：  Sun YongMeng
 * 修改时间：2019/6/27 14:42
 * 修改备注：
 */
public class LeetCode_236_37 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private TreeNode result;

    /**
     * 236. 二叉树的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        queryResult(root,p,q);
        return result;
    }
    private boolean queryResult(TreeNode node, TreeNode p, TreeNode q){
        if (node == null){return false;}
        int sum = (queryResult(node.left,p,q) ? 1 : 0) + (queryResult(node.right,p,q) ? 1 : 0) + (node == p || node == q ? 1 : 0);
        if (sum >= 2) { result = node; }
        return sum > 0;
    }
}
