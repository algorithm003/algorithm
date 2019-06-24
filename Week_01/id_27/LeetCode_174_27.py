class Solution:

    '''
    地下城游戏这题，用最小的生命值救出公主。因为0会死亡，所以最小生命值为1。
    所以可以倒推出，救出公主那一刻，扣完血之后，生命值还能剩余1
    由此来倒推出，往公主的路上，每一格最少要有多少血
    先把公主所在的行和列，分别求出最优生命值
    再用两个循环，计算出往右或者往下走，分别所需的最少生命值是多少，取两者最小值，即可得出该格所需的生命值。
    最后计算左上角第一格所需的最少生命值，即可得到答案。
    此题也是动态规划的思想
    '''

    def calculateMinimumHP(self, dungeon: List[List[int]]) -> int:
        if not dungeon:
            return 0
        row, col = len(dungeon), len(dungeon[0])
        dp = [[0 for x in range(col)] for x in range(row)]
        dp[row-1][col-1] = 1
        for i in range(row-2,-1,-1):
            dp[i][col-1] = max(1, dp[i+1][col-1] - dungeon[i+1][col-1])
        for i in range(col-2,-1,-1):
            dp[row-1][i] = max(1, dp[row-1][i+1] - dungeon[row-1][i+1])

        for i in range(row-2,-1,-1):
            for j in range(col-2,-1,-1):
                right = max(1, dp[i][j+1] - dungeon[i][j+1])
                down = max(1, dp[i+1][j] - dungeon[i+1][j])
                dp[i][j] = min(right, down)

        return max(1, dp[0][0] - dungeon[0][0])
