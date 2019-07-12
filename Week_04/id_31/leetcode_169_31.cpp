#include <iostream>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

/*
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在众数。

示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/majority-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
namespace version_1{
    struct cmp{
        //降值排序。按值排序。
        bool operator()(const pair<int,int> &k1,const pair<int,int> &k2){
            return k1.second>k2.second;
        }
    };

    class Solution {
    public:
        int majorityElement(vector<int>& nums) {
            map<int,int> count;

            for(int i : nums) {
                //对数字进行统计
                if (count.find(i) == count.end()) {
                    //第一次出现该数。
                    count.insert(make_pair(i, 1));
                } else {
                    //非第一次出现该数，直接++;
                    count[i]++;
                }
            }
            vector<pair<int,int>>result(count.begin(),count.end());
            //对统计的数字进行按值排序，降值排序。
            sort(result.begin(),result.end(),cmp());
            //由于众数，必然是统计出来最多次数的。
            return result[0].first;
        }
    };
}

namespace version_2{
    class Solution {
    public:
        int majorityElement(vector<int>& nums) {
            map<int,int> count;

            for(int i : nums){
                //对数字进行统计
                if (count.find(i)==count.end()){
                    //第一次出现该数。
                    count.insert(make_pair(i,1));
                } else{
                    //非第一次出现该数，直接++;
                    count[i]++;
                }

                //出现众数，则返回
                if (count[i]>nums.size()/2){
                    return i;
                }
            }
            //多余语句，只是为了兼容编译器
            return 0;
        }
    };
}

using namespace version_2;

int main() {
    Solution mytest;
    vector<int>test1{3,2,3};
    cout<<mytest.majorityElement(test1)<<endl;

    vector<int>test2{2,2,1,1,1,2,2};
    cout<<mytest.majorityElement(test2)<<endl;

    return 0;
}