//
//  leetcode_200_29.swift
//  极客时间
//
//  Created by gavin hu on 2019/7/7.
//  Copyright © 2019 gavin hu. All rights reserved.
//

import Foundation

class Solution {
    
    /*
     深度优先遍历
     */
    private let directions:[[Int]] = [[-1,0],[0,-1],[1,0],[0,1]]//设置方向的数组  左、上、右、下
    private var marked = [[Int]]()//标记数组，标记了 grid 的坐标对应的格子是否被访问过
    private var rows = 0// grid 的行数
    private var cols = 0// grid 的列数
    private var grid:[[Character]] = [[Character]]()// 用来存储传进来的grid
    
    // 封装成 inArea 方法语义更清晰 是否在
    private func inArea(_ x:Int ,_ y:Int) ->Bool {
        return x >= 0 && x < rows && y >= 0 && y < cols
    }
    
    // 从坐标为 (i,j) 的点开始进行深度优先遍历
    private func dfs(_ i:Int,_ j:Int) {
        marked[i][j] = 1
        for k in 0..<4 {
            let newX = i + directions[k][0]
            let newY = j + directions[k][1]
            if inArea(newX, newY) && grid[newX][newY] == "1" && marked[newX][newY] == 0 {
                dfs(newX, newY)
            }
        }
    }
    
    func numIslands(_ grid: [[Character]]) -> Int {
        rows = grid.count
        if rows == 0 {
            return 0
        }
        cols = grid[0].count
        self.grid = grid
        marked = [[Int]].init(repeating: [Int].init(repeating: 0, count: cols), count: rows)
        var count = 0
        
        for i in 0..<rows {
            for j in 0..<cols {
                // 如果是岛屿中的一个点，并且没有被访问过
                // 就进行深度优先遍历
                if grid[i][j] == "1" && marked[i][j] == 0 {
                    count += 1
                    dfs(i, j)
                }
            }
        }
        return count
    }
}


class Solution1 {
    /*
     广度优先遍历
     */
    private let directions:[[Int]] = [[-1,0],[0,-1],[1,0],[0,1]]//设置方向的数组  左、上、右、下
    private var rows = 0  // grid 的行数
    private var cols = 0  // grid 的列数
    private var marked = [[Int]]()//标记数组，标记了 grid 的坐标对应的格子是否被访问过
    private var grid:[[Character]] = [[Character]]()// 用来存储传进来的grid
    
    // 封装成 inArea 方法语义更清晰 是否在
    private func inArea(_ x:Int ,_ y:Int) ->Bool {
        return x >= 0 && x < rows && y >= 0 && y < cols
    }
    
    
    // 从坐标为 (i,j) 的点开始进行深度优先遍历
    private func bfs(_ i:Int,_ j:Int) {
        marked[i][j] = 1
        var queue = [[Int]]()
        queue.append([i,j])
        while queue.count > 0 {
            let cur = queue.removeFirst()
            for k in 0..<4 {
                let newX = cur[0] + directions[k][0]
                let newY = cur[1] + directions[k][1]
                
                if inArea(newX, newY) && grid[newX][newY] == "1" && marked[newX][newY] == 0 {
                    queue.append([newX,newY])
                    marked[newX][newY] = 1
                }
            }
        }
    }
    
    func numIslands(_ grid: [[Character]]) -> Int {
        rows = grid.count
        if rows == 0 {
            return 0
        }
        self.grid = grid
        cols = grid[0].count
        marked = [[Int]].init(repeating: [Int].init(repeating: 0, count: cols), count: rows)
        var count = 0
        
        for i in 0..<rows {
            for j in 0..<cols {
                // 如果是岛屿中的一个点，并且没有被访问过
                // 从坐标为 (i,j) 的点开始进行广度优先遍历
                if grid[i][j] == "1" && marked[i][j] == 0 {
                    count += 1
                    bfs(i, j)
                }
            }
        }
        return count
    }
}


class Solution2 {
    
    /**
     使用并查集来做
     */
    class UnionFind {
        
        var count:Int
        var parent:[Int]
        var rank:[Int]
        
        init(_ n:Int) {
            self.count = n
            parent = [Int].init(repeating: 0, count: n)
            rank = [Int].init(repeating: 1, count: n)
            for i in 0..<n {
                parent[i] = i
            }
        }
        
        func getSize() ->Int{
            return self.count
        }
        
        //找到p所对应的集合的rootId
        func find(_ p: Int) -> Int {
            var cp = p
            while cp != self.parent[cp] { //路径压缩
                cp = self.parent[cp]
            }
            return cp
        }
        
        // 判断这两个元素是否在一个集合
        func connected(_ p:Int ,_ q:Int) -> Bool {
            return find(p) == find(q)
        }
        
        //将两个元素合并在一起
        func union(_ p:Int,_ q:Int) {
            let p_root = find(p)
            let q_root = find(q)
            if p_root == q_root {
                return
            }
            
            if self.rank[p_root] > self.rank[q_root] {
                self.parent[q_root] = self.parent[p_root]
            }else if self.rank[p_root] < self.rank[q_root] {
                self.parent[p_root] = self.parent[q_root]
            }else{
                self.parent[q_root] = self.parent[p_root]
                self.rank[p_root] += 1
            }
            self.count -= 1
        }
    }
    
    private var rows = 0  // grid 的行数
    private var cols = 0  // grid 的列数
    private let directions:[[Int]] = [[1,0],[0,1]]//设置方向的数组 右、下
    
    private func getIndex(_ x:Int,_ y:Int) ->Int {
        return x * cols + y
    }
    
    func numIslands(_ grid: [[Character]]) -> Int {
        rows = grid.count
        if rows == 0 {
            return 0
        }
        cols = grid[0].count
        
        let dummy_node = rows * cols
        
        let uf = UnionFind.init(dummy_node+1)
        
        for i in 0..<rows {
            for j in 0..<cols {
                if grid[i][j] == "0" {
                    uf.union(getIndex(i, j), dummy_node)
                }
                if grid[i][j] == "1" {
                    for direction in directions {
                        let newX = i + direction[0]
                        let newY = j + direction[1]
                        if newX < rows && newY < cols && grid[newX][newY] == "1" {
                            uf.union(getIndex(i, j), getIndex(newX, newY))
                        }
                    }
                }
            }
        }
        
        return uf.getSize() - 1
    }
}


let s = Solution2()

let res = s.numIslands([["1", "1", "0", "0", "0"],
                        ["1", "1", "0", "0", "0"],
                        ["0", "0", "1", "0", "0"],
                        ["0", "0", "0", "1", "1"]])

print(res)
