class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        if (!grid.size()) return 0;
        stack<pair<int, int>> st;
        int nums = 0;
        int m = grid.size();
        int n = grid[0].size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') continue;
                st.push(pair<int, int> (i, j));
                _dfs(st, grid);
                nums++;
            }
        }
        return nums;
    }

    void _dfs(stack<pair<int, int>>& st, vector<vector<char>>& grid) {
        if (st.empty()) return;
        pair<int, int> p = st.top();
        st.pop();
        grid[p.first][p.second] = '0';
        pair<int, int> up = pair<int, int> (p.first - 1, p.second);
        pair<int, int> down = pair<int, int> (p.first + 1, p.second);
        pair<int, int> left = pair<int, int> (p.first, p.second - 1);
        pair<int, int> right = pair<int, int> (p.first, p.second + 1);
        if (_isValid(grid, up) && grid[up.first][up.second] == '1') st.push(up);
        if (_isValid(grid, down) && grid[down.first][down.second] == '1') st.push(down);
        if (_isValid(grid, left) && grid[left.first][left.second] == '1') st.push(left);
        if (_isValid(grid, right) && grid[right.first][right.second] == '1') st.push(right);
        _dfs(st, grid);
    }

    bool _isValid(vector<vector<char>>& grid, pair<int, int>& pos) {
        return (pos.first >= 0 && pos.first < grid.size() && pos.second >= 0 && pos.second < grid[0].size());
    }
};