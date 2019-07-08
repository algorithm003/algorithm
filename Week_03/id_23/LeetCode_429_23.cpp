class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> res;
        dfs(root, res, 0);
        return res;
    }
    
    void dfs(Node *root, vector<vector<int>> &res, int level) {
        if (root == NULL) {
            return;
        }
        
        if (res.size() < level+1) {
            res.push_back(vector<int>());
        }
        res[level].push_back(root->val);
        
        for_each(root->children.begin(), root->children.end(), [&](Node*n){dfs(n,res,level+1);});
    }
};
