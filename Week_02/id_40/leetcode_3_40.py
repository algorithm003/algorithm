# https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/

# 思路 1:用一个 map 维护每个字母和索引的位置(有点像 two sum ?) ,遍历字符串,对于每个字符都考察在 map 中是否存在,如果存在,就比较map 的长度与迭代值,然后删除 map 中小于或等于其索引值的元素.如果不存在就在 map 中维护好这个字符和其索引值.
# 此解法要注意,不能在对 map循环的同时移除其元素.

from collections import defaultdict

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:

        m = 0
        dic = defaultdict(int)
        for i, v in enumerate(s):
            if v in dic:  # 如果存在 key,则统计元素数,然后把这个 key 之前的元素删掉
                tmpm = len(dic)
                if tmpm > m:
                    m = tmpm
                for key in list(dic.keys()):
                    if dic[key] <= dic[v]:
                        del (dic[key])
            dic[v] = i  # 不管是否存在,都把当前值添加进去,并维护其索引值

        # 最后考察 dic 中剩余的元素
        if len(dic) > m:
            m = len(dic)

        return m

# 思路 2:滑动窗口
# 滑动窗口通常用 [set+双指针] 来实现.整个序列用 set 维护(因为 set 非常适合判别存在性),然后再使用两个指针 l,r 作为"窗口"的左右边界.