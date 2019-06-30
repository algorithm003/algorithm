"""
    直接比较排序后的两个字符串
    time: O(n * logn) # space:O(1)
"""
class Solution_1:
    def isAnagram(self, s: str, t: str) -> bool:
        return sorted(s) == sorted(t)


"""
    超哥视频思路
    用map对字符串进行计数
    遍历字符串时间复杂度为O(n),计数插入为O(1)

    第二种方法，用map对字母进行计数
    Python字典get方法,返回指定键的值，如果值不在字典中则返回默认值
    Python字典的get方法在Python2和Python3上的用法一样
    time: O(n) space: O(n)
"""
class Solution_2:
    def isAnagram(self, s: str, t: str) -> bool:
        dic1, dic2 = {}, {}
        for item in s:
           dic1[item] = dic1.get(item, 0) + 1
        for item in t:
           dic2[item] = dic2.get(item, 0) + 1
        return dic1 == dic2


"""
    第三种和第二种差不多，写法上是手写一个数组
    Python的ord函数，ord返回一个字符(长度为1的字符串)对应的ASCII数值

    time: O(n) space: O(n)
"""
class Solution_3:
    def isAnagram(self, s: str, t: str) -> bool:
        dic1, dic2 = [0] * 26, [0] * 26  # 有26个字母所以是乘以26
        for item in s:
            # 其实此处ord(item) - ord('a')相当于构造了一个哈希函数
            dic1[ord(item) - ord('a')] += 1  # 假如item为a，则dic1[0] += 1
        for item in t:
            dic2[ord(item) - ord('a')] += 1
        return dic1 == dic2


"""
    速度最快解法
    time: O(n) space: O(1)
"""
class Solution_4:
    def isAnagram(self, s: str, t: str) -> bool:

        if len(s) != len(t):
            return False

        letters = 'abcdefghijklmnopqrstuvwxyz'
        for letter in letters:
            if s.count(letter) != t.count(letter):
                return False
        return True