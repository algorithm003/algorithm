# 1. 两数之和
### hashmap
```
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashMap = {}
        for i in range(len(nums)):
            key = str(target - nums[i])
            hashMap[key] = i
        for i in range(len(nums)):
            if str(nums[i]) in hashMap and hashMap[str(nums[i])] != i:
                return [i,hashMap[str(nums[i])]]
        return []
```
### 分析：

执行用时 :76 ms
, 在所有 Python3 提交中击败了
55.39%
的用户
内存消耗 :
15.6 MB
, 在所有 Python3 提交中击败了
5.05%
的用户
