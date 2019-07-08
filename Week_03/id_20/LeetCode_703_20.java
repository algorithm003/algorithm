package com.panguang.cooltea.pglib;

import java.util.PriorityQueue;

/*
 *   
 *   703. 数据流中的第K大元素
 * 
 *   设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * 
 *   你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 * 
 *   链接： https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 * 
 *   学号：020
 * 
 * */


public class LeetCode_703_20 {

    PriorityQueue<Integer> minHeap;
    int k;

    //利用优先队列的最小堆特性
    //时间复杂度：O(n)
    //空间复杂度：O(k)
    public LeetCode_703_20(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<Integer>(k);
        for (int n : nums) add(n);
    }

    public int add(int val) {
        if (minHeap.size() < k){
            minHeap.offer(val);
        }else if (minHeap.peek() < val){
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
