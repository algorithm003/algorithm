#include <iostream>
#include <vector>

using namespace std;

/*
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]

                  3
             /       \
            5          1
           / \         / \
         6   2        0   8
             / \
            7  4

示例 1:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
示例 2:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出: 5
解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 

说明:

所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉树中。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

//
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if ( (root==NULL) || (root==p) || (root==q) )
            return root;

        //后序遍历。来解决这个问题。
        //因为，后序遍历，根在最后面。

        TreeNode * left = lowestCommonAncestor(root->left,p,q);
        TreeNode * right = lowestCommonAncestor(root->right,p,q);

        if (left==NULL)
        {
            //左空，则返回右子树。
            return right;
        }
        else if (right==NULL)
        {
            //左不空，右空，则返左子树
            return left;
        } else{
            //左右不空，则返回当前根结点。
            return root;
        }
    }
};


int main() {

    Solution mytest;
    TreeNode tsst1_root (3);
    TreeNode tsst1_level1_left (5);
    TreeNode tsst1_level1_right (1);
    TreeNode tsst1_level1_left_level2_left (6);
    TreeNode tsst1_level1_left_level2_right (2);
    TreeNode tsst1_level1_right_level2_left (0);
    TreeNode tsst1_level1_right_level2_right (8);
    TreeNode tsst1_level3_left (7);
    TreeNode tsst1_level3_right (4);

    tsst1_root.left = &tsst1_level1_left;
    tsst1_root.right = &tsst1_level1_right;
    tsst1_level1_left.left = &tsst1_level1_left_level2_left;
    tsst1_level1_left.right = &tsst1_level1_left_level2_right;
    tsst1_level1_right.left = &tsst1_level1_right_level2_left;
    tsst1_level1_right.right = &tsst1_level1_right_level2_right;
    tsst1_level1_left_level2_right.left = &tsst1_level3_left;
    tsst1_level1_left_level2_right.right = &tsst1_level3_right;


    TreeNode * result1 = mytest.lowestCommonAncestor(&tsst1_root,&tsst1_level1_left,&tsst1_level1_right);
    cout << result1->val <<endl;

    TreeNode * result2 = mytest.lowestCommonAncestor(&tsst1_root,&tsst1_level1_left,&tsst1_level3_right);
    cout << result2->val <<endl;

    return 0;
}