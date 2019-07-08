class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        if (numCourses <= 1 || prerequisites.empty()) {
            vector<int> res(numCourses);
            iota(res.begin(), res.end(), 0);
            return res;
        }
        vector<int> degree(numCourses, 0);
        vector<vector<int>> graph(numCourses);
        for_each(prerequisites.begin(), prerequisites.end(), [&](auto&val){
            degree[val[0]]++;
            graph[val[1]].push_back(val[0]);
        });
        
        vector<int> res;
        while (res.size() != numCourses) {
            vector<int> temp;
            for (int i = 0; i < numCourses; ++i) {
                if (degree[i] == 0) {
                    temp.push_back(i);
                    for_each(graph[i].begin(), graph[i].end(), [&](auto&val){
                        --degree[val];
                    });
                    degree[i] = -1;
                }
            }
            if (temp.empty())
                return {};
            res.insert(res.end(), temp.begin(), temp.end());
        }
        return res;
    }
};
