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
    	// helper用来辅助取得返回的头部
        ListNode helper(0);
        helper.next = head;
        ListNode * current = &helper;
        while(current->next && current->next->next) { 
            ListNode * n1 = current->next;
            ListNode * n2 = current->next->next;
            
            n1->next = n2->next;
            current->next = n2;
            current->next->next = n1;
            current = current->next->next;
        }
        return helper.next;
    }
};