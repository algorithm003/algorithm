#include <iostream>

/*
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。



示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.
 */


struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        ListNode * headResultNode;
        ListNode * curNode = head;

        if (head==NULL)
        {
            return NULL;
        }

        if (head->next == NULL)
        {
            return head;
        }

        ListNode * nextNode = head->next;
        ListNode * swapNode;
        ListNode * tmpNode;
        ListNode * endNode = nextNode->next;

        bool firstTimeSwap = true;

        while (curNode && nextNode )
        {

            if (firstTimeSwap)
            {
                swapNode = curNode;
                curNode->next = nextNode->next;
                nextNode->next = curNode;
                swapNode = nextNode;

                headResultNode = swapNode;
                tmpNode = swapNode->next;

                if (endNode)
                {
                    curNode = endNode;
                } else{
                    break;
                }

                if (curNode)
                {
                    nextNode = curNode->next;
                } else{
                    break;
                }

                if (nextNode)
                    endNode = nextNode->next;

                firstTimeSwap = false;
            }
            else
            {

                curNode->next = nextNode->next;
                nextNode->next = curNode;
                tmpNode->next = nextNode;
                tmpNode = nextNode;

                if (endNode)
                {
                    curNode = endNode;
                } else{
                    break;
                }

                if (curNode)
                {
                    nextNode = curNode->next;
                } else{
                    break;
                }

                if (nextNode)
                    endNode = nextNode->next;

                tmpNode = tmpNode->next;
            }
        }
        return headResultNode;
    }
};



int main() {
    Solution mytest;

    ListNode node1(1);
    ListNode node2(2);
    ListNode node3(3);
    ListNode node4(4);
    ListNode node5(5);
    ListNode node6(6);
    ListNode node7(7);
    ListNode node8(8);

    node1.next = &node2;
    node2.next = &node3;
    node3.next = &node4;
    node4.next = &node5;
    node5.next = &node6;
    node6.next = &node7;
    node7.next = &node8;

    ListNode * resultNode1 = mytest.swapPairs(&node1);

    std::cout << "Hello, World!" << std::endl;
    return 0;
}