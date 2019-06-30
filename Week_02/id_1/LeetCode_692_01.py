# @Author：Kilien
# @lc app=leetcode id=692 lang=python3
# [692] Top K Frequent Words
# https://leetcode.com/problems/top-k-frequent-words/description/

class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        c=collections.Counter(words)
        print(c)
        c=dict(c)
        maxheap=[]
        for s in c:
            heapq.heappush(maxheap,(-c[s],s))
        l=[]
        while(k>0):
            freq,ch=heapq.heappop(maxheap)
            l.append(ch)
            k-=1
            
        return l

    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        d = {}
        for word in words:
            d[word] = d.get(word, 0) + 1
        
        ret = sorted(d, key=lambda word: (-d[word], word))
        
        return ret[:k]