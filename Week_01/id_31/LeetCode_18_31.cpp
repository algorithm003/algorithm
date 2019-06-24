#include <iostream>
#include <algorithm>

using namespace std;

/*
给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。

示例:

给定二叉树 [3,9,20,null,null,15,7],

	3
   / \
  9  20
	/  \
   15   7
返回它的最小深度  2.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

namespace vesion_1
{
	//16ms

	class Solution {
	public:
			int minDepth(TreeNode *root) {
			if (root == NULL) return 0;
			if (root->left == NULL) return minDepth(root->right) + 1;
			if (root->right == NULL) return minDepth(root->left) + 1;
			return min(minDepth(root->left), minDepth(root->right)) + 1;
		}
	};
}

using namespace vesion_1;

int main(int argc, char *argv[])
{
	Solution mytest;

	return 0;
}