class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        ListNode *sentinal = new ListNode(0);
        sentinal->next = head;
        
        ListNode *p = sentinal;
        do {
            p = swapNextTwoNodes(p);
        } while(p);
        
        return sentinal->next;
    }
    
    ListNode* swapNextTwoNodes(ListNode *head) {
        if (head == NULL || 
            head->next == NULL || 
            head->next->next == NULL)
            return NULL;
        
        ListNode *next = head->next;
        ListNode *nnext = next->next;
        head->next = nnext;
        next->next = nnext->next;
        nnext->next = next;
        return next;
    }
};
