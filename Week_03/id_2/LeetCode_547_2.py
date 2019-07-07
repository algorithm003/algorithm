from typing import List


class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        res, visited = 0, [0] * len(M)

        def dfs(m, visited, i):
            for j in range(len(m)):
                if m[i][j] == 1 and not visited[j]:
                    visited[j] = 1;
                    dfs(m, visited, j)

        for i in range(len(M)):
            if not visited[i]: dfs(M, visited, i); res += 1
        return res