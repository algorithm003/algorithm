package week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ author: Suhb
 * @ date: 2019/7/4 15:44
 * @ description: 429. N叉树的层序遍历
 */
public class LeetCode_429_035 {
    /*给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
    例如，给定一个 3叉树 :
    返回其层序遍历:
            [
            [1],
            [3,2,4],
            [5,6]
            ]
    说明:
    树的深度不会超过 1000。
    树的节点总数不会超过 5000。*/
    private List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> rootList = new ArrayList<>();
        rootList.add(root.val);
        list.add(rootList);
        bfs(list, root.children);
        return list;
    }

    private void bfs(List<List<Integer>> list, List<Node> children) {
        if (children == null || children.size() == 0) {
            return;
        }
        List<Node> newChildren = new ArrayList<>();
        List<Integer> newList = new ArrayList<>();
        for (Node node : children) {
            newList.add(node.val);
            if (node.children != null && node.children.size() > 0) {
                for (Node child : node.children) {
                    newChildren.add(child);
                }
            }
        }
        list.add(newList);
        bfs(list, newChildren);
    }

    public static void main(String[] args) {
        LeetCode_429_035 leetCode_429_035 = new LeetCode_429_035();
        LeetCode_429_035.Node node = leetCode_429_035.new Node();
        node.val = 1;
        //
        LeetCode_429_035.Node node2_1 = leetCode_429_035.new Node();
        node2_1.val = 3;
        LeetCode_429_035.Node node3_1 = leetCode_429_035.new Node();
        node3_1.val = 5;
        LeetCode_429_035.Node node3_2 = leetCode_429_035.new Node();
        node3_2.val = 6;
        List<Node> children3 = new ArrayList<>();
        children3.add(node3_1);
        children3.add(node3_2);
        node2_1.children = children3;
        //
        LeetCode_429_035.Node node2_2 = leetCode_429_035.new Node();
        node2_2.val = 2;
        //
        LeetCode_429_035.Node node2_3 = leetCode_429_035.new Node();
        node2_3.val = 4;
        //
        List<Node> children2 = new ArrayList<>();
        children2.add(node2_1);
        children2.add(node2_2);
        children2.add(node2_3);
        node.children = children2;
        List<List<Integer>> list = leetCode_429_035.levelOrder(node);
        System.out.println(Arrays.toString(list.toArray()));
    }

    class Node {
        private int val;
        private List<Node> children;
        private Node() {}
        private Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
