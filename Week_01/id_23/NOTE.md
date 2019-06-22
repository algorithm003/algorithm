# 学习笔记

## 数组、链表
- 简单：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/

> 思路：这道题删除数组重复元素，数组是递增有序的，且要求在原数组中直接操作且不能额外分配数组空间，那这里只需要记住去重元素后的下标，遍历数组将不重复的元素以此拷贝到去重下标所在的数组即可，数组长度即最后拷贝后的下标+1。
> 
> 题解：TODO

- 简单：https://leetcode-cn.com/problems/rotate-array/
> 思路：要求空间复杂度为O1，意味着不能在申请一个相同长度的数组。想到了2种思路，第一种就是每次数组所有元素向右移动1位，循环k次即可；第二种是把前n-k个元素反转，再把后k个元素反转，最后把整个数组反转。
> 
> 题解：TODO

- 简单：https://leetcode-cn.com/problems/merge-two-sorted-lists/
> 思路：这个题目考察的是对于链表的操作，实现上要注意的点是合并链表的头指针初始化、合并时next指针的拼接，及当某个链表合并完成后的收尾工作。
> 
> 题解：TODO

- 简单：https://leetcode-cn.com/problems/merge-sorted-array/
> 思路：有2种思路，第一种是先把num2数组的n个元素放到num1数组m个元素之后，再对num1数组的前m+n个元素做排序；第二种是直接在num1数组做合并，从m+n-1下标开始依次把待合并的较大元素复制过去。
> 
> 题解：TODO

- 中等：https://leetcode-cn.com/problems/swap-nodes-in-pairs/
> 思路：链表中两两元素交换，这里申请一个哨兵节点来做会更容易处理，哨兵节点的next指向待处理的head指针，那么问题就转换为交换后两个节点的子问题。
> 
> 题解：TODO

- 中等：https://leetcode-cn.com/problems/3sum/
> 思路：问题转换为对于数组中任意两个元素a和b，找到第三个元素-(a+b)。排除暴力的解法外，第二种思路先对数组做排序，再做两层循环遍历a和b，在接下来的元素中采用二分查找找到-(a+b)；第三种思路先对数组做排序，再遍历数组元素a，在元素a后面查找两个元素相加等于-a（由于数组是有序的，可采用两边往中间夹的方法）。
> 
> 题解：TODO

## Map & Set
- 简单：https://leetcode-cn.com/problems/valid-anagram/
> 思路：思路一先对两个字符串做排序再比较，思路二是对每个字符串中字母个数做统计，比较统计结果是否一致。
> 
> 题解：TODO

- 中等：https://leetcode-cn.com/problems/group-anagrams/
> 思路：思路一是两层循环遍历每两个元素，判断两个元素是否为异位词，如果是则存储在同一个结果集里；思路二是建立一个hash算法，满足异位词计算的hash值相同，这样就可以用map来将不同的异位词分组。
> 
> 题解：TODO

## 堆栈、队列
- 简单：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
> 思路：这个题跟判断字符串里的括号是否匹配很类似，可以用栈来实现。
> 
> 题解：TODO

- 简单：https://leetcode-cn.com/problems/remove-outermost-parentheses/
> 思路：这道题通过栈可以获取到需要删除的外层括号的位置，再将无需删除的串拼接起来即可。
> 
> 题解：TODO

- 困难：https://leetcode.com/problems/largest-rectangle-in-histogram/
- 困难：https://leetcode.com/problems/trapping-rain-water/

## 二分查找
- 简单：https://leetcode-cn.com/problems/arranging-coins/
> 思路：依次减去第k行的硬币数并计数，直到不够减为止。
>
> 题解：TODO

- 中等：https://leetcode-cn.com/problems/powx-n/
> 思路：将x^n转换为(x/2)^n^2，再处理下n为负数及奇数的情况。
> 
> 题解：TODO

- 困难：https://leetcode-cn.com/problems/dungeon-game/

## 递归
- 简单：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
> 思路：DFS/BFS
> 
> 题解：TODO

- 简单：https://leetcode-cn.com/problems/symmetric-tree/
> 思路：最直接的想法是采用BFS算法来做，但提交了好几遍发现有很多case都会失败，后来参考了题解中的方法。
> 
> 题解：TODO

- 简单：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
> 思路：BFS/DFS
> 
> 题解：TODO

- 简单：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
> 思路：一种思路是采用中序遍历的方法得到有序的序列，再依次比较相邻两个元素的差值，并记录最小差值；
>
> 题解：TODO

- 简单：https://leetcode-cn.com/problems/binary-tree-paths/
> 思路：BFS/DFS
> 
> 题解：TODO

- 简单：https://leetcode-cn.com/problems/range-sum-of-bst/
> 思路：采用中序遍历的方法得到有序序列，再将范围内的指累加；
> 
> 题解：TODO

- 中等：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
