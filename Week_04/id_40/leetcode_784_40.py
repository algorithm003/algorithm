# https://leetcode-cn.com/problems/letter-case-permutation/submissions/

# 正确但尚需优化的版本:

from typing import List
class Solution:

    def _helper(self, chars: str, res: List[str], pos: int):
        if pos == len(chars):
            res.append(chars)
            return

        if '0' <= chars[pos] <= '9':
            self._helper(chars, res, pos + 1)
            return

        tmp1 = chars[:pos] + str.lower(chars[pos])
        tmp2 = ""
        if pos < len(chars) - 1:
            tmp2 = chars[pos + 1:]
        self._helper(tmp1+tmp2,res,pos+1)
        
        tmp1 = chars[:pos] + str.upper(chars[pos])
        self._helper(tmp1+tmp2,res,pos+1)

        


    def letterCasePermutation(self, S: str) -> List[str]:
        res=[]
        self._helper(S,res,0)
        return res