class Solution {
public:
    int minDepth(TreeNode* root) {
		/*************method1****************/
        if (!root)
            return 0;
        return solve(root);
    }
    
    int solve(TreeNode* root){
        if (!root)
            return INT_MAX;
        
        if (!root->left && !root->right)
            return 1;
        
        return min(solve(root->left), solve(root->right)) + 1;
    }
        

	/*************method2****************/
         if (!root) return 0;
         int res = 0;
         queue<TreeNode*> q{{root}};
         while (!q.empty()) {
             ++res;
             for (int i = q.size(); i > 0; --i) {
                 auto t = q.front();
                 q.pop();
                
                 if (!t->left && !t->right)
                     return res;
                
                 if (t->left) 
                     q.push(t->left);
                 if (t->right) 
                     q.push(t->right);
             }
         }
         return -1;
     }
};