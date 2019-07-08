import java.util.*;

/**
 * @Auther hantao on 2019/7/7.
 * @Date 2019/7/7 16:29
 * @Description
 */
public class leetCode_429_13 {


    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        if (root == null) return ret;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()){
            List<Integer> curLevel = new ArrayList<Integer>();
            int len = queue.size();
            for(int i=0;i < len;i++){
                TreeNode node =  queue.poll();
                curLevel.add(node.val);
                for (TreeNode childrenNode:node.children){
                    queue.add(childrenNode);
                }
            }
            ret.add(curLevel);
        }

        return ret;
    }

    public static void main(String[] args){

    }

}
