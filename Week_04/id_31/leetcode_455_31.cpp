#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

/*
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。

注意：

你可以假设胃口值为正。
一个小朋友最多只能拥有一块饼干。

示例 1:

输入: [1,2,3], [1,1]

输出: 1

解释:
你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
所以你应该输出1。
示例 2:

输入: [1,2], [1,2,3]

输出: 2

解释:
你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
你拥有的饼干数量和尺寸都足以让所有孩子满足。
所以你应该输出2.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/assign-cookies
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */

class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {

        //满足多少个小朋友
        int cnt = 0;
        //饼干的下标
        int si=0;
        //胃口的下标
        int gi=0;

        //对胃口排序
        sort(g.begin(),g.end());
        //对饼干排序
        sort(s.begin(),s.end());

        //不超过饼干数和胃口数
        while ((si<s.size())&&(gi<g.size())){
            //当饼干满足胃口？？
            if (s[si]>=g[gi]){
                //下一个饼干
                si++;
                //下一个胃口
                gi++;
                //满足小朋友数加一
                cnt++;
            } else{
                //下一个饼干
                si++;
            }
        }
        //返回满足小朋友数
        return cnt;
    }
};

int main() {
    Solution mytest;
    vector<int>test1_g{1,2};
    vector<int>test1_s{1,2,3};
    cout<<mytest.findContentChildren(test1_g,test1_s)<<endl;

    vector<int>test2_g{1,2,3};
    vector<int>test2_s{1,1};

    cout<<mytest.findContentChildren(test2_g,test2_s)<<endl;
    return 0;
}