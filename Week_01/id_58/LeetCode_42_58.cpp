class Solution {
public:
    int trap(vector<int>& height) {
        if(height.empty())
            return 0;
        
        int res = 0;
        
        int n = height.size();
        int leftMax = height[0];
        int rightMax = height[n - 1];
        
        int l = 1, r = n - 2;
        while(l <= r){
            if(leftMax <= rightMax){
                res += max(0, leftMax - height[l]);
                leftMax = max(leftMax, height[l++]);
            }else{
                res += max(0, rightMax - height[r]);
                rightMax = max(rightMax, height[r--]);
            }
        }
        
        return res;
    }
            
    
        
//         int res = 0;
        
//         int n = height.size();
//         for(int i = 1; i < n - 1; i++){
//             int leftMax = 0;
//             int rightMax = 0;
//             for(int l = 0; l < i; l++)
//                 leftMax = max(leftMax, height[l]);
//             for(int r = n - 1; r > i; r--)
//                 rightMax = max(rightMax, height[r]);
            
//             res += max(0, min(leftMax, rightMax) - height[i]);
//         }
        
//         return res;
//     }
};