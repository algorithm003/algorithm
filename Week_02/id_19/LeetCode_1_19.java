/**
暴力破解法，双重循环，时间复杂度为O(n2)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}

/**
单循环+哈希算法降低时间复杂度O(n)
因为哈希表的查询时间复杂度为O(1),可将循环的数据存放其中，取目标值-数组元素对比
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        for(int i=0; i<nums.length;i++) {
            if (resultMap.containsKey(target-nums[i])) {
                return new int[]{resultMap.get(target-nums[i]),i};
            }
            resultMap.put(nums[i],i);
        }
        return null;
    }
}