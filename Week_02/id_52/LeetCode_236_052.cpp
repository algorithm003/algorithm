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
    //sol1: recursion
    
    bool contains(TreeNode* root,TreeNode* p){
        //dfs to search p in root tree
        if(root==NULL)
            return false;
        
        if( root->val == p->val )
            return true;
        
        return contains(root->left,p) || contains(root->right,p) ;
    } 
    
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root->val==p->val ||root->val==q->val)
            return root;
        //if p and q are not at the same substree
        if( (contains(root->left,p) && contains(root->right,q)) || 
            (contains(root->right,p) && contains(root->left,q))   )
            return root;
        
        if( (contains(root->left,p) && contains(root->left,q))  ) 
            return lowestCommonAncestor(root->left,p,q);
        
        if( (contains(root->right,p) && contains(root->right,q))  ) 
            return lowestCommonAncestor(root->right,p,q);
        
        return NULL;
    }
    
    //sol2
      
      //1. find the path from p to the root (same to q)    
      //2. *** compare the two path strings and find the common lowest parenet    <= easily got suck when comparing the two path which are string type,e.g. comparing "-1 -2 22 23" and "-1 2 3 4", and you have to return the pointer of the first different node
    
};