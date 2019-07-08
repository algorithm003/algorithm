class Solution {
public:
    int findCircleNum(vector<vector<int>>& M) {
        if (M.empty())
            return 0;
        int circleNum = 0;
        vector<bool> visited(M.size(), false);
        for (int i = 0; i < visited.size(); ++i) {
            if (!visited[i]) {
                ++ circleNum;
                dfs(M, visited, i);
            }
        }
        return circleNum;
    }
    
    void dfs(const vector<vector<int>> &M, vector<bool> &visited, int i) {
        visited[i] = true;
        for (int j = 0; j < visited.size(); ++j) {
            if (!visited[j] && M[i][j]) {
                dfs(M, visited, j);
            }
        }
    }
};
