# https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/

# 思路 1:用一个 map 维护每个字母和索引的位置(有点像 two sum ?) ,遍历字符串,对于每个字符都考察在 map 中是否存在,如果存在,就比较map 的长度与迭代值,然后删除 map 中小于或等于其索引值的元素.如果不存在就在 map 中维护好这个字符和其索引值.
# 此解法要注意,不能在对 map循环的同时移除其元素.

from collections import defaultdict

class Solution1:
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

# 思路 2:滑动窗口(set 实现)
# 滑动窗口通常用 [set+双指针] 来实现.整个序列用 set 维护(因为 set 非常适合判别存在性),然后再使用两个指针 l,r 作为"窗口"的左右边界.
# 注意其中窗口左界的右移,是在一个 while 中进行的,一直移动知道 set 中不含相同元素.这里是有优化空间的.

class Solution2:
    def lengthOfLongestSubstring(self, s: str) -> int:
        st = set()
        l, r = 0, 0
        ans = 0
        for v in s:
            while v in st:
                st.remove(s[l])
                l += 1
            else:
                st.add(v)
                r += 1
                ans = max(ans, len(st))
        return ans

# 思路 3: 滑动窗口(map 实现,最强滑动窗口)
# 思路 2 中的左界右移是通过一个一个 remove 掉 l 位置所在元素+右移 l 实现的,事实上可以通过 map,不再 remove 元素,而只移动左边界,通过 l 和 r 来界定我们所需要的元素.这是思路 1 和思路 2 的结合.


# 初版:

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s:
            return 0

        dic = {s[0]: 0}  # key: 字符 value: 字符的最后一次出现的索引
        l, r = 0, 1  # 左闭右开
        ans = 1
        for i in range(1, len(s)):
            if s[i] in dic and dic[s[i]] >= l:
                ans = max(ans, r - l)
                l = dic[s[i]] + 1
                r += 1
                dic[s[i]] = i
            else:
                r += 1
                ans = max(ans, r - l)
                dic[s[i]] = i
        return ans

# 等价优化版: