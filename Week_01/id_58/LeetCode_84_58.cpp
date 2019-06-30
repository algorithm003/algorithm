class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int res = 0;
        
        stack<int> s;
        
        heights.push_back(0);
        
        for (int i = 0; i < heights.size(); i++){
            while (!s.empty() && heights[s.top()] >= heights[i]){
                int cur = s.top();
                s.pop();
                res = max(res, heights[cur] * (s.empty() ? i : (i - s.top() - 1)));     
            }
            s.push(i);
        }
        return res;
    }
    
        
//         int res = 0;
//         int n = heights.size();
//         for (int i =  0; i < n; i++){
//             if (i + 1 < n && heights[i] <= heights[i + 1])
//                 continue;
            
//             int min_h = heights[i];
//             for (int j = i; j >= 0; j--){
//                 min_h = min(min_h, heights[j]);
//                 int area = min_h * (i - j + 1);
//                 res = max(res, area);
//             }
//         }
        
//         return res;
//     }
};