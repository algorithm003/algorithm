class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> res;
        vector<int> v;
        combine(v, 1, 0, n, k, res);
        return res;
    }
    
    void combine(vector<int> &v, int i, int num, int n, int k, vector<vector<int>> &res) {
        if (num == k) {
            res.push_back(v);
            return;
        }
        
        for (int j = i; j <= n; ++j) {
            v.push_back(j);
            combine(v, j+1, num+1, n, k, res);
            v.pop_back();
        }
    }
};
