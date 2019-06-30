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
    bool isSymmetric(TreeNode* root) {
		/*******************method1***********************/
         if (!root)
             return true;
         return solve(root->left, root->right);
     }
    
     bool solve(TreeNode *left, TreeNode *right){
         if (!left && !right)
             return true;
        
         if (left && !right || !left && right || left->val != right->val)
             return false;
        
         return solve(left->left, right->right) && solve(left->right, right->left);
     }
        

	    /*******************method2***********************/
        if (!root)
            return true;
        
        queue<TreeNode*> p, q;
        p.push(root->left);
        q.push(root->right);
        
        while (!p.empty() && !q.empty()){
            TreeNode* t1 = p.front();
            p.pop();
            TreeNode* t2 = q.front();
            q.pop();
            
            if (!t1 && !t2)
                continue;
            if ((!t1 && t2) || (t1 && !t2))
                return false;
            if (t1->val != t2->val)
                return false;
            
            p.push(t1->left);
            p.push(t1->right);
            q.push(t2->right);
            q.push(t2->left);  
        }
        return true;
    }
};