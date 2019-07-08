import collections
import heapq
class Solution:
    def findOrder(self, numCourses: int, prerequisites: [[int]]) -> [int]:
        dict = {i : set() for i in numCourses}
        neged = collections.defaultdict(set())

        for i, j in prerequisites:
            dict[i].add(j)
            neged[j].add(i)

        queue = collections.deque(i for i in dict if not dict[i])
        res = []

        while queue:
            node = queue.popleft()
            res.append(node)
            for i in neged[node]:
                dict[i].remove(node)
                if not dict[i]:
                    queue.append(i)
        return res if len(res) == numCourses else []

if __name__ == "__main__":
    a = Solution()
    a.findOrder(4, [[1,0],[2,0],[3,1],[3,2]])
