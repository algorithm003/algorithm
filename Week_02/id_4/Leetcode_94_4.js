// 94. 二叉树的中序遍历 inorderTraversal
// 题意解析：二叉树的中序排列实现，流程是 左-》根-》右.


// 初始思路：模板递归法.
// 思路：用数组res存储结果，递归方法以节点node和结果数组res作为参数.
// 复杂度分析：
// 时间：遍历整个二叉树故时间复杂度为 O(n)
// 空间：结果数组是必备空间所以不占复杂度，占空间的是树的深度h
//      当树是平衡二叉树时，树高度为logn，故其空间复杂度为O(logn)；
//      当树严重左偏或者右偏的时候，树高度为n，故其空间复杂度为O(n);
// Leetcode 结果:
//      执行用时 : 60 ms, 在所有 JavaScript 提交中击败了99.84%的用户
//      内存消耗 : 34 MB, 在所有 JavaScript 提交中击败6.34%的用户
// 实现:
var inorderTraversal = function(root) {
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
    res.push(node.val);                                         // 根
    if (node.right !== null) recursion(node.right, res);        // 右
    
    // 4. recover
}


// 模板迭代法.Tip: 思路类似递归法。取代"优化迭代法"新晋第二位，原因是能够同模板套用解题
// 思路: 用栈辅助存储未处理的值,每个节点加上标志位flag,标志位的作用是标志节点的身份是否为处理完成的节点.
// 复杂度分析:
//    时间: O(n). 耗时点在于每个结点会经历两次遍历(塞入->弹出->标记->塞入->弹出)，也就是时间复杂度是O(2n);
//    空间: O(n). 分析同上.
// Leetcode 结果:
//    执行用时 : 84ms, 在所有 JavaScript 提交中击败了 78.76%的用户
//    内存消耗 : 33.4MB, 在所有 JavaScript 提交中击败 93.28%的用户
// 实现:
var inorderTraversal = function(root) {
    if (!root || root.val===null) return [];
    let res = [];
    let stack = [root];
    while (stack.length > 0) {
        let node = stack.pop();
        if (node.flag) {    // flag=true 表示这次要访问的是该节点，可以打印或者做其他处理
            res.push(node.val);
        } else {            // flag=false 表示暂时没空访问该节点，只能先将其入栈等待之后处理
            // 中序顺序：左-》根-》右
            // 进栈顺序：右-》根-》左
            if (node.right) stack.push(node.right);
            // 先标记再进栈
            node.flag = true;
            stack.push(node);
            if (node.left) stack.push(node.left);
        }
    }
    return res;
};

// 第三思路：迭代法（仿递归思路）.
// 思路：不断检测当前节点是否空
//    false: 继续对深度搜索左子树(同时插入栈)，直到为空。之后弹出栈最后一个节点，存值到res，并由其右子树开始继续深度搜索左子树。
//    true: 弹出栈最后一个节点，存值到res，并由其右子树开始继续深度搜索左子树。
//    由上可得，终止条件是 "当前节点为空" && "栈.length===0"
// 复杂度分析：
//    时间：执行次数等同于树节点个数，故 O(n)
//    空间：结果数组是必备空间所以不占复杂度，占空间的是栈的大小
//        当树是平衡二叉树时，正常情况存2取1，故 O(n/2)
//        当树严重左偏时，全存再取，故O(n)
//        当树严重右偏时，存1取1，故O(1)
// Leetcode 结果：
//    执行用时 :88 ms, 在所有 JavaScript 提交中击败了73.33%的用户
//    内存消耗 :33.5 MB, 在所有 JavaScript 提交中击败了86.94%的用户
// 实现：
var inorderTraversal = function(root) {
    let res = [];
    let stack = [];
    let curr = root;
    while (curr!=null || stack.length>0) {
        while (curr!=null) {
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        res.push(curr.val);
        curr = curr.right;
    }
    return res;
}