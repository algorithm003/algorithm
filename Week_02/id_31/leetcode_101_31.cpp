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
	class Solution {
	public:
		bool Symmetric(TreeNode* left, TreeNode* right)
		{
			//没有左右，则代表是叶子结点，则为真
			if ((!left) && (!right))
				return true;

			//存在左右，并且，左右的值，是一样的。则还需继续递归
			if ((left&&right) && ((left->val) == (right->val)))
			{
				//左的左和右的右，是一对，
				//左的右和右的左，是一对。
				return (Symmetric(left->left, right->right)) && (Symmetric(left->right, right->left));
			}
			else
			{
				//判断失败，直接证明不是镜像。
				return false;
			}

			//此句，纯属多余，只是为了兼容某些编译器。
			return false;
		}

		bool isSymmetric(TreeNode* root) {
			return Symmetric(root, root);
		}
	};
}
