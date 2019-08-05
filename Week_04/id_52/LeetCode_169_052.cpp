class Solution {
public:
    //sol2: divide and conquer
    
    //return the elem that has the majority count in the array
     int majorE(int low, int hi,vector<int>& arr ){
         if(hi==low)
             return arr[low];
         
         int mid = low+(hi-low)/2;
        
         int left = majorE(low,mid,arr );
         int right = majorE(mid+1, hi,arr );
        

         if(left==right)
             return left;
         else{
             //count(...) Returns the number of elements in the range [first,last) that compare equal to val. => I think its better to write this function by myself...as I may forget to add 1 at the second arguement
            return  count(arr.begin()+low,arr.begin()+hi+1,left)>
                         count(arr.begin()+low,arr.begin()+hi+1,right) ? left : right;
         }
             
 
     }    
    
     int majorityElement(vector<int>& nums) {
         return  majorE(0,nums.size()-1, nums);
     }
    
    //sol1: count the elem numbers
    /*
    int majorityElement1(vector<int>& nums) {
        map<int,int> hm;
        priority_queue<int> heap;
        for(int i=0 ; i< nums.size() ; i++)
            hm[nums[i]]++;
        
        int largestcount =0;
        int key=nums[0];
        for (auto x : hm) {
           cout << x.first << " " << x.second << "\n";
           if( x.second> largestcount){
               largestcount=x.second;
               key=x.first;
           }  
        }
        cout<<key<<endl;
        return key;
        
    }
    */
};