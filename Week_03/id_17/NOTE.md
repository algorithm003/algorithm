# 第三周总结

这个周主要还是把DFS和BFS这两个东西给反复练习了几次，自己总结了一下BFS的模板（）：
```
queue=[root]
def bfs(queue):
    if not queue:
        return;
    next_queue=[]
    for node in queue:
         next_queue.append(node.children())
    bfs(next_queue)
```

DFS的递归写法和非递归写法
