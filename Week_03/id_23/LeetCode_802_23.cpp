class Solution {
public:
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        if (graph.empty())
            return vector<int>();
        
        vector<int> calRes(graph.size(), 0), res;
        for (int i = 0; i < graph.size(); ++i) {
            if (isSafeNode(graph, i, calRes)) {
                res.push_back(i);
            }
        }
        return res;
    }
    
    bool isSafeNode(vector<vector<int>> &graph, int i, vector<int> &calRes) {
        if (calRes[i])
            return (1 == calRes[i]);

        calRes[i] = 2;
        for (int j = 0; j < graph[i].size(); ++j) {
            if (!isSafeNode(graph, graph[i][j], calRes)) {
                return false;
            }
        }
        calRes[i] = 1;
        return true;
    }
};
