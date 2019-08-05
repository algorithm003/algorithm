

class KthLargest {
public:
    //sol1: use pririoty queue. The only tricky point is edge case:
    //Given n ≥ k-1 and k ≥ 1. => Actually this statement implies that N can be less than K, but it is hard to observe this. Just need to consider this situation and it will be alright.

    priority_queue <int, vector<int>, greater<int> > pq;
    int K;
    KthLargest(int k, vector<int>& nums) {
        K=k;
        int n=nums.size();
        if(n==0) return;
                
        sort(nums.begin(),nums.end());
        if(k>n)
            k=n;
   
        for( int i=n-1; i>=n-k; i-- )
            pq.push(nums[i] );
      }
    
    int add(int val) {
        //special case1
        if(pq.empty()){
            pq.push(val);
            return val;
        }
        
        int minFromPQ=pq.top();
                        //cout<<minFromPQ<<endl;
      
        //special case2
        if(pq.size()<K){
            pq.push(val);                
            return pq.top();
        }
        
        //general case
        if ( val<=minFromPQ ){
                ;   //do nth
        }else{
           pq.pop();
           pq.push(val);
        }
        
        return pq.top();
    }
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */