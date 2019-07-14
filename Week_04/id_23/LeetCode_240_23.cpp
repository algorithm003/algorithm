class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if (matrix.empty())
            return false;
        int m = matrix.size();
        int n = matrix[0].size();
        int i = 0, j = n-1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target)
                return true;
            matrix[i][j] > target ? --j : ++i;
        }
        return false;
    }
};
