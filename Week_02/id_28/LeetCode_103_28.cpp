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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        deque<TreeNode*> dq;
        vector<vector<int>> vv;
        if (!root) return vv;
        dq.push_back(root);
        _bfs(true, dq, vv);
        return vv;
    }
private:
    void _bfs(bool l2r, deque<TreeNode*>& dq, vector<vector<int>>& vv) {
        if (dq.empty()) return;
        vector<int> v;
        int size = dq.size();
        if (l2r) {
            for (int i = 0; i < size; i++) {
                TreeNode *n = dq.front();
                dq.pop_front();
                v.push_back(n->val);
                if (n->left) dq.push_back(n->left);
                if (n->right) dq.push_back(n->right);
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                TreeNode *n = dq.back();
                dq.pop_back();
                v.push_back(n->val);
                if (n->right) dq.push_front(n->right);
                if (n->left) dq.push_front(n->left);
            }
        }
        vv.push_back(v);
        _bfs(!l2r, dq, vv);
    }
};
