class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
         if (matrix.empty() || matrix[0].empty()) 
             return false;
        
        if (target < matrix[0][0] || target > matrix.back().back())
            return false;
        
        int m = matrix.size(), n = matrix[0].size();
        int x = m - 1, y = 0;
        while (true) {
            if (matrix[x][y] > target)
                x--;
            else if (matrix[x][y] < target)
                y++;
            else
                return true;
            
            if (x < 0 || y >= n) 
                break;
        }
        return false;
    }
};