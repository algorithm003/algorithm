class Solution {
public:
    int findCircleNum(vector<vector<int>>& M) {
		/*********************method1********************************/
        int n = M.size(), res = 0;
        vector<bool> visited(n, false);
        for (int i = 0; i < n; ++i) {
            if (visited[i]) 
                continue;
            helper(M, i, visited);
            ++res;
        }
        return res;
    }
    void helper(vector<vector<int>>& M, int k, vector<bool>& visited) {
        visited[k] = true;
        for (int i = 0; i < M.size(); ++i) {
            if (!M[k][i] || visited[i]) 
                continue;
            helper(M, i, visited);
        }
    }
     
	/*********************method2********************************/
         int n = M.size(), res = 0;
         vector<bool> visited(n, false);
         queue<int> q;
         for (int i = 0; i < n; ++i) {
             if (visited[i]) continue;
             q.push(i);
             while (!q.empty()) {
                 int t = q.front(); q.pop();
                 visited[t] = true;
                 for (int j = 0; j < n; ++j) {
                     if (!M[t][j] || visited[j]) continue;
                     q.push(j);
                 }
             }
             ++res;
         }
         return res;
     }      
};