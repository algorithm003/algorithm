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
    int minDiffInBST(TreeNode* root) {
//         int res = INT_MAX;
        
//         vector<int> v;
//         solve(root, v);
        
//         for (int i = 1; i < v.size(); ++i) {
//             res = min(res, v[i] - v[i - 1]);
//         }
//         return res;
//     }
    
//     void solve(TreeNode* node, vector<int>& v) {
//         if (!node) return;
//         solve (node->left, v);
//         v.push_back(node->val);
//         solve (node->right, v);
//     }
        
        int res = INT_MAX;
        solve(root, INT_MIN, INT_MAX, res);
        return res;
    }
    void solve(TreeNode* node, int low, int high, int& res) {
        if (!node)
            return;
        
        if (low != INT_MIN) 
            res = min(res, node->val - low);
        if (high != INT_MAX)
            res = min(res, high - node->val);
        
        solve(node->left, low, node->val, res);
        solve(node->right, node->val, high, res);
    }
};