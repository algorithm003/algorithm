class Solution {
public:
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        if (matrix.empty() || matrix[0].empty())
            return 0;
        
        int max = 0;
        vector<vector<int>> res(matrix.size(), vector<int>(matrix[0].size(), -1));
        for (int i = 0; i < matrix.size(); ++i) {
            for (int j = 0; j < matrix[0].size(); ++j) {
                max = std::max(max, longestIncreasingPath(matrix, res, i, j));
            }
        }
        
        return max;
    }
    
    int longestIncreasingPath(const vector<vector<int>> &matrix, vector<vector<int>> &res, int i, int j) {        
        if (res[i][j] != -1) {
            return res[i][j];
        }
        
        int max = 1;
        for (auto &dir : dirs) {
            int ii = i + dir[0]; int jj = j + dir[1];
            if (ii >= 0 && ii < matrix.size() && jj >= 0 && jj < matrix[0].size() && matrix[i][j] < matrix[ii][jj]) {
                max = std::max(max, 1+longestIncreasingPath(matrix, res, ii, jj));
            }
        }
        return (res[i][j] = max);
    }
    
    vector<vector<int>> dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
};
