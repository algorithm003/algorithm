from typing import List


"""
    @author: Merlin 2019.07.14
    720.Longest Word in Dictionary
    思路: 根据每个单词长度来排序，用一个set来存储
    time: O(nlognL) n是数组长度，L是单词平均长度
    space: O(n) 借助一个set来存储
"""
class Solution:
    def longestWord(self, words: List[str]) -> str:
        valid = set([""])

        for word in sorted(words, key=lambda x: len(x)):
            if word[:-1] in valid:
                valid.add(word)

        return max(sorted(valid), key=lambda x: len(x))