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
        vector<vector<int>> res;
        if (!root)
            return res;
        
        int level = 0;
        
        queue<TreeNode*> q;
        q.push(root);
        while (!q.empty()){
            level++;
            vector<int> now;
            
            int n = q.size();
            for (int i = 0; i < n; i++){
                TreeNode* cur = q.front();
                q.pop();
                
                now.push_back(cur->val);
                
                if (cur->left)
                    q.push(cur->left);
                if (cur->right)
                    q.push(cur->right);
            }
            if(level % 2 == 0)
                reverse(now.begin(), now.end());
            
            res.push_back(now);
        }
        
        return res;
    }
};