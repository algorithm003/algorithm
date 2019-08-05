#include <iostream>
#include <vector>
#include <iterator>
#include <algorithm>

using namespace std;

/*
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combinations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */

class Solution {
public:
    void help(int n,int k,vector<vector<int>>& ans,vector<int> tmp,int pos){

        //如果是一个排列，则保存起来。
        if (tmp.size()==k){
            ans.push_back(tmp);
        }

        for(int i = pos;i<n+1;i++){
            tmp.push_back(i);
            help(n,k,ans,tmp,i+1);
            //此句非常重要，回溯法精通。
            tmp.pop_back();
        }
    }

    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> ans;
        vector<int> tmp;
        help(n,k,ans,tmp,1);
        return ans;
    }
};

int main() {
    Solution mytest;
    vector<vector<int>> result1 = mytest.combine(4,2);

    for (auto start= result1.begin();start!=result1.end();start++){
        copy((*start).begin(),(*start).end(),ostream_iterator<int>(cout,","));
        cout<<endl;
    }

    return 0;
}