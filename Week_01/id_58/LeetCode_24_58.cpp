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
//    ListNode* swapPairs(ListNode* head) {
////         ListNode* d = new ListNode(-1);
////         d -> next = head;
////         ListNode* pre = d;
////         while (pre -> next && pre -> next -> next){
////             ListNode* t = pre -> next -> next;
////             pre -> next -> next = t -> next;
//            
////             t -> next = pre -> next;
////             pre -> next = t;
//            
////             pre = t -> next;
////         }
//        
////         return d -> next;
////     }
//        
//        if (!head || !head -> next)
//            return head;
//        
//        ListNode* t = head -> next;
//        head -> next = swapPairs(t -> next);
//        t -> next = head;
//        
//        return t;
//    }
//};