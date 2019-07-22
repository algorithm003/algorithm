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
        if(!root)
            return {};
        
        vector<vector<int>> res;
        
        queue<TreeNode*> q{{root}};
        while(!q.empty()){
            vector<int> cur;
            
            int n = q.size();
            for(int i = 0; i < n; i++){
                TreeNode* t = q.front();
                q.pop();
                cur.push_back(t->val);
                
                if(t->left)
                    q.push(t->left);
                if(t->right)
                    q.push(t->right);   
            }
            
            res.push_back(cur);
        }
        return res;
    }
        
//         vector<vector<int>> res;
//         solve(root, 0, res);
//         return res;
//     }
    
//     void solve(TreeNode* node, int level, vector<vector<int>>& res){
//         if (!node)
//             return;
        
//         if (res.size() == level)
//             res.push_back({});
        
//         res[level].push_back(node->val);
        
//         solve(node->left, level + 1, res);
//         solve(node->right, level + 1, res);  
//     }
};