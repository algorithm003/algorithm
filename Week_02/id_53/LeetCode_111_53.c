/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 * 返回它的最小深度  2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */


/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

# include <stdio.h>
# include <stdlib.h>
# include <assert.h>


typedef struct TreeNode* elementType;

typedef struct node {
    elementType e;
    struct node *next;
} Node;

typedef struct Queue {
    int length;
    struct node *head;
    struct node *tail;
} Queue;

Queue* createqueue(void){
    Queue *q = malloc(sizeof(Queue));
    assert(q);
    q->length = 0;
    q->head = q->tail = NULL;
    return q;
}

void enqueue(Queue* q, elementType e){
    Node *np = malloc(sizeof(Node));
    assert(q && np);
    np->e = e;
    np->next = NULL;
    q->tail = q->length <= 0 ? q->head = np : (q->tail->next = np);
    q->length ++;
}

elementType dequeue(Queue *q){
    Node* np;
    elementType e;

    assert( q && q->length > 0 );

    np = q->head;
    e = np->e;
    q->length --;
    q->head = q->length <= 0 ? q->tail = NULL : q->head->next;
    free(np);
    return e;
}


int minDepth(struct TreeNode* root){
    Queue *q = createqueue(), *p = createqueue(), *t;
    int level = 0;
    struct TreeNode *node;
    
    if ( root == NULL ) return level;
    enqueue(p, root);
    while(p->length > 0 || q->length > 0) {
        if (p->length == 0 ) { t = q; q = p; p = t; level++;} 
        node = dequeue(p);
        if ( !node->left && !node->right ) return level+1;
        if (node->left) enqueue(q, node->left);
        if (node->right) enqueue(q, node->right);        
    }
    return level;
}


