#include <iostream>
#include <vector>

using namespace std;

/**
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。

给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。

示例 1:

输入:
[[1,1,0],
 [1,1,0],
 [0,0,1]]
输出: 2
说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
第2个学生自己在一个朋友圈。所以返回2。
示例 2:

输入:
[[1,1,0],
 [1,1,1],
 [0,1,1]]
输出: 1
说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
注意：

N 在[1,200]的范围内。
对于所有学生，有M[i][i] = 1。
如果有M[i][j] = 1，则有M[j][i] = 1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/friend-circles
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */


class Solution {
public:

    void dfs(vector<vector<int>>& M,vector<int>& visit,int m){
        visit[m] = 1;

        for (int i = 0; i < M[m].size(); ++i) {
            if ( (visit[i]==0) && (M[m][i]==1) ){
                dfs(M,visit,i);
            }
        }
    }

    int findCircleNum(vector<vector<int>>& M) {


        int n = M.size();

        //visit已经访问过的结点初始化。
        vector<int> visit;
        visit.resize(n,0);

        int cnt = 0;

        for (int i = 0; i< n; ++i) {
            if (visit[i]==0){
                dfs(M,visit,i);
                cnt++;
            }
        }

        return cnt;
    }
};

int main() {
    Solution mytest;

    vector<vector<int>> test1{{1,1,0},{1,1,0},{0,1,1}};

    int result1 = mytest.findCircleNum(test1);
    cout<<result1<<endl;

    vector<vector<int>> test2 {{1,1,0},{1,1,1},{0,1,1}};
    int result2 = mytest.findCircleNum(test2);
    cout<<result2<<endl;

    return 0;
}