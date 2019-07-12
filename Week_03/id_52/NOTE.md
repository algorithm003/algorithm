# 学习笔记
->在做题前先手写几次BFS 和 DFS.

200. Number of Islands
简单的一题但不知为何做起时很多BUG:
// 1. 忘记了GRID所存的是CHAR, 而自己写比较式是用了int, i.e. if(g[i][j]==0)
// 2. 很重要很重要!不要在主程度叫DFS()时之前忘了加一句if( g[i][j]!='0' ) 
// 3. 在做迷宫相关的题最好把grid print出来方便debug

210. Course Schedule II
这题是等於TOPOLOGICAL SORT. 第一时间是想起一般教材上的DFS方法, 当然因为忘记了所以上网找, 写得最好的是https://leetcode.com/problems/course-schedule-ii/solution/
中心思想是:
"The way DFS would work is that we would consider all possible paths stemming from A before finishing up the recursion for A and moving onto other nodes. All the nodes in the paths stemming from the node A would have A as an ancestor. The way this fits in our problem is, all the courses in the paths stemming from the course A would have A as a prerequisite."
以上讲述得好, 讲了DFS 的巧妙用法, 也是运用了RECURSION的思维:
"
➔ let S be a stack of courses
➔ function dfs(node)
➔     for each neighbor in adjacency list of node
➔          dfs(neighbor)
➔     add node to S  
"
"add node to S"  要放在DFS() FUNCTION的最後, 这个用法值得学习. 


703. Kth Largest Element in a Stream
Use pririoty queue. The only tricky point is edge case:
Given n ≥ k-1 and k ≥ 1. => Actually this statement implies that N can be less than K, but it is hard to observe this. Just need to consider this situation and it will be alright.

295. Find Median from Data Stream
直觉上这题很有挑战性,所以决定花多点时间在思考优胜於O(N) 的方法. 结果花了约1.5小时, 写了6版纸, 终於想到了O(LOG N) 的方法:  开始时是想修改AVL TREE 的ROTATE 算法, 於是在GOOGLE上搜"AVL", 在搜查结果中看到"SET"的字眼, 灵机一触, 发觉根本不用修改AVL TREE这麽覆杂, 用HEAP 即可. 当中走了很多错路, 但途中现了不少MEDIAN的特点才找到正确的解法.
    
