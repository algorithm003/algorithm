# 1. 两数之和

>给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个整数，并返回他们的数组下标。
>
>你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
>
>示例:
>
>给定 nums = [2, 7, 11, 15], target = 9
>
>因为 nums[0] + nums[1] = 2 + 7 = 9
>所以返回 [0, 1]
>
>来源：力扣（LeetCode）
>链接：https://leetcode-cn.com/problems/two-sum
>著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 暴力解法

```
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        _len = len(nums)
        for i in range(_len-1):
            for j in range(i+1,_len):
                if nums[i] + nums[j] == target:
                    return [i,j]
        else:
            return []
```

#### 分析：

执行结果：超出时间限制

时间复杂度：O(n^2)

空间复杂度：O(1)

显然python不适合暴力解



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

这个方法就是先把所有的数算一遍，算出每个数和目标值的差，用这个作为key，用原index作为value

然后再把所有的数扫一遍，如果有数在hashmap的key中就说明当前这个key对应的index和当前数对应的index之和是满足条件的，
然后再判断一下两个index是不是相等，因为题目要求不能复用

#### 分析：

执行用时 :76 ms, 在所有 Python3 提交中击败了55.39%的用户

内存消耗 :15.6 MB, 在所有 Python3 提交中击败了5.05%的用户

时间复杂度：O(2n)

空间复杂度：O(n)

### TODO

 - [ ] 看题解还可以用一次循环解决的，需要尝试一下这种方法
