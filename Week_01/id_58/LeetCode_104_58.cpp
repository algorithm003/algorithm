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
    int maxDepth(TreeNode* root) {
        if (!root)
            return NULL;
        int left = maxDepth(root->left);
        int right = maxDepth(root->right);
        return max(left, right) + 1;
    }

	/*    if(!root)
			return NULL;
        
        int res = 0;
        queue<TreeNode*> q{{root}};
        while (!q.empty()){
            res++;
            
            int n = q.size();
            for (int i = 0; i < n; i++){
                TreeNode *t = q.front();
                q.pop();
                
                if (t->left)
                    q.push(t->left);
                if (t->right)
                    q.push(t->right);
            }
        }
        
        return res;
    }*/
};