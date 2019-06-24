class Solution {
public:
    int arrangeCoins(int n) {
        int low = 1, high = n;
        while (low < high) {
            long mid = low + (high - low + 1) / 2;
            ((mid + 1) * mid / 2 <= n) ? (low = mid) : (high = mid - 1);
        }
        return high;
    }
};
