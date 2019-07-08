class KthLargest {
public:
    KthLargest(int k, vector<int>& nums): count(k) {
        for_each(nums.begin(), nums.end(), [this](int val){add(val);});
    }
    
    int add(int val) {
        data.push(val);
        if (data.size() > count) {
            data.pop();
        }
        return data.top();
    }
private:
    priority_queue<int, vector<int>, greater<int>> data;
    int count;
};

class KthLargest {
public:
    KthLargest(int k, vector<int>& nums): count(k) {
        for_each(nums.begin(), nums.end(), [this](int val){add(val);});
    }
    
    int add(int val) {
        data.insert(val);
        if (data.size() > count) {
            auto iter = data.end(); data.erase(--iter);
        }
        auto iter = data.end(); return *(--iter);
    }
private:
    multiset<int, greater<int>> data;
    int count;
};
