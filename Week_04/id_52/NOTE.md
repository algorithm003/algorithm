# 学习笔记
1.Learnt the templete coding of divide and conquer
2.Leetcode 52:
	when we divide and conquer an array, be careful for this:
	
    //-> Given a function:
       	divAndConquer(int lo, int hi, array ){...}
	
    //1. When accessing the lower bound or upper bound of array,
    //   you should use lo instead of 0, and hi instead of n-1.
    //2. clearly defines the lower bound and upper bound of the 
    //   function: is it [lo, hi) or [lo,hi]?
    