#include <iostream>
#include <vector>
#include <iterator>
#include <algorithm>

using namespace std;

/*
给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */

class Solution {
public:
    void help(vector<int> nums,vector<vector<int>>& ans,vector<int> tmp,int pos){

        //如果是一个排列，则保存起来。
        if (pos==nums.size()){
            ans.push_back(nums);
        }

        for(int i = pos;i<nums.size();i++){
            //交换，新成一个新的排列顺序。
            swap(nums[pos],nums[i]);
            help(nums,ans,tmp,pos+1);
            //还原，排列顺序。
            swap(nums[pos],nums[i]);
        }
    }

    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int> tmp;
        help(nums,ans,tmp,0);
        return ans;
    }
};

int main() {
    Solution mytest;
    vector<int> test1{1,2,3};
    vector<vector<int>> result1 = mytest.permute(test1);

    for (auto start= result1.begin();start!=result1.end();start++){
        copy((*start).begin(),(*start).end(),ostream_iterator<int>(cout,","));
        cout<<endl;
    }

    return 0;
}