class Solution {
public:
    int arrangeCoins(int n) {
        if (n <= 1)
            return n;
        
        long l = 1, r = n;
        while(l < r){
            long mid = l + (( r - l) >> 1);
            if((1 + mid) * mid / 2 <= n)
                l = mid + 1;
            else
                r = mid;
        }
        
        return l - 1;
    }
        
//         if(n <= 1)
//             return n;
        
//         long i = 1;
//         long sum;
//         while(i){
//             sum = (1 + i) * i / 2;
//             if(sum > n)
//                 break;
//             i++;
//         }
        
//         return i - 1;
//     }
};