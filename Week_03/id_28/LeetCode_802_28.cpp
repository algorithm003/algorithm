class Solution {
public:
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        int n = graph.size();
        vector<int> res, visited(n, 0);
        for (int i = 0; i < n; i++)
            if (_dfs(graph, visited, i)) res.push_back(i); 
        return res;
    }
    
    bool _dfs(vector<vector<int>>& graph, vector<int>& visited, int idx) {
        if (visited[idx]) return 1 == visited[idx];
        visited[idx] = -1;
        for (auto node : graph[idx])
            if (!_dfs(graph, visited, node)) return false;
        return visited[idx] = 1;
    }
};
