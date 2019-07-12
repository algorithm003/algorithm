class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
       vector< vector<int> > result;
        if(nums.size()<3){
            
            return result;
        }
        bool allZeros=true;
        for(int i=0;i<nums.size();i++){
         if(nums[i]!=0)   
             allZeros=false;
        }
        if(allZeros){
            result.push_back({0,0,0});
            return result;
        }
            

        sort( nums.begin(),nums.end());
   
            
        int n=nums.size();            
        for(int i=0;i<nums.size()-1;i++){
            for(int j=i+1;j<nums.size();j++){
                int x= -(nums[i]+nums[j]);
                
                auto k = lower_bound(nums.begin()+j+1,nums.end(),x)-nums.begin();
                if (k < n && nums[k] == x) {
                // x found at index k
                    vector<int> vec; 
                    vec.push_back(nums[i]);
                    vec.push_back(nums[j]);
                    vec.push_back(-(nums[i]+nums[j]));
                    result.push_back(vec);
                    
                }

            }
        }
        sort( result.begin(), result.end() );
result.erase( unique( result.begin(), result.end() ), result.end() );
        
        return result;    
    }
};