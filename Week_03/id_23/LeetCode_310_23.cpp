class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
        if (n <= 2) {
            vector<int> res(n);
            iota(res.begin(), res.end(), 0);
            return res;
        }
        vector<unordered_set<int>> graph(n);
        for (auto &edge : edges) {
            graph[edge[0]].insert(edge[1]);
            graph[edge[1]].insert(edge[0]);
        }
        vector<int> res;
        for (int i = 0; i < n; ++i) {
            if (graph[i].size() == 1) {
                res.push_back(i);
            }
        }
        while (true) {
            vector<int> temp;
            for (auto &i : res) {
                for (auto &ne : graph[i]) {
                    graph[ne].erase(i);
                    if (graph[ne].size() == 1)
                        temp.push_back(ne);
                }
            }
            if (temp.empty())
                return res;
            res.swap(temp);
        }
        return res;
    }
};
