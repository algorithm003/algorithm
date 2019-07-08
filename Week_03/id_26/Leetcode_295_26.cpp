class MedianFinder {
    multiset<int> data;
    multiset<int>:: iterator left, right;
public:
    MedianFinder(): left(data.end()), right(data.end()) {
        
    }
    
    void addNum(int num) {
        unsigned long size = data.size();
        
        data.insert(num);
        if (!size) {
            left = right = data.begin();
        } else if (size & 1) {
            num < *left ? left-- : right++;
        } else {
            if (num > *left && num < *right) {
                left++;
                right--;
            } else if (num >= *right) {
                left++;
            } else {
                left = --right;
            }
        }
    }
    
    double findMedian() {
        return (*left + *right) * 0.5;
    }
};
