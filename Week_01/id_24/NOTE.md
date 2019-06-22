# 学习笔记

week_01

* 1. removeDuplicateFromSortedArray 使用循环外部的变量计算相关的操作步骤，最终的长度就是触发外部变量修改的次数
* 2. rotateArray 利用递归，三次倒转数组元素，用余数来确定给源数组分段的位置
* 3. mergeTwoSortedLists 链表的操作，使用递归，drill down逻辑为，只要链表2的当前位置比链表1当前位置大，就把链表1的next改为链表2当前节点，同理如果小或等于就把链表2的next改为链表1当前位置