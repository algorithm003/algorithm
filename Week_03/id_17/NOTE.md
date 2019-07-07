# 第三周总结

这个周主要还是把DFS和BFS这两个东西给反复练习了几次，自己总结了一下BFS的模板（递归方式）  
这个模板的思路就是做一个队列来存储下一层的所有节点  
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

而DFS和BFS的区别，DFS就是用栈的方式存储下一层的节点，而BFS用队列的方式进行存储
