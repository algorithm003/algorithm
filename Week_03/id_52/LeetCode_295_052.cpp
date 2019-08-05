class MedianFinder {
public:
    /** initialize your data structure here. */
    
    
    //sol1:直觉上这题很有挑战性,所以决定花多点时间在思考优胜於O(N) 的方法. 结果花了约1.5小时, 写了6版纸, 终於想
    //     到了O(LOG N) 的方法:  开始时是想修改AVL TREE 的ROTATE 算法, 於是在GOOGLE上搜"AVL", 在搜查结果中看到
    //     "SET"的字眼, 灵机一触, 发觉根本不用修改AVL TREE这麽覆杂, 用HEAP 即可. 当中走了很多错路, 但途中现了不少MEDIAN
    //     的特点才找到正确的解法.
    
    priority_queue<int> heap1;  //max heap
    priority_queue<int, vector<int>, greater<int> > heap2;  //min heap
    int middle;
    int n=0;
    
    MedianFinder() {
        
    }
    
    void addNum(int num) {
      
        if(n==0){
            middle=num;
            n++;
            return ;
        }
        if(num<middle)
           heap1.push(num);
        else
           heap2.push(num);
        
        
        //if the two heaps are not balanced after insertion:
        if ( heap1.size() > heap2.size() ){  //heap 1 is heavier 
            heap2.push(middle);
            middle=heap1.top();
            heap1.pop();
            
        }else if( heap2.size() > heap1.size() ){ //heap 2 is heavier
            heap1.push(middle);
            middle=heap2.top();
            heap2.pop();
        }   
    }
    
    double findMedian() {

        if(heap1.size() > heap2.size())
            return ((double)middle + (double)heap1.top())/2.0;
        else if (heap2.size() > heap1.size())
            return ((double)middle + (double)heap2.top())/2.0;
        else
            return middle;
            
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */