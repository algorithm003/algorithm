class Solution {
public
    vectorint twoSum(vectorint& nums, int target) {

        mapint, int hm;
        for(int i=0; inums.size(); i++)
            hm[nums[i]]++;
        
        
        for(int i=0; inums.size()-1; i++){
            int key = target- nums[i];
            hm[ nums[i] ]--;
            if(hm[key]0){
                for(int j=i+1; jnums.size();j++)
                    if(nums[j]==key)
                        return {i,j};
                
            }
            
        }
        
        return {-1,-1};
        
    }
};