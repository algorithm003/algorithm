class Solution:
    '''
    通过HashMap来判断是否为有效的字母异位词
    将s和t字符串分别遍历字母放入到dict1和dict2中，并统计字母出现次数
    最后直接判断dict1和dict2是否相等，即可判断结果
    '''


    def isAnagram(self, s: str, t: str) -> bool:
        dict1, dict2 = {}, {}
        for st in s:
            dict1[st] = dict1.get(st, 0) + 1
        for st in t:
            dict2[st] = dict2.get(st, 0) + 1
        return dict1 == dict2