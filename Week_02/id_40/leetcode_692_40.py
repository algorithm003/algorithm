# https://leetcode-cn.com/problems/top-k-frequent-words/

# 注意题目中的一个不太显眼但重要的要求:"如果不同的单词有相同出现频率，按字母顺序排序。"

# 目前了解到的最简洁的做法是直接利用 heapd 模块的 nsmallest 函数.


from typing import List
from heapq import nsmallest

class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        counts={}
        for i,v in enumerate(words):
            counts[v] = counts.get(v,0)+1
        return nsmallest(k, counts,lambda i:(-counts[i],i))