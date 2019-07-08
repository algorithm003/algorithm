class Solution {
public:
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        vector<vector<int>> res;
        dfs(root, res, 0);
        reverse(res.begin(), res.end());
        return res;
    }
    
    void dfs(TreeNode *root, vector<vector<int>> &res, int level) {
        if (!root)
            return;
        if (res.size() < level+1) {
            res.push_back(vector<int>());
        }
        res[level].push_back(root->val);
        dfs(root->left, res, level+1);
        dfs(root->right, res, level+1);
    }
};
