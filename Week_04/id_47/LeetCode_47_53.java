class Solution {
    public int maxSubArray(int[] nums) {
        int iAns = nums[0];
        int iSum = 0;
        for(int num: nums) {
            if(iSum > 0) {
                iSum += num;
            } else {
                iSum = num;
            }
            iAns = Math.max(iAns, iSum);
        }
        return iAns;
    }
}