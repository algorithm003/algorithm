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
- 中等：https://leetcode-cn.com/problems/3sum/

## Map & Set
- 简单：https://leetcode-cn.com/problems/valid-anagram/
- 中等：https://leetcode-cn.com/problems/group-anagrams/

## 堆栈、队列
- 简单：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
- 简单：https://leetcode-cn.com/problems/remove-outermost-parentheses/
- 困难：https://leetcode.com/problems/largest-rectangle-in-histogram/
- 困难：https://leetcode.com/problems/trapping-rain-water/

## 二分查找
- 简单：https://leetcode-cn.com/problems/arranging-coins/
- 中等：https://leetcode-cn.com/problems/powx-n/
- 困难：https://leetcode-cn.com/problems/dungeon-game/

## 递归
- 简单：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
- 简单：https://leetcode-cn.com/problems/symmetric-tree/
- 简单：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
- 简单：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
- 简单：https://leetcode-cn.com/problems/binary-tree-paths/
- 简单：https://leetcode-cn.com/problems/range-sum-of-bst/
- 中等：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
