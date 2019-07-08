

namespace vesion_2
{
	struct TreeNode {
	     int val;
	     TreeNode *left;
	     TreeNode *right;
	     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
	 };
	 
	class Solution {
	public:
		TreeNode* prev = NULL;
		int min_diff = INT_MAX;
		int minDiffInBST(TreeNode* root) {
			if (root == NULL)
			{
				return min_diff;
			}

			minDiffInBST(root->left);

			if (prev)
			{
				min_diff = min(root->val - prev->val, min_diff);
			}
			
			prev = root;

			minDiffInBST(root->right);

			return min_diff;
		}
	};
}