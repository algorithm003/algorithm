class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>> vv(numCourses);
        for (int i = 0; i < vv.size(); i++) vv[i].push_back(i);
        for (auto v : prerequisites) vv[v[0]].push_back(v[1]);
        vector<int> res;
        map<int, int> visited;
        for (int i = 0; i < numCourses; i++) {
            if (rescur(i, vv, res, visited)) return {};
        }
        return res;
    }

    bool rescur(int line, vector<vector<int>>& vv, vector<int>& res, map<int, int>& visited) {
        if (1 == visited[vv[line][0]]) return true;
        if (2 == visited[vv[line][0]]) return false;
        visited[vv[line][0]] = 1;
        for (int i = 1; i < vv[line].size(); i++) {
            if (rescur(vv[line][i], vv, res, visited)) return true;
        }
        res.push_back(vv[line][0]);
        visited[vv[line][0]] = 2;
        return false;
    }
};