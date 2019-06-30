class Solution {
public:
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> res;
        if (root == NULL)
            return res;
        
        _dfs(res, root, to_string(root->val));
        return res;
    }
    
    void _dfs(vector<string> &res, TreeNode *root, string path) {
        if (root->left == NULL && root->right == NULL) {
            res.push_back(path);
            return;
        }
        
        if (root->left != NULL)
            _dfs(res, root->left, path + "->" + to_string(root->left->val));
        if (root->right != NULL)
            _dfs(res, root->right, path + "->" + to_string(root->right->val));
    }
};
