class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
    }
    
    public void addNum(int num) {        
        minHeap.add(num);
        maxHeap.add(minHeap.poll());
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() { 
        return minHeap.size() > maxHeap.size() ? (double) minHeap.peek() :
            ((double)minHeap.peek() + (double)maxHeap.peek()) / 2;
    }
}
