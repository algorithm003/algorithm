#include <iostream>
#include <vector>
#include <iterator>
#include <algorithm>
#include <functional>

using namespace std;

/*
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层次遍历如下：

[
  [3],
  [20,9],
  [15,7]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


struct TreeNode {
     int val;
     TreeNode *left;
     TreeNode *right;
TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:

    void LevelSearch (TreeNode* root, vector<vector<int > > &res, int n_level,bool neg)
    {
        //结束点
        if (root==NULL)
            return;

        //neg==false，正向插入。否则，反向插入。
        if (neg == false)
        {
            if (res.size() < n_level)
            {
                vector<int> tmp;
                tmp.push_back(root->val);
                res.push_back(tmp);
            } else{
                res[n_level-1].push_back(root->val);
            }
        } else{
            if (res.size() < n_level)
            {
                vector<int> tmp;
                tmp.insert(tmp.begin(),root->val);
                res.push_back(tmp);
            } else{
                res[n_level-1].insert(res[n_level-1].begin(),root->val);
            }
        }

        //取反、正反向插入的标志位
        neg = !neg;

        //继续搜索左右子树。
        LevelSearch(root->left,res,n_level+1,neg);
        LevelSearch(root->right,res,n_level+1,neg);
    }

    vector<vector<int> > zigzagLevelOrder(TreeNode* root) {
        vector<vector<int > > result;
        int level = 1;
        bool neg = false;
        LevelSearch(root,result,level,neg);
        return result;
    }
};


int main() {
    Solution mytest;
    TreeNode tsst1_root (3);
    TreeNode tsst1_level1_left (9);
    TreeNode tsst1_level1_right (20);
    TreeNode tsst1_level1_right_level2_left (15);
    TreeNode tsst1_level1_right_level2_right (7);

    tsst1_root.left = &tsst1_level1_left;
    tsst1_root.right = &tsst1_level1_right;
    tsst1_level1_right.left = &tsst1_level1_right_level2_left;
    tsst1_level1_right.right = &tsst1_level1_right_level2_right;


    vector<vector<int> > result1 = mytest.zigzagLevelOrder(&tsst1_root);

    vector<vector<int> >::iterator start_result = result1.begin();
    vector<vector<int> >::iterator end_result = result1.end();

    for (;start_result != end_result;start_result++)
    {
        cout<<"[";
        copy((*start_result).begin(),(*start_result).end(),ostream_iterator<int>(cout,","));
        cout<<"]"<<endl;
    }

    return 0;
}