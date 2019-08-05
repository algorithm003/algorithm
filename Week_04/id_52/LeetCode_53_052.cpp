class Solution {
public:
    //caution: when we divide and conquer an array, be careful for this:
    //-> Given a function divAndConquer(int lo, int hi, array ){...},
    //1. When accessing the lower bound or upper bound of array,
    //   you should use lo instead of 0, and hi instead of n-1.
    //2. clearly defines the lower bound and upper bound of the 
    //   function: is it [lo, hi) or [lo,hi]?
    
    int largestSum(int lo, int hi, vector<int>& nums) {
        //base case
        if( lo==hi)
            return nums[lo];
        
        //divide and conquer
        int mid= lo + (hi-lo)/2;
        
        int leftMaxi =  0;
        int store =  0;
        for(int i=mid-1 ; i>=lo ; i--){
            store += nums[i];
            if(store > leftMaxi)
                leftMaxi=store;
        }
        
        int rightMaxi =  0;
        store = 0;
        for(int i=mid+1 ; i<=hi ; i++){
            store += nums[i];
            if(store > rightMaxi)
                rightMaxi=store;
        }
        
        int bestWithMid=nums[mid]+max(0,leftMaxi)+max(0,rightMaxi);
        cout<<bestWithMid<<endl;
        return max({largestSum(lo,mid,nums ),
                   largestSum(mid+1,hi,nums ),
                   bestWithMid}
                 );
        
        
        
        
        
    }
    int maxSubArray(vector<int>& nums) {
       
        return largestSum(0,nums.size()-1,nums);
        
    }
};