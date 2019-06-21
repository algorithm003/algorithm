在学习 （复习？) 二分查找的过程中遇到了一些 corner case, 感觉总是处理不好。参考了知乎的一个 [回答](https://www.zhihu.com/question/36132386/answer/530313852) 后，在这里详细总结一下。

二分搜索的难点在于边界条件判断，一不留神就会出错。

首先写一个符合直觉但并不一定正确的二分查找：

```python
def bSearch(self, arr: List[int], target: int):
    mid = 0
    l = 0
    r = len(arr)
    while l < r:  # 终止条件是否正确？
        mid = int((l + r) / 2)
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            l = mid  # 左界 （下界） 调整是否正确？
        else:
            r = mid  # 右界（上界）调整是否正确？

    return mid # 返回值是否正确？
```

- 终止条件是 `while (left < right)` 还是 `while ( left <= right )` ?
- 边界调整是否正确？
- 其他细节？

事实上只需要牢记**左闭右开**的原则即可！

这里讲问题重新定义：**给定一个排序后的数组，可能包含重复元素，现在请找到从左向右方向第一个与目标值相等的元素的位置？**

首先对于终止条件，由于是左闭右开，所以当搜索空间小于 1 的时候就说明已经找到或者再也找不到了。`while l < r` 是正确的。

其次，对于左界的向右调整，由于是"**左闭**", 此时此刻 `mid` 位置已经被搜索过了，若将左界放到 `mid`, 下次还会搜索它，所以应当将 左界放到 `mid`+1 的位置。

而对于右边界的向左调整，由于是"**右开**", 虽然此时此刻 `mid` 位置已经被搜索过了，但是若将右界放到 `mid`, 下次不会搜索到它，所以右界直接放到 `mid` 位置。

最后的返回值。需要注意，在终止循环的时候，`l >= r` 为真。事实上，当循环停止时，一定有`l = r`成立。而 `mid` 值其实是上次搜索的结果，并非我们的目标。所以最终要返回 `l` 或者 `r` 均可。

另外一个细节，在求中间值 mid 的时候，写成`mid = (l + r) / 2 `会有大数溢出的风险。而`mid = l + ( r - l ) / 2`则没有风险。

因此，我们的正确代码应当是：

```python
def bSearch(self, arr: List[int], target: int):
    l, r = 0, len(arr)-1
    while (l < r):
        mid = l + int(( r - l ) / 2)
        if arr[mid] < target:
            l = mid + 1
        else:
            r = mid
    return l
```

正确，清晰，简洁。