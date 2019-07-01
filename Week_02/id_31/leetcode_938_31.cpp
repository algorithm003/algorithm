#include <iostream>

using namespace std;

struct TreeNode {
    int val;
	TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

namespace vesion_1
{
	//第一个版本，强搜，无优化
	class Solution {
	public:
		void sumBst(TreeNode* root, int L, int R, int &sum)
		{
			if (root == NULL)
			{
				return;
			}

			if ((root->val >= L) && (root->val <= R))
			{
				sum += root->val;
			}

			sumBst(root->left, L, R, sum);
			sumBst(root->right, L, R, sum);
		}

		int rangeSumBST(TreeNode* root, int L, int R) {
			int sum = 0;
			sumBst(root, L, R, sum);
			return sum;
		}
	};
}

namespace vesion_2
{
	class Solution {
	public:
		void sumBst(TreeNode* root, int L, int R, int &sum)
		{
			if (root == NULL)
			{
				return;
			}

			//在范围内，统计累计值，搜左右子树
			if ((root->val >= L) && (root->val <= R))
			{
				sum += root->val;
				sumBst(root->left, L, R,sum);
				sumBst(root->right, L, R,sum);
			}

			//利用二叉搜索树的性质。大于右值，搜左子树。
			if (root->val > R) 
			{
				sumBst(root->left, L, R, sum);
			}

			//利用二叉搜索树的性质。小于左值，搜右子树。
			if (root->val < L)
			{
				sumBst(root->right, L, R, sum);
			}
		}

		int rangeSumBST(TreeNode* root, int L, int R) {
			int sum = 0;
			sumBst(root, L, R, sum);
			return sum;
		}
	};
}