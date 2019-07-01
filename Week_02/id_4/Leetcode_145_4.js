// 145. 二叉树的后序遍历 postorderTraversal
// 题意解析：二叉树的后序排列实现，流程是 左-》右-》根.


// 初始思路：模板递归法.
// 思路：用数组res存储结果，递归方法以节点node和结果数组res作为参数.
// 复杂度分析：
//      时间：遍历整个二叉树故时间复杂度为 O(n)
//      空间：结果数组是必备空间所以不占复杂度，占空间的是树的深度h。
//          当树是平衡二叉树时，树高度为logn，故其空间复杂度为O(logn)；
//          当树严重左偏或者右偏的时候，树高度为n，故其空间复杂度为O(n);
// Leetcode 结果:
//      执行用时 : 72 ms, 在所有 JavaScript 提交中击败了93.75 %的用户
//      内存消耗 : 33.7 MB, 在所有 JavaScript 提交中击败31.15%的用户
// 实现:
var preorderTraversal = function(root) {
    if (!root || root===null) return [];        // 在此先做一次节点判空，循环中就不用做节点判空了
    let res = [];
    recursion(root, res);
    return res;
};

function recursion (node, res) {
    // 1. terminator
    //if (!node || node.val===null) return;         // 旧.
    
    // 2. process
    // 3. drill down
    if (node.left !== null) recursion(node.left, res);          // 左
    if (node.right !== null) recursion(node.right, res);        // 右
    res.push(node.val);                                         // 根
    
    // 4. recover
}

// 第二思路: 模板迭代法.Tip: 思路类似递归法。取代"优化迭代法"新晋第二位，原因是能够同模板套用解题
// 思路:用栈辅助存储未处理的值,每个节点加上标志位flag,标志位的作用是标志节点的身份是否为处理完成的节点.
// 复杂度分析:
//      时间: O(n). 耗时点在于每个结点会经历两次遍历(塞入->弹出->标记->塞入->弹出)，也就是时间复杂度是O(2n);
//      空间: O(n). 分析同上.
// Leetcode 结果:
//      执行用时 : 80ms, 在所有 JavaScript 提交中击败了 81.91%的用户
//      内存消耗 : 34.2MB, 在所有 JavaScript 提交中击败 5.74%的用户
// 实现:
var postorderTraversal = function(root) {
    if (!root || root.val === null) return [];
    let res = [];
    let stack = [root];
    while (stack.length > 0) {
        let node = stack.pop();
        if (node.flag) {
            res.push(node.val);
        } else {
            // 后序顺序：左-》右-》根
            // 入栈顺序：根-》右-》左
            //   先标记后入栈
            node.flag = true;
            stack.push(node);
            if (node.right) stack.push(node.right);
            if (node.left) stack.push(node.left);
        }
    }
    return res;
};

// 第三思路：类前序迭代法。
// 初始思路：通过判断左右子树是否空来实现，但是存在判断上的问题(除非改变树内容)，所以先看答案了.
// 简易思路：后序顺序为:左-右-根，其入栈顺序为: 根-右-左，和前序相近，用前序方式实现并将结果反转即可.
// 复杂度（同前序的迭代法）：
//      时间：O(n). while 循环N次弹值，故 O(n) + 反转复杂度 O(n)
//      空间：O(n). 结果数组是必备空间所以不占复杂度，占空间的是栈的大小
//          当树是平衡二叉树时，正常情况存2取1，故 O(n/2)
//          当树严重左偏或者右偏时，存1取1，故O(1)
// Leetcode 结果：
//      执行用时 : 68 ms, 在所有 JavaScript 提交中击败了96.79%的用户
//      内存消耗 : 33.9 MB, 在所有 JavaScript 提交中击败了9.84%的用户
// 实现：
var postorderTraversal = function(root) {
    if (!root || root.val === null) return [];
    let res = [];
    let stack = [];
    stack.push(root);
    
    while (stack.length>0) {
        let node = stack.pop();
        if (node.left) stack.push(node.left);
        if (node.right) stack.push(node.right);
        res.push(node.val);
    }
    
    return res.reverse();
};