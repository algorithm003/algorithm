## bug-free 的二分查找

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

这里讲问题重新定义：**给定一个排序后的数组，可能包含重复元素，现在请找到从左向右方向第一个 *不小于* 目标值的元素的位置**（也就是目标区间的**下界**）？

> 注：关于上下界的概念，如果感觉难以记忆，可以参考 [这个问答](https://stackoverflow.com/questions/23554509/rationale-for-stdlower-bound-and-stdupper-bound). 其中有一个例子举的非常好：

```C++
std::vector<int> data = { 1, 1, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 6 };

auto lower = std::lower_bound(data.begin(), data.end(), 4);

1, 1, 2, 3, 3, 3, 3, [4, 4, 4,] 5, 5, 6
                      ^ lower

auto upper = std::upper_bound(data.begin(), data.end(), 4);

1, 1, 2, 3, 3, 3, 3, [4, 4, 4,] 5, 5, 6
                                ^ upper

std::copy(lower, upper, std::ostream_iterator<int>(std::cout, " "));
```
> 所谓的上下界，是对于有多个与目标值相等的元素的区间而言的。下界，就是这个区间内最小的索引值，上界，是这个区间右侧最小的索引值。

**首先对于终止条件**，由于是左闭右开，所以当搜索空间小于 1 的时候就说明已经找到或者再也找不到了。`while l < r` 是正确的。

其次，**对于左界的向右调整**，由于是"**左闭**", 此时此刻 `mid` 位置已经被搜索过了，若将左界放到 `mid`, 下次还会搜索它，所以应当将 左界放到 `mid`+1 的位置。

而**对于右边界的向左调整**，由于是"**右开**", 虽然此时此刻 `mid` 位置已经被搜索过了，但是若将右界放到 `mid`, 下次不会搜索到它，所以右界直接放到 `mid` 位置。

**最后的返回值**。需要注意，在终止循环的时候，`l >= r` 为真。事实上，当循环停止时，一定有`l = r`成立。而 `mid` 值其实是上次搜索的结果，并非我们的目标。所以最终要返回 `l` 或者 `r` 均可。

**细节 1**: 在求中间值 mid 的时候，写成`mid = (l + r) / 2 `会有大数溢出的风险。而`mid = l + ( r - l ) / 2`则没有风险。

**细节 2**: 由于可能存在重复值，所以不宜直接判断 `if arr[mid] == target: return mid`. 以下代码是把相等的情况归在了右边界左移的情况。

**细节 3**: 在`python`等动态语言中，应当把数据类型强制转换为`int`类型。

因此，求下界的正确代码应当是：

```python
def lower_bound(self, arr: List[int], target: int):
    l, r = 0, len(arr)-1
    while (l < r):
        mid = l + int(( r - l ) / 2)
        if arr[mid] < target:
            l = mid + 1
        else:
            r = mid
    return l
```

上界：

```python
def lower_bound(self, arr: List[int], target: int):
    l, r = 0, len(arr)-1
    while (l < r):
        mid = l + int(( r - l ) / 2)
        if arr[mid] <= target:
            l = mid + 1
        else:
            r = mid
    return l
```

可以看到，从求下界转换到求下界，就是把相等情况的处理方式移动到了另外一个分支。在求下界的时候是从由向左移动右边界，求上界的时候是从左向右移动左边界。

正确，清晰，简洁。

如果是查找目标区间**内部**的最大索引，只需求上界后将索引值-1.

## 拓展

在实际解题时，我们往往是利用二分查找来求一个最值，这个最值可能是使得某个等式或**不等式**成立。如 [leetcode 的第 441 题](https://leetcode-cn.com/problems/arranging-coins/). 此题转化为数学问题就是，求`k`的最大值，使得 `k * (k + 1)/2 <= n`成立。换句话说，就是**求 k 值的上界-1**.

答案:

```python
class Solution:
    def lower_bound(self, arr: List[int], target: int):
        l, r = 0, len(arr) - 1
        while (l < r):
            mid = l + int((r - l) / 2)
            if arr[mid] <= target:
                l = mid + 1
            else:
                r = mid
        return l - 1
```