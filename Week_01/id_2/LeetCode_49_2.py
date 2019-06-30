from typing import List
import collections

class Solution_1:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        d = {}
        for w in strs:
            key = str(sorted(w))
            d[key] = d.get(key, []) + [w]
        return list(d.values())


class Solution_2:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        ans = collections.defaultdict(list)  # defaultdict能防止keyError，不存在键则返回[]，因为工厂函数是list
        for s in strs:
            count = [0] * 26
            for c in s:
                count[ord(c) - ord('a')] += 1
            ans[tuple(count)].append(s)
        return list(ans.values())


if __name__ == "__main__":
    strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    # test = Solution_1()
    test = Solution_2()
    test.groupAnagrams(strs)