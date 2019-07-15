using System;

public class LeedCode_102_59
{
    /**
     * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * 
     */
    public List<List<int>> LevelOrder(TreeNode root)
    {
        List<List<int>> s = new List<List<int>>();
        OrderNum(root, 0, s);
        return s;
    }

    /// <summary>
    /// 覃老师，我这里编译其实没有通过在线的leedcode，但本地可以正常运行，求指教
    /// 说是IList无法隐式转换为List
    /// </summary>
    /// <param name="root"></param>
    /// <param name="depth"></param>
    /// <param name="collect"></param>
    public void OrderNum(TreeNode root, int depth, List<List<int>> collect)
    {
        if (null != root)
        {
            if (depth >= collect.ToArray().Length)
            {
                collect.Add(new List<int>());
            }
            collect[depth].Add(root.val);
            OrderNum(root.left, depth + 1, collect);
            OrderNum(root.right, depth + 1, collect);
        }

    }

}
