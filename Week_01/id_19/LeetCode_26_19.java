class Solution {
    public int removeDuplicates(int[] nums) {
        
        // 时间复杂度为O(n)
        // 数组判断
        if (nums.length == 0) {
            return 0;
        }
        // 假设不相等的位置为1
        int uniquePos = 1;
        for(int i = 1;i < nums.length; i++) {
            // 这里要注意数组越界问题
            if (nums[i] != nums[i-1]) {
                // 数组往前移动
                nums[uniquePos] = nums[i];
                uniquePos++;
            }
        }
        return uniquePos;
        
    }
}
