import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=703 lang=java
 *
 * [703] 数据流中的第K大元素
 */
class KthLargest {
    PriorityQueue<Integer> priorityQueue;
    int length;
    public KthLargest(int k, int[] nums) {
        length=k;
        // 默认小顶堆，若大顶堆可以自定义比较器
        priorityQueue = new PriorityQueue<Integer>(k);
        for (int num : nums) {
            add(num);
        }
    }
    
    public  int add(int val) {
        if(priorityQueue.size()<length){
        priorityQueue.add(val);
        }else if(val>priorityQueue.peek()){
            priorityQueue.poll();
            priorityQueue.add(val);
        }
        return priorityQueue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

