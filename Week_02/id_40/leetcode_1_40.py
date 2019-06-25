# https://leetcode-cn.com/problems/two-sum/
# 简单的题目,使用哈希表一遍遍历即可
# 时间复杂度:O(n)
# 空间复杂度:O(n)

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        _dic = {}
        for i, v in enumerate(nums):
            if target-v in _dic:
                return [_dic.get(target-v), i]
            else:
                _dic[v] = i
        return -1
