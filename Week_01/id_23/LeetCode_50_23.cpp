class Solution {
public:
    double myPow(double x, long n) {
        if (n < 0)
            return myPow(1.0/x, -n);

        if (n == 0)
            return 1;

        double res = myPow(x, n/2);
        return (n & 1) ? (res * res * x) : (res * res);
    }
};

// nice !~
