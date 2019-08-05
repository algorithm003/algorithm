import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N叉树的层序遍历
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    // 该题目没有交代清除是整个一层在一个list，还是一个node下放到一个list
    public List<List<Integer>> levelOrder(Node root) {
        ArrayList<List<Integer>> arrayList = new ArrayList<>();
        if (root == null)
            return arrayList;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            ArrayList<Integer> rr = new ArrayList<Integer>();
            while (count-- > 0) {
                Node n = queue.poll();
                rr.add(n.val);
                for (Node c : n.children) {
                    if (c != null) {
                        queue.add(c);
                    }
                }
            }
            arrayList.add(rr);
        }
        return arrayList;
    }
}

