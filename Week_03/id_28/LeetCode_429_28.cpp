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
    void bfs(Node* root, vector<vector<int>>& result, int level){
        if(!root)   return;
        if(result.size() == level)  result.push_back({});
        result[level].push_back(root->val);
        auto children = root->children;
        for(int i = 0; i < (root->children).size(); i++){
            bfs((root->children)[i], result, level + 1);
        }
    }
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> result;
        bfs(root, result, 0);
        return result;
    }
};
