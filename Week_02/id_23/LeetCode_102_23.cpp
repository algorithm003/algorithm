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
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> res;
        tranverse(root, res, 0);
        return res;
    }
    
    void tranverse(TreeNode *root, vector<vector<int>> &res, int level) {
        if (!root)
            return;
        while (res.size() < level+1)
            res.push_back(vector<int>());
        res[level].push_back(root->val);
        tranverse(root->left, res, level+1);
        tranverse(root->right, res, level+1);
    }
};
