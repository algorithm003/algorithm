class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int res, cnt = 0;
        for(int num : nums){
            if(cnt == 0){
                cnt = 1;
                res = num;
            }else{
                num == res ? cnt++ : cnt--;
            }
        }
        
        return res;
    }
};