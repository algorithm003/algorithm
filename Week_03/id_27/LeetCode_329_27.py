class Solution:
    def longestIncreasingPath(self, matrix):
        if not matrix or not matrix[0]:
            return 0
        def dfs(i, j):
            print(i, j)
            if not dp[i][j]:
                # print("dp",i, j)
                val = matrix[i][j]
                dp[i][j] = 1 + max(
                    dfs(i - 1, j) if i and val > matrix[i - 1][j] else 0,
                    dfs(i + 1, j) if i < M - 1 and val > matrix[i+1][j] else 0,
                    dfs(i, j - 1) if j and val > matrix[i][j-1] else 0,
                    dfs(i, j + 1) if j < N - 1 and val > matrix[i][j+1] else 0
                )
            print(dp, i, j)
            return dp[i][j]

        M, N = len(matrix), len(matrix[0])
        dp = [[0] * N for i in range(M)]
        return max(dfs(x, y) for x in range(M) for y in range(N))


if __name__ == "__main__":
    a = Solution()
    print (a.longestIncreasingP ath([[9,9,4],[6,6,8],[2,1,1]]))