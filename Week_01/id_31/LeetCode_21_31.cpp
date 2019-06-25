#include <iostream>



/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        bool firstNode = true;
        bool haveNull = false;
        if ( (l1 == NULL) && (l2 == NULL) )
        {
            return NULL;
        }

        if (l1 == NULL)
        {
            haveNull = true;
        }

        if (l2 == NULL)
        {
            haveNull = true;
        }

        ListNode  *head = new ListNode(0);
        ListNode  *prev = new ListNode(0);

        if (haveNull == false)
        {
            if ((l1->val > l2->val))
            {

                head->val = l2->val;
                l2 = l2->next;
            }
            else
            {
                head->val = l1->val;
                l1 = l1->next;
            }
        }
        else
        {
            if (l1!=NULL)
            {
                head->val = l1->val;
                l1 = l1->next;
            }
            else
            {
                head->val = l2->val;
                l2 = l2->next;
            }
        }

        prev->val = head->val;
        prev->next = head->next;

        while(l1 && l2)
        {


            ListNode *tmpNode = new ListNode(0);

            if (l1->val > l2->val)
            {

                tmpNode->val = l2->val;
                l2 = l2->next;
            }
            else
            {
                tmpNode->val = l1->val;
                l1 = l1->next;
            }

            if (firstNode)
            {
                prev->next = tmpNode;
                head->next = tmpNode;
                firstNode = false;
            }
            prev->next = tmpNode;
            prev = prev->next;
        }

        if (l1!=NULL)
        {
            while(l1)
            {
                ListNode *tmpNode = new ListNode(0);
                tmpNode->val = l1->val;

                if (firstNode)
                {
                    prev->next = tmpNode;
                    head->next = tmpNode;
                    firstNode = false;
                }

                prev->next = tmpNode;
                prev = prev->next;
                l1=l1->next;
            }
        }
        else
        {
            if (l2!=NULL)
            {
                while(l2)
                {
                    ListNode *tmpNode = new ListNode(0);
                    tmpNode->val = l2->val;

                    if (firstNode)
                    {
                        prev->next = tmpNode;
                        head->next = tmpNode;
                        firstNode = false;
                    }
                    prev->next = tmpNode;
                    prev = prev->next;
                    l2=l2->next;
                }
            }
        }

        return head;

    }
};


int main() {
    ListNode listNode1_1(1);
    ListNode listNode1_2(2);
    listNode1_1.next = &listNode1_2;
    ListNode listNode1_3(3);
    listNode1_2.next = &listNode1_3;
    ListNode listNode1_4(4);
    listNode1_3.next = &listNode1_4;
    ListNode listNode1_5(5);
    listNode1_4.next = &listNode1_5;

    ListNode listNode2_1(0);
    ListNode listNode2_2(6);
    listNode2_1.next = &listNode2_2;
    ListNode listNode2_3(7);
    listNode2_2.next = &listNode2_3;
    ListNode listNode2_4(8);
    listNode2_3.next = &listNode2_4;
    ListNode listNode2_5(9);
    listNode2_4.next = &listNode2_5;

    Solution mytest;
    mytest.mergeTwoLists(&listNode2_1,&listNode1_1);
    return 0;
}