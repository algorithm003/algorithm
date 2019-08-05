class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> res;
        vector<int> cur;
        solve(n, k, 1, cur, res);
        
        return res;
    }
        
        void solve(int n, int k, int num, vector<int> cur, vector<vector<int>> &res){
            if (cur.size() == k) {
                res.push_back(cur);
                return;
            }
            for (int i = num; i <= n; i++) {
                cur.push_back(i);
                solve(n, k, i + 1, cur, res);
                cur.pop_back();
            }
        }
};