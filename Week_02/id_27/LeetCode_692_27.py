# 给一非空的单词列表，返回前 k 个出现次数最多的单词。
#
# 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
from collections import Counter


class Solution:
    def topKFrequent(self, words: [str], k: int) -> [str]:
        dict = {}
        for st in words:
            dict[st] = dict.get(st, 0) + 1
        res = []
        for (key, value) in dict.items():
            item = (-value, key)
            res.append(item)
        res.sort()
        res = res[:k]
        topK = []
        for i in res:
            topK.append(i[1])
        return topK


if __name__ == "__main__":
    a = Solution()
    b = a.topKFrequent(["i", "love", "leetcode", "i", "love", "coding"], 2)
    print(b)