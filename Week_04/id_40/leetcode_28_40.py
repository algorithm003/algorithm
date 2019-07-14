# https://leetcode-cn.com/problems/longest-word-in-dictionary/


# 暴力加长版
from typing import List

class Solution:

    def existLarger(self, word: str, wordset: set):
        for i in range(ord('a'), ord('z')):
            if (word + chr(i)) in wordset:
                return True
        return False

    def allsmallinset(self, word: str, wordset: set):
        for j in range(0, len(word)):
            if word[0:j + 1] not in wordset:
                return False
        return True

    def longestWord(self, words: List[str]) -> str:
        reslist = []
        maxlength = 0
        wordset = set(words)
        for i in range(len(words)):
            word = words[i]
            if self.existLarger(word, wordset):
                continue
            if not self.allsmallinset(word,wordset):
                continue
            if len(word) < maxlength:
                continue
            if len(word) > maxlength:
                reslist.clear()
            reslist.append(word)
            maxlength = len(word)

        reslist.sort()
        return "" if not reslist else reslist[0]