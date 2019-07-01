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
    // 空间复杂度是O(n), 时间复杂度是O(n)
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> ans;
        if (root) {
            vector<TreeNode*> children;
            children.push_back(root);
            levelOrder(ans, children, 1);
        }
        return ans;
    }
    
    void levelOrder(vector<vector<int>> & ans, vector<TreeNode *> & nodes, int level) {
        if (nodes.empty()) {
            return;
        }
        vector<int> vals;
        vector<TreeNode *> children;        
        for(int i = nodes.size()-1; i >=0 ; --i) {
            vals.push_back(nodes[i]->val);
            if (level & 1) {
                if (nodes[i]->left) children.push_back(nodes[i]->left);
                if (nodes[i]->right) children.push_back(nodes[i]->right);    
            }
            else {
                if (nodes[i]->right) children.push_back(nodes[i]->right);
                if (nodes[i]->left) children.push_back(nodes[i]->left);
            }
        }
        ans.push_back(vals);
        levelOrder(ans, children, ++level);
    }
};
