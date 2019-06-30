class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int max = 0;
        stack<pair<int, int>> sp;
        for (int i = 0; i < heights.size(); i++) {
            if (sp.empty() || sp.top().first < heights[i]) {
                sp.push(pair<int, int>(heights[i], i));
            } else {
                int l = 0;
                while (!sp.empty() && sp.top().first >= heights[i]) {
                    pair<int, int> top = sp.top();
                    l = top.second;
                    int size = (i - top.second) * top.first;
                    if (size > max) max = size;
                    sp.pop();
                }
                sp.push(pair<int, int>(heights[i], l));
            }
        }
        while (!sp.empty()) {
            pair<int, int> top = sp.top();
            int size = (heights.size() - top.second) * top.first;
            if (size > max) max = size;
            sp.pop();
        }
        return max;
    }
};
