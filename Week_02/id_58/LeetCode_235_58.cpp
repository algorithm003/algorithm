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
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
		/**************method1*********************/
        while (true){
            if (root->val > max(p->val, q->val))
                root = root->left;
            else if (root->val < min(p->val, q->val))
                root = root->right;
            else
                break;
        }
        
        return root;
    }


        /**************method2*********************/
         if(!root)
             return NULL;
         if(root->val > max(p->val, q->val))
             return lowestCommonAncestor(root->left, p, q);
         else if(root->val < min(p->val, q->val))
             return lowestCommonAncestor(root->right, p, q);
         else
             return root;
     }
};