class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if (l1 == NULL)
            return l2;

        if (l2 == NULL)
            return l1;

        // 简化逻辑
        ListNode *l3 = NULL;
        if (l1->val < l2->val) {
            l3 = l1;
            l1 = l1->next;
        } else {
            l3 = l2;
            l2 = l2->next;
        }

        ListNode *p = l3;
        while (l1 != NULL && l2 != NULL) {
            if (l1->val < l2->val) {
                p->next = l1;
                l1 = l1->next;
            } else {
                p->next = l2;
                l2 = l2->next;
            }
            p = p->next;
        }

// 三木运算符

        if (l1 != NULL)
            p->next = l1;

        if (l2 != NULL)
            p->next = l2;

        return l3;
    }
};
