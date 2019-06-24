class Solution {
public:
    double myPow(double x, int n) {
        if (n == 0)
            return 1;
        
        double y = myPow(x, n / 2);
        
        if (!(n & 1))
            return y * y;
        
        if(n > 0)
            return y * y * x;
        
        return y * y / x;
    }
        
};