# https://leetcode-cn.com/problems/valid-anagram/

# 思路 1: 获取 ascii 码形成 list, 并排序 - 比较.
# 时间复杂度: O(nlogn)
# 空间复杂度: O(n)


class Solution1:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        l1, l2 = [], []
        for c1, c2 in zip(s, t):
            l1.append(ord(c1))
            l2.append(ord(c2))
        l1.sort()
        l2.sort()

        return l1 == l2

# 思路 2: 将字符出现的频率整理为词典, 比较词典. 这里的词典可以是自带数据结构, 也可用数组模拟.
# 时间复杂度: O(n)
# 空间复杂度: O(1) 字母表大小不变


class Solution2:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        l = [0]*26
        for i in range(len(s)):
            l[ord(s[i])-ord('a')] += 1
            l[ord(t[i])-ord('a')] -= 1

        for c in l:
            if c != 0:
                return False

        return True
