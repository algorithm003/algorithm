#include <iostream>
#include <vector>
#include <iterator>
#include <algorithm>

using namespace std;

/*
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。

在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]

给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。

可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。

示例 1:

输入: 2, [[1,0]]
输出: [0,1]
解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
示例 2:

输入: 4, [[1,0],[2,0],[3,1],[3,2]]
输出: [0,1,2,3] or [0,2,1,3]
解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
     因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
说明:

输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
你可以假定输入的先决条件中没有重复的边。
提示:

这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
拓扑排序也可以通过 BFS 完成。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/course-schedule-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */

class Solution {
private:

    bool dfs(int index,vector<int>& record,vector<vector<int>>& pre,vector<int>& ans){

        //跑进这个if，则代表先修课，已修。
        if(record[index] == 2)
            return true;

        //如果跑进这个if，则代表有环。
        if(record[index] == 1)
            return false;

        //正在访问
        record[index] = 1;

        //搜逆接表，看看先修是否都修完。
        for(auto i : pre[index]){
            //如果出现有环的情况，直接退出。
            if(!dfs(i,record,pre,ans)){
                return false;
            }
        }

        //代表先修课，都修完了。
        ans.push_back(index);
        //访问结束
        record[index] = 2;
        return true;
    }
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {

        vector<int> record;
        vector<vector<int>> pre;
        vector<int> ans;

        //记录访问状态。初始化是0
        record = vector<int>(numCourses, 0);
        //逆链接表。记录，1先修是什么。2的先修课是什么。3的先修课是什么。
        pre = vector<vector<int>>(numCourses);
        for(auto v : prerequisites)
            pre[v[0]].push_back(v[1]);

        for(int i = 0; i < numCourses; i++) {
            //dfs一下。
            if (record[i] == 0 && !dfs(i, record, pre, ans)) {
                //代表有环。则清除输出。
                ans.clear();
                break;
            }
        }
        return ans;
    }
};

int main() {
    Solution mytest;
    vector<vector<int>> test1{{1,0}};
    vector<int> result1 = mytest.findOrder(2,test1);
    copy(result1.begin(),result1.end(),ostream_iterator<int>(cout,","));
    cout<<endl;

    vector<vector<int>> test2{{1,0},{2,0},{3,1},{3,2}};
    vector<int> result2 = mytest.findOrder(4,test2);
    copy(result2.begin(),result2.end(),ostream_iterator<int>(cout,","));
    cout<<endl;

    return 0;
}