

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
		
		//保存前一个结点
		TreeNode* prev = NULL;
		//初始化，最小距离为最大值
		int min_diff = INT_MAX;

		int minDiffInBST(TreeNode* root) {
			
			//已经为空树，直接返回，最小距离结果。
			if (root == NULL)
			{
				return min_diff;
			}

			//使用中序优先

			minDiffInBST(root->left);

			if (prev)
			{
				//计算，当前结点与前一个结点的的差值，再判断是否为最小值。更新最小值。
				min_diff = min(root->val - prev->val, min_diff);
			}
			
			//更新前一个结点
			prev = root;

			minDiffInBST(root->right);

			//完成所有子树的搜索，直接返回最小值
			return min_diff;
		}
	};
}