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
        vector<string> v;
        string s = "";
        _dfs(root, s, v);
        return v;
    }
private:
    void _dfs(TreeNode* root, string& str, vector<string>& vec) {
        if (!root) return;
        if (!str.empty()) str += "->";
        str += to_string(root->val);
        if (!root->left && !root->right) vec.push_back(str);
        string clone = str;
        _dfs(root->left, clone, vec);
        _dfs(root->right, str, vec);
    }
};
