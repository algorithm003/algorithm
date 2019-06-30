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
    int minDiffInBST(TreeNode* root) {
		/********************method4****************************/
         int res = INT_MAX, pre = -1;
         solve(root, res, pre);
         return res;
     }
    
     void solve(TreeNode* node, int& res, int& pre) {
         if (!node)
             return;

         solve(node->left, res, pre);

         if (pre != -1)
             res = min(res, node->val - pre);
         pre = node->val;

         solve(node->right, res, pre);
     }

        /********************method2****************************/
        int res = INT_MAX, pre = -1;

        stack<TreeNode*> st;
        TreeNode* p = root;

        while (!st.empty() || p){
            if (p){
                st.push(p);
                p = p->left;
            } else {
                TreeNode* tmp = st.top();
                st.pop();

                if (pre != -1)
                    res = min(res, tmp->val - pre);
                pre = tmp->val;

                p = tmp->right;
            }
        }
        return res;
    }
        

     /********************method3****************************/       
         int res = INT_MAX;
         vector<int> v;
         solve(root, v);
        
         for (int i = 1; i < v.size(); ++i) {
             res = min(res, v[i] - v[i - 1]);
         }
         return res;
     }
    
     void solve(TreeNode* node, vector<int>& v) {
         if (!node) return;
         solve (node->left, v);
         v.push_back(node->val);
         solve (node->right, v);
     }
        

     /********************method4****************************/
         int res = INT_MAX;
         solve(root, INT_MIN, INT_MAX, res);
         return res;
     }
     void solve(TreeNode* node, int low, int high, int& res) {
         if (!node)
             return;
        
         if (low != INT_MIN) 
             res = min(res, node->val - low);
         if (high != INT_MAX)
             res = min(res, high - node->val);
        
         solve(node->left, low, node->val, res);
         solve(node->right, node->val, high, res);
     }
};