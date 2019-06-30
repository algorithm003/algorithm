/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> res;
        if (root)
            solve(root, "", res);
        return res;
    }
    
    void solve(TreeNode* node, string tmp, vector<string>& res){
        if (!node->left && !node->right)
            res.push_back(tmp + to_string(node->val));
        
        if (node->left)
            solve(node->left, tmp + to_string(node->val) + "->", res);
        if (node->right)
            solve(node->right, tmp + to_string(node->val) + "->", res);
    }
};