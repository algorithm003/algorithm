# @Author:Kilien
# @lc app=leetcode id=547 lang=python3
# [547] Friend Circles
# https://leetcode.com/problems/friend-circles/description/
'''
初始化朋友圈数量count并建set()存放已查过的节点visited，col为纵坐标
函数主体：
    遍历朋友圈对应列节点
    若该列未访问过则进入dfs函数，遍历该行节点
    count+1

定义dfs函数：
    遍历朋友圈对应行节点
    若存在该节点且未访问过则将该节点加入visited
    若该节点不存在或者已访问过则忽略，避免重复计数
    drill down，遍历该行下一节点
'''
class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        visited, count = set(), 0
        col = len(M)

        def dfs(i):
            for row, node in enumerate(M[i]):
                if node and row not in visited:
                    visited.add(row)
                    dfs(row)
        
        for i in range(col):
            if i not in visited:
                dfs(i)
                count += 1
        return count

