# 1. 两数之和

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
