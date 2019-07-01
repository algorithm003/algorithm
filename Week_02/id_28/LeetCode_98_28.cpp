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
    bool isValidBST(TreeNode* root) {
        vector<int> v;
        _inorder(root, v);
        if (v.size() <= 1) return true;
        for (int i = 1; i < v.size(); i++) {
            if (v[i] <= v[i - 1]) return false;
        }
        return true;
    }
private:
    void _inorder(TreeNode* r, vector<int>& v) {
        if (!r) return;
        _inorder(r->left, v);
        v.push_back(r->val);
        _inorder(r->right, v);
    }
};
