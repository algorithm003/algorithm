class Solution:
    def findCircleNum(self, A):
        N = len(A)
        seen = set()

        def dfs(node):

            for nei, adj in enumerate(A[node]):
                if adj and nei not in seen:
                    seen.add(nei)
                    dfs(nei)
        ans = 0
        for i in range(N):
            if i not in seen:
                dfs(i)
                ans += 1
        return ans



    def findCircleNum2(self, M):
        def dfs(M, i, visited):
            visited[i] = True
            for j in range(len(M[i])):
                if M[i][j] == 1 and not visited[j]:
                    dfs(M, j, visited)

        visited = [False] * len(M)
        circle = 0
        for i in range(len(M)):
            if not visited[i]:
                dfs(M, i, visited)
                circle += 1
        return circle

if __name__ == "__main__":
    a = Solution()
    print(a.findCircleNum([[1,1,0],[1,1,0],[0,0,1]]))