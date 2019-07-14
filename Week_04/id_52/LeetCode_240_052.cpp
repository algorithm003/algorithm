class Solution {
public:
    //sol1: divide and conquer.
    //-Divide and conquer is so powerful is this case! Simple sol with short coding.
    //-Extension of the problem: The problem can be solved even if the matrix is not sorted vertically.
    //-Divide and conquer is useable when dealing with array problems (1D or 2D)
    
    int T;
    //returns if exists
    // [lo,hi]
    bool search(int lo, int hi,vector<vector<int>>& matrix){
       //base case
        if(lo==hi){
            auto k = lower_bound( matrix[lo].begin(), matrix[lo].end(), T ) - matrix[lo].begin() ;
            if (k < matrix[lo].size() && matrix[lo][k] == T)       // x found at index k
                return true;
            else return false;
        }
      
        int mid = lo + (hi-lo)/2;
        bool isUpper = search(lo,mid ,matrix);
        bool isLower = search(mid+1,hi ,matrix);
        return isUpper || isLower;
        
        
    }
    
    
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
        T=target;
        if(matrix.size()==0)
            return false;
        return search(0, matrix.size()-1,matrix);
    }
};