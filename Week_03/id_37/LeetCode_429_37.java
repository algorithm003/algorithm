package Week_03.id_37;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 类描述：
 * 创建人： Sun YongMeng
 * 创建时间：2019/7/5 16:20
 * 修改人：  Sun YongMeng
 * 修改时间：2019/7/5 16:20
 * 修改备注：
 */
public class LeetCode_429_37 {
    /**
     * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){ return res;}
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            Node curNode;
            List<Integer> t = new ArrayList<>();
            for(int i = 0; i < len; i++){
                curNode = queue.poll();
                t.add(curNode.val);
                if(curNode.children != null){
                    for(Node node : curNode.children){
                        queue.offer(node);
                    }
                }
            }
            res.add(t);
        }
        return res;
    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
