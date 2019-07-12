class Solution {
public:

// First set up three indices in the array(nums):writter,A,B.
// writter points to index where the content will be over-written at the end of each loop.
// A bookmarks the current position, B will increment from A as long as the content of B is the same as A's.
// The main logic is the loop as follow:
    
/*while ( A!=N && B!=N ){
        if(nums[A] == nums[B])
            B++;       
        else{
           
            A=B;
            writter++;
          //  B++;
            
        }
         nums[writter] = nums[A];
    }
*/

// At the end of each loop, the content of writter will be assigned as nums[A]. nums[writter] will never contain duplicate values as it will be detected by B: If duplicated values are found B will go forward until a new value appears. The new value will be written to A[writter] and writter increases.
// The time complexity is O(N) with constant space.
    
int removeDuplicates(vector<int>& nums) {
    if (nums.size()==0)
        return 0;
    int A=0;
    int B=0;
    int writter=0;
    int N=nums.size();
    for(int i=0 ;i<N; i++)
        cout<< nums[i]<<" ";
    cout<< endl;

    
    while ( A!=N && B!=N ){
        if(nums[A] == nums[B])
            B++;       
        else{
           
            A=B;
            writter++;
          //  B++;
            
        }
         nums[writter] = nums[A];
    }

    for(int i=0 ;i<N; i++)
        cout<< nums[i]<<" ";
    cout<< endl;
    
    cout<<writter+1<<endl;
    return writter+1;
}
    



};