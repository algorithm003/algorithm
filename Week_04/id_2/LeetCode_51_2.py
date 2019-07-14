from typing import List

class Solution_1:
    def solveNQueens(self, n: int) -> List[List[str]]:
        if n < 1: return []
        self.result = []
        self.cols = set(); self.pie = set(); self.na = set()
        self._dfs(n, 0, [])
        return self._generate_result(n)

    def _dfs(self, n, row, cur_state):
        # recursion terminator
        if row >= n:
            self.result.append(cur_state)
            return

        for col in range(n):
            if col in self.cols or row + col in self.pie or row - col in self.na:
                # go die!
                continue

            # update the flags
            self.cols.add(col)
            self.pie.add(row + col)
            self.na.add(row - col)

            self._dfs(n, row + 1, cur_state + [col])

            self.cols.remove(col)
            self.pie.remove(row + col)
            self.na.remove(row - col)

    def _generate_result(self, n):
        board = []
        for res in self.result:
            for i in res:
                board.append("." * i + "Q" + "." * (n - i - 1))

        return [board[i: i + n] for i in range(0, len(board), n)]


class Solution_2:
    def solveNQueens(self, n: int) -> List[List[str]]:
        def _dfs(cols, pie, na):
            # cols数组有多少个元素就是第几行
            row = len(cols)
            if row == n:
                result.append(cols)
                return None
            for col in range(n):
                if col not in cols and row + col not in pie and row - col not in na:
                    _dfs(cols + [col], pie + [row + col], na + [row - col])

        result = []
        _dfs([], [], [])
        return [["." * i + "Q" + "." * (n - i - 1) for i in row] for row in result]