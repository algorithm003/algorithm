# https://leetcode-cn.com/problems/group-anagrams/solution/zi-mu-yi-wei-ci-fen-zu-by-leetcode/

# 思路 1: 借助 map,以排序字符串为 key 分类
# 时间复杂度: O(NKlogK)
# 空间复杂度: O(NK)

from typing import List

class Solution1:

    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        result = []
        _map = {}

        for s in strs:
            key = tuple(sorted(s))
            if key in _map:
                _map[key].append(s)
            else:
                _map[key] = [s]

        for item in _map.values():
            result.append(list(item))

        return result


# 思路 2: 与思路 1 类似,但是是以字符统计信息为 key
# 时间复杂度: O(NK)
# 空间复杂度: O(NK)

class Solution2:

    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        _dict = {}
        for s in strs:
            count = [0]*26
            for c in s:
                count[ord(c)-ord('a')]+=1
            if tuple(count) in _dict:
                _dict[tuple(count)].append(s)
            else:
                _dict[tuple(count)] = [s]
        
        return list(_dict.values())