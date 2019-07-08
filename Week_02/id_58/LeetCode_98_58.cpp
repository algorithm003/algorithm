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
    /******************method1********************/
         return isValidBST(root, LONG_MIN, LONG_MAX);
     }
    
     bool isValidBST(TreeNode* root, long small, long big){
         if (!root)
             return true;
        
         if (root -> val <= small || root -> val >= big)
             return false;
        
         return isValidBST(root -> left, small, root -> val) &&
             isValidBST(root -> right, root -> val, big);
     }
        

	/******************method2********************/
         TreeNode* pre = NULL;
         return solve(root, pre);
     }
        
         bool solve(TreeNode* node, TreeNode*& pre){
             if(!node)
                 return true;
            
             bool left = solve(node->left, pre);
             if (!left)
                 return false;
             if (pre){
                 if (node->val < pre->val)
                     return false;
             }
            
             pre = node;
             return solve(node->right, pre);   
         }


		 /******************method31********************/
         TreeNode* pre = NULL;
         TreeNode* p = root;
         stack<TreeNode*> st;
         while (p || !st.empty()){
             if (p){
                 st.push(p);
                 p = p->left;
             } else {
                 TreeNode* tmp = st.top();
                 st.pop();
                
                 if (pre){
                     if (pre->val >= tmp->val)
                         return false;
                 }
            
                 pre = tmp;
                 p = tmp->right; 
             }
         }
          return true;
     }


	     /******************method32********************/
         TreeNode* pre = NULL;
         TreeNode* p = root;
         stack<TreeNode*> st;
         while (p || !st.empty()){
             while (p){
                 st.push(p);
                 p = p->left;
             }
                 TreeNode* tmp = st.top();
                 st.pop();
                
                 if (pre){
                     if (pre->val >= tmp->val)
                         return false;
                 }
            
                 pre = tmp;
                 p = tmp->right; 
         }
          return true;
     }
        

		/******************method4********************/
        if (!root)
            return true;
        
        vector<int> v;
        inOrder(root, v);
        
        int n = v.size();
        for (int i = 0; i < n - 1; i++){
            if(v[i] >= v[i + 1])
                return false;
        }
        
        return true;
    }
    
    void inOrder(TreeNode* node, vector<int>& v){
        if(!node)
            return;
        inOrder(node->left, v);
        v.push_back(node->val);
        inOrder(node->right, v);
    }   
};