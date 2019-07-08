// 144. 二叉树的前序遍历 preorderTraversal
// 题意解析：二叉树的前序排列实现，流程是 根-》左-》右.


// 初始思路：模板递归法.
// 思路：用数组res存储结果，递归方法以节点node和结果数组res作为参数.
// 复杂度分析：
//    时间：左右子树各O(n/2) + 根节点O(1) = O(n)
//    空间：结果数组是必备空间所以不占复杂度，占空间的是树的深度h。
//        当树类似满二叉树时，树高度为logn，故其空间复杂度为O(logn)；
//        当树是斜树的时候，树高度为n，故其空间复杂度为O(n);
// Leetcode 结果: 执行用时 :
//    执行用时 : 64 ms, 在所有 JavaScript 提交中击败了98.77%的用户
//    内存消耗 : 34.1 MB, 在所有 JavaScript 提交中击败5.18%的用户
// 实现(新):
var preorderTraversal = function(root) {
  if (!root || root.val===null) return [];     // 在此先做一次节点判空，循环中就不用做节点判空了
  let res = [];
  recursion(root, res);
  return res;
};

function recursion (node, res) {
  // 1. terminator
  //if (!node || node.val===null) return;         // 旧.

  // 2. process
  res.push(node.val);                                         // 根

  // 3. drill down                                            
  if (node.left !== null) recursion(node.left, res);          // 左
  if (node.right !== null) recursion(node.right, res);        // 右
  
  // 4.  recover
}


// 第二思路: 模板迭代法.Tip: 思路类似递归法。取代"优化迭代法"新晋第二位，原因是能够同模板套用解题
// 思路: 用栈辅助存储未处理的值,每个节点加上标志位flag,标志位的作用是标志节点的身份是否为处理完成的节点.
// 复杂度分析:
//    时间: O(n). 耗时点在于每个结点会经历两次遍历(塞入->弹出->标记->塞入->弹出)，也就是时间复杂度是O(2n);
//    空间: O(n). 分析同上.
// Leetcode 结果:
//    执行用时 : 72ms, 在所有 JavaScript 提交中击败了 96.30%的用户
//    内存消耗 : 34.1MB, 在所有 JavaScript 提交中击败 5.18%的用户
// 实现:
var preorderTraversal = function(root) {
  if (!root || root.val===null) return [];
  let res = [];
  let stack = [root];
  while (stack.length>0) {
    let node = stack.pop();
    if (node.flag) {    // flag=true 表示这次要访问的是该节点，可以打印或者做其他处理
      res.push(node.val);
    } else {            // flag=false 表示暂时没空访问该节点，只能先将其入栈等待之后处理
      // 前序顺序：根-》左-》右
      // 进栈顺序：右-》左-》根
      if (node.right) stack.push(node.right);
      if (node.left) stack.push(node.left);
      // 先标记后压栈
      node.flag = true;
      stack.push(node);
    }
  }
  return res;
};

// 优化迭代法
// 思路：由第二思路的"模板迭代法"所衍生的写法，通过将两次遍历节点的过程改为一次遍历，有效将时间复杂度O(2n)降到O(n).同时由于不使用标志位及减少了压栈次数，故空间复杂度也得到了优化.
// 复杂度分析：
//    时间：O(n).耗时点在于每个结点会经历一次遍历(塞入->弹出)，也就是时间复杂度是O(n);
//    空间：O(n).分析同上.
// Leetcode 结果：
//    执行用时 :68 ms, 在所有 JavaScript 提交中击败了97.78%的用户
//    内存消耗 :33.6 MB, 在所有 JavaScript 提交中击败了51.30%的用户
// 实现：
var preorderTraversal = function(root) {
  if (!root || root.val === null) return [];
  let stack = [];
  let res = [];
  stack.push(root);
  while (stack.length !== 0) {
    let node = stack.pop();
    // 前序顺序：根-》左-》右
    // 进栈顺序：右-》左-》根
    // 优化思路：
    //  不同于"模板迭代法的两次遍历(塞入->弹出->标记->塞入->弹出)"
    //  根据先序遍历的特性"根节点先处理"，将流程变成每个节点仅需一次遍历(塞入-》弹出)，
    //  并将剩下的左右子树根据"进栈顺序：右-》左"执行进栈
    // 由于不用标志位并且减少了压栈次数，故空间复杂度成功也被优化；

    res.push(node.val);     // 直接处理然后输出，括号内位置任意不影响
    if (node.right) stack.push(node.right);
    if (node.left) stack.push(node.left);
  }
  return res;
};