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
        vector<vector<int>> ans;
        if (root == nullptr) {
            return ans;
        }
        fillLevelOrder(root, ans, 0);
        return ans;
    }
    
    void fillLevelOrder(TreeNode* root, vector<vector<int>> &ans, int level) {
        if (root == nullptr) {
            return;
        } 
        if (ans.size() <= level) {
            ans.push_back(vector<int>{});
        }
        ans[level].push_back(root->val);
        fillLevelOrder(root->left, ans, level+1);
        fillLevelOrder(root->right, ans, level+1);
    }
    
};