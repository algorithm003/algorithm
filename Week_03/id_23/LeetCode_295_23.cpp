class MedianFinder {
public:
    /** initialize your data structure here. */
    MedianFinder() {   
    }
    
    void addNum(int num) {
        min.push(num);
        max.push(-min.top());
        min.pop();
        if (min.size() < max.size()) {
            min.push(-max.top());
            max.pop();
        }
    }
    
    double findMedian() {
        return min.size() > max.size() ? min.top() : (min.top() - max.top()) / 2.0;
    }
private:
    priority_queue<long> min, max;
};
