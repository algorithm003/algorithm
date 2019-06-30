///**
// * Definition for singly-linked list.
// * struct ListNode {
// *     int val;
// *     ListNode *next;
// *     ListNode(int x) : val(x), next(NULL) {}
// * };
// */
//class Solution {
//public:
//    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
////         ListNode* h = new ListNode(-1);
////         ListNode* d = h;
//        
////         while (l1 && l2){
////             if (l1 -> val < l2 -> val){
////                 d -> next = l1;
////                 l1 = l1 -> next;
////             }else {
////                 d -> next = l2;
////                 l2 = l2 -> next;
////             }
//            
////             d = d -> next;
////         }
//        
////         d -> next = l1 ? l1 : l2;
//        
////         return h -> next;
////     }
//        
//        if (!l1) 
//            return l2;
//        if (!l2)
//            return l1;
//        
//        ListNode *small = l1->val < l2->val ? l1 : l2;
//        ListNode *large = l1->val < l2->val ? l2 : l1;
//        small->next = mergeTwoLists(small->next, large);
//        
//        return small;
//    }
//};
//
