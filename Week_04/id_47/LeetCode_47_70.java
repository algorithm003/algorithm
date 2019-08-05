class Solution {
    public int climbStairs(int n) {
        
        return dynamicByRecursion(n);
    }
    
    /**
    *动态规划，使用递归，时间复杂度居然通不过
    */
    private int dynamicByRecursion(int n) {
        if(n <= 2) {
            return n;
        }
        
        return dynamicByRecursion(n-1) + dynamicByRecursion(n-2);
    }
    /**
    * 时间复杂度O(n)
    */
    
    private int dynamicByArray(int n) {
        if(n <= 2) {
            return n;
        }
        
        int[] iStepArray = new int[n];
        iStepArray[0] = 1; 
        iStepArray[1] = 2;
        for(int i = 2 ; i < n ; i++) {
            iStepArray[i] = iStepArray[i-1] + iStepArray[i-2];
        }
        return iStepArray[n-1];
    }
}