/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        if (!root)
            return {};
        
        vector<vector<int>> res;
        queue<Node*> q{{root}};
        while (!q.empty()) {
            vector<int> cur;
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node* t = q.front();
                q.pop();
                cur.push_back(t->val);
                
                if (!t->children.empty()) {
                    for (Node* c : t->children)
                        q.push(c);
                }
            }
            
            res.push_back(cur);
        }
        return res;
    }
};