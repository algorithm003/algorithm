# tree 树专题

## 零、基础知识

### 1. 树的基础概念

- 树，是 n(n>=0) 个结点的有限集合.
    - n=0时,称为**空树**.
    - n>0时,有如下特性：
        - 有且仅有一个特定的被称为根(root)的节点;
        - 当 n>1 时，其余结点可被分成m(m>0)个互不相交的有限集合,每个集合都是一棵树，并且称为根(root)的子树;
- 树的相关概念：
    - 结点的度: 结点所拥有子树的数目;
    - 结点关系: 
        - 孩子结点: 某结点子树的根节点;
        - 双亲结点: 某结点对于其子树;
        - 兄弟结点: 同一个双亲结点的孩子结点们;
        - 叶子结点: 没有左子树和右子树的结点;
    - 结点层次:
        - 根: 第一层;
        - 根的孩子们: 第二层到第N层;
    - 树的深度: 最大层次数;

### 2. 二叉树 Binary Tree

- 二叉树，是 n(n>=0) 个结点的有限集合.
    - n=0时,称为**空树**.
    - n>0时,由(一个根节点+左子树+右子树)组成.
- 树的类型:
    - 斜树: 所有结点都只有左子树的二叉树叫做左斜树，反之叫做右斜树. 属于一种树-》链表的退化, 在二叉搜索树中斜树遍历的时间复杂度将退化为为O(n).
    - 满二叉树: 所有结点都存在左子树和右子树，且所有叶子结点都在同一层;
        - 特点:
            1).叶子结点只能在最下层;
            2).非叶子结点的度一定是2;
            3).同样深度的二叉树中，满二叉树的结点个数最多.
    - 完全二叉树: 参考满二叉树，如果一个同样高度的数，按层编号的结果与满二叉树完全相同，则该树为完全二叉树.
        - 特点:
            1).叶子结点只能在最下层&次下层;
            2).最下层的结点集中在树的左部;
            3).次下层如果存在叶子结点,一定在右部连续位置;
            4).如果树中某结点的度为1, 则该结点只有左孩子;
            5).同样结点数量的二叉树, 完全二叉树深度最小;
        - Tip: 满二叉树必为完全二叉树, 反之不一定成立;
        - TODO: 了解应用场景;

### 3. 二叉搜索树 Binary Search Tree

- 二叉搜索树，基础性质同**二叉树**.
- 二叉搜索树定义:
    - 左子树上的**所有结点**的值均小于它的根结点的值;
    - 右子树上的**所有结点**的值均大于它的根结点的值;
    - Recursively, 左、右结点也分别为二叉搜索树;

## 一、Leetcode 刷题

### 144. 二叉树的前序遍历 preorderTraversal
- 刷题进度:
    - [x] 模板递归法解答(四步解题)
    - [x] 模板迭代法解答
    - [x] 优化迭代法
    - [ ] Leetcode其他解法学习
- 难度：medium
- 题意解析：二叉树的前序排列实现，流程是 根-》左-》右.
- 初始思路：模板递归法.
    - 思路：用数组res存储结果，递归方法以节点node和结果数组res作为参数.
    - 复杂度分析：
        - 时间：左右子树各O(n/2) + 根节点O(1) = O(n)
        - 空间：结果数组是必备空间所以不占复杂度，占空间的是树的深度h。
            - 当树类似满二叉树时，树高度为logn，故其空间复杂度为O(logn)；
            - 当树是斜树的时候，树高度为n，故其空间复杂度为O(n);
    - Leetcode 结果:
    执行用时 :
        - 执行用时 : 64 ms, 在所有 JavaScript 提交中击败了98.77%的用户
        - 内存消耗 : 34.1 MB, 在所有 JavaScript 提交中击败5.18%的用户
    - 实现(新):
        ``` js
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
        ```
- 第二思路: 模板迭代法.**Tip: 思路类似递归法。取代"优化迭代法"新晋第二位，原因是能够同模板套用解题**
    - 思路: 用栈辅助存储未处理的值,每个节点加上标志位flag,标志位的作用是标志节点的身份是否为处理完成的节点.
    - 复杂度分析:
        - 时间: O(n). 耗时点在于每个结点会经历两次遍历(塞入->弹出->标记->塞入->弹出)，也就是时间复杂度是O(2n);
        - 空间: O(n). 分析同上.
    - Leetcode 结果:
        - 执行用时 : 72ms, 在所有 JavaScript 提交中击败了  96.30%的用户
        - 内存消耗 : 34.1MB, 在所有 JavaScript 提交中击败  5.18%的用户
    - 实现:
        ``` js
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
        ```
- 第三思路：优化迭代法
    - 思路：由第二思路的"模板迭代法"所衍生的写法，通过将两次遍历节点的过程改为一次遍历，有效将时间复杂度O(2n)降到O(n).同时由于不使用标志位及减少了压栈次数，故空间复杂度也得到了优化.
    - 复杂度分析：
        - 时间：O(n).耗时点在于每个结点会经历一次遍历(塞入->弹出)，也就是时间复杂度是O(n);
        - 空间：O(n).分析同上.
    - Leetcode 结果：
        - 执行用时 :68 ms, 在所有 JavaScript 提交中击败了97.78%的用户
        - 内存消耗 :33.6 MB, 在所有 JavaScript 提交中击败了51.30%的用户
    - 实现：
        ``` js
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
        ```


### 94. 二叉树的中序遍历 inorderTraversal
- 刷题进度:
    - [x] 模板递归法解答(四步解题)
    - [x] 模板迭代法解答
    - [ ] Leetcode其他解法学习
- 难度：medium
- 题意解析：二叉树的中序排列实现，流程是 左-》根-》右.
- 初始思路：模板递归法.
    - 思路：用数组res存储结果，递归方法以节点node和结果数组res作为参数.
    - 复杂度分析：
        - 时间：遍历整个二叉树故时间复杂度为 O(n)
        - 空间：结果数组是必备空间所以不占复杂度，占空间的是树的深度h
            - 当树是平衡二叉树时，树高度为logn，故其空间复杂度为O(logn)；
            - 当树严重左偏或者右偏的时候，树高度为n，故其空间复杂度为O(n);
    - Leetcode 结果:
        - 执行用时 : 60 ms, 在所有 JavaScript 提交中击败了99.84%的用户
        - 内存消耗 : 34 MB, 在所有 JavaScript 提交中击败6.34%的用户
    - 实现:
        ``` js
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
        ```
- 第二思路: 模板迭代法.**Tip: 思路类似递归法。取代"优化迭代法"新晋第二位，原因是能够同模板套用解题**
    - 思路: 用栈辅助存储未处理的值,每个节点加上标志位flag,标志位的作用是标志节点的身份是否为处理完成的节点.
    - 复杂度分析:
        - 时间: O(n). 耗时点在于每个结点会经历两次遍历(塞入->弹出->标记->塞入->弹出)，也就是时间复杂度是O(2n);
        - 空间: O(n). 分析同上. 
    - Leetcode 结果:
        - 执行用时 : 84ms, 在所有 JavaScript 提交中击败了  78.76%的用户
        - 内存消耗 : 33.4MB, 在所有 JavaScript 提交中击败  93.28%的用户
    - 实现:
        ``` js
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
        ```
- 第三思路：迭代法（仿递归思路）.
    - 思路：不断检测当前节点是否空
        - false: 继续对深度搜索左子树(同时插入栈)，直到为空。之后弹出栈最后一个节点，存值到res，并由其右子树开始继续深度搜索左子树。
        - true: 弹出栈最后一个节点，存值到res，并由其右子树开始继续深度搜索左子树。
        - 由上可得，终止条件是 "当前节点为空" && "栈.length===0"
    - 复杂度分析：
        - 时间：执行次数等同于树节点个数，故 O(n)
        - 空间：结果数组是必备空间所以不占复杂度，占空间的是栈的大小
            - 当树是平衡二叉树时，正常情况存2取1，故 O(n/2)
            - 当树严重左偏时，全存再取，故O(n)
            - 当树严重右偏时，存1取1，故O(1)
    - Leetcode 结果：
        - 执行用时 :88 ms, 在所有 JavaScript 提交中击败了73.33%的用户
        - 内存消耗 :33.5 MB, 在所有 JavaScript 提交中击败了86.94%的用户
    - 实现：
        ``` js
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
        ```

### 145. 二叉树的后序遍历 postorderTraversal
- 刷题进度:
    - [x] 模板递归法解答(四步解题)
    - [x] 模板迭代法解答
    - [ ] Leetcode其他解法学习
- 难度：hard
- 题意解析：二叉树的后序排列实现，流程是 左-》右-》根.
- 初始思路：模板递归法.
    - 思路：用数组res存储结果，递归方法以节点node和结果数组res作为参数.
    - 复杂度分析：
        - 时间：遍历整个二叉树故时间复杂度为 O(n)
        - 空间：结果数组是必备空间所以不占复杂度，占空间的是树的深度h。
            - 当树是平衡二叉树时，树高度为logn，故其空间复杂度为O(logn)；
            - 当树严重左偏或者右偏的时候，树高度为n，故其空间复杂度为O(n);
    - Leetcode 结果:
        - 执行用时 : 72 ms, 在所有 JavaScript 提交中击败了93.75 %的用户
        - 内存消耗 : 33.7 MB, 在所有 JavaScript 提交中击败31.15%的用户
    - 实现:
        ``` js
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
        ```
- 第二思路: 模板迭代法.**Tip: 思路类似递归法。取代"优化迭代法"新晋第二位，原因是能够同模板套用解题**
    - 思路:用栈辅助存储未处理的值,每个节点加上标志位flag,标志位的作用是标志节点的身份是否为处理完成的节点.
    - 复杂度分析:
        - 时间: O(n). 耗时点在于每个结点会经历两次遍历(塞入->弹出->标记->塞入->弹出)，也就是时间复杂度是O(2n);
        - 空间: O(n). 分析同上.
    - Leetcode 结果:
        - 执行用时 : 80ms, 在所有 JavaScript 提交中击败了  81.91%的用户
        - 内存消耗 : 34.2MB, 在所有 JavaScript 提交中击败  5.74%的用户
    - 实现:
        ``` js
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
        ```
- 第三思路：类前序迭代法。
    - 初始思路：通过判断左右子树是否空来实现，但是存在判断上的问题(除非改变树内容)，所以先看答案了.
    - 简易思路：后序顺序为:左-右-根，其入栈顺序为: 根-右-左，和前序相近，用前序方式实现并将结果反转即可.
        - 复杂度（同前序的迭代法）：
            - 时间：O(n). while 循环N次弹值，故 O(n) + 反转复杂度 O(n)
            - 空间：O(n). 结果数组是必备空间所以不占复杂度，占空间的是栈的大小
                - 当树是平衡二叉树时，正常情况存2取1，故 O(n/2)
                - 当树严重左偏或者右偏时，存1取1，故O(1)
        - Leetcode 结果：
            - 执行用时 : 68 ms, 在所有 JavaScript 提交中击败了96.79%的用户
            - 内存消耗 : 33.9 MB, 在所有 JavaScript 提交中击败了9.84%的用户
        - 实现：
            ``` js
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
            ```

### 102. 二叉树的层次遍历 levelOrder
- 刷题进度:
    - [x] 模板递归法解答(四步解题)
    - [x] 模板迭代法解答
    - [ ] Leetcode其他解法学习
- 难度: medium
- 题意解析: 自顶向下逐层遍历并放入数组
- 初始思路: 递归法. 
    - 思路: 每层加上level做标记。某level第一次出现创建数组并插入res, 同level数值放入同一数组。
    - 复杂度:
        - 时间: 等同二叉树节点个数，故为 O(n)
        - 空间: 正常情况压二弹一，故为 O(n/2)
    - Leetcode 结果:
        - 执行用时 : 76ms, 在所有 JavaScript 提交中击败了 15.89%的用户
        - 内存消耗 : 34.7MB, 在所有 JavaScript 提交中击败  45.77%的用户
    - 实现:
        ``` js
        var levelOrder = function(root) {
            if (!root || root.val===null) return [];    // 上提到这里，递归方法中无需再做处理
            let res = [];
            recursion(0, root, res);
            return res;
        }

        function recursion (level, node, res) {
            // 1. terminate

            // 2. process
            if (!res[level]) res[level] = [];
            res[level].push(node.val);
            // 3. drill down
            if (node.left) { recursion(level+1, node.left, res); }
            if (node.right) { recursion(level+1, node.right, res); }
            // 4. recover
        }
        ```
- 第二思路: 模板状态迭代法
    - 思路: 给节点加上level开始迭代.
    - 复杂度分析:
        - 时间: O(n). 
        - 空间: O(n). 
    - Leetcode 结果:
        - 执行用时 : 88ms, 在所有 JavaScript 提交中击败了  76.21%的用户
        - 内存消耗 : 35.3 MB, 在所有 JavaScript 提交中击败  5.47%的用户
    - 实现:
        ``` js
        var levelOrder = function(root) {
            if (!root || root.val===null) return [];
            let res = [];
            root.level = 0;
            let stack = [root];
            while (stack.length > 0) {
                let node = stack.pop();
                let level = node.level;
                if (!res[level]) res[level] = [];
                res[level].push(node.val);
                if (node.right) {
                    node.right.level = level + 1;
                    stack.push(node.right);
                }
                if (node.left) {
                    node.left.level = level + 1;
                    stack.push(node.left);
                }
            }
            return res;
        }
        ```
- 第三思路: 迭代法
    - 思路: 创建res、queue、level. 提前将root塞进queue，以queue>0为条件开始循环. 先向res加入[]，然后再以queue长度为次数循环加 res 和 queue.
    - 复杂度分析:
        - 时间: 满二叉树下while循环logn次，for循环次数分别为1, 2, 4..., 综合时间复杂度为O(n)
        - 空间: 满二叉树情况下为约为O(n/2)，即最底层长度.
    - Leetcode 结果:
        - 执行用时 : 80ms, 在所有 JavaScript 提交中击败了  92.80%的用户
        - 内存消耗 : 34.6MB, 在所有 JavaScript 提交中击败  73.13%的用户
    - 实现:
        ``` js
        var levelOrder = function(root) {
            if (!root || root.val===null) return [];
            let res = [];
            let queue = [];
            let level = 0;
            queue.push(root);
            
            // 1. terminate
            while (queue.length > 0) {
                res[level] = [];
                // 2.process
                for (let i=0, len=queue.length; i<len; i++) {
                    let node = queue.shift();
                    res[level].push(node.val);
                    // 3. drill down
                    if (node.left) { queue.push(node.left) } 
                    if (node.right) { queue.push(node.right); }
                }
                level++;
            }
            return res;
        }
        ```

### 226. 翻转二叉树 invertTree
- 刷题进度:
    - [x] 递归法(DFS).
    - [x] 迭代法(DFS).
    - [ ] xxx
- 难度: easy
- 题意解析: 依次调换刷题进度树的所有左子树和右子树.
- 初始思路: 自递归法(DFS).
    - 思路: 以单个node为参数开始递归，左右节点直接交换，如果左右非空则继续递归.
    - 复杂度分析:
        - 时间: O(n). 所有节点都遍历过一次.
        - 空间: O(n). 消耗空间的是被放在堆上的递归函数调用，最坏情况时树高O(h)的函数调用将被放在堆上, h最好=logn,h最坏=n.
    - Leetcode 结果:
        - 执行用时 : 64ms, 在所有 JavaScript 提交中击败了  99.23%的用户
        - 内存消耗 : 34.4MB, 在所有 JavaScript 提交中击败  5.92%的用户
    - 实现:
        ``` js
        var invertTree = function(root) {
            // 1. terminate
            if (!root) return root;
            
            // 2. process
            [root.left, root.right] = [root.right, root.left];
            
            // 3. drill down
            if (root.left) invertTree(root.left);
            if (root.right) invertTree(root.right);
            
            // 4. recover
            
            return root;
        };
        ```
- 第二思路: 迭代法(DFS).
    - 思路: 思路基本同上，初始压栈 -》循环（弹栈-左右交换-左右压栈）-》返回
    - 复杂度分析:
        - 时间: O(n). 树的节点数.
        - 空间: O(n). 空间复杂度为高度O(h),满二叉树时 h=logn, 严重偏左偏右时 h=n
    - Leetcode 结果:
        - 执行用时 : 72ms, 在所有 JavaScript 提交中击败了  95.38%的用户
        - 内存消耗 : 33.5 MB, 在所有 JavaScript 提交中击败  82.84%的用户
    - 实现:
        ``` js
        var invertTree = function(root) {
            if (!root) return root;
            let stack = [root];
            // 1. terminate
            while (stack.length>0) {
                // 2. process
                let node = stack.pop();
                [node.left, node.right] = [node.right, node.left];
                // 3. drill down
                if (node.right) stack.push(node.right);
                if (node.left) stack.push(node.left);
                // 4. recover
            }
            return root;
        }
        ```

###  104. 二叉树最大深度 maxDepth
- 刷题进度:
    - [x] 递归法(DFS).
    - [x] 迭代法(DFS)
    - [ ] xxx
- 难度: easy
- 题意解析: 计算**根节点**到**最远叶子节点**的**最长路径**上的**节点数**.
- 初始思路: 自递归法(DFS).
    - 思路: 最大深度即 1+root左右子树的最大深度，开始递归.
    - 复杂度分析:
        - 时间: O(n). 同节点数n.
        - 空间: O(n). 递归调用次数，树平衡时最好，为O(logn)；树退化成链表时最坏O，为(n).
    - Leetcode 结果:
        - 执行用时 : 92ms, 在所有 JavaScript 提交中击败了 89.09%的用户
        - 内存消耗 : 37.2MB, 在所有 JavaScript 提交中击败 39.17%的用户
    - 实现:
        ``` js
        var maxDepth = function(root) {
            if (!root || root.val===null) return 0;
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        };
        ```
- 第二思路: 迭代法(DFS)
    - 思路: 用栈存储{node: node, level: level}对象, 
    - 复杂度分析:
        - 时间: O(N).
        - 空间: O(N).
    - Leetcode 结果:
        - 执行用时 : 108ms, 在所有 JavaScript 提交中击败了 56.60%的用户
        - 内存消耗 : 37.4MB, 在所有 JavaScript 提交中击败 11.96%的用户
    - 实现:
        ``` js
        var maxDepth = function(root) {
            if (!root) return 0;
            let res = 1;
            root.level = 1;
            let stack = [root];
            while (stack.length > 0) {
                let node = stack.pop();
                let level = node.level;
                res = Math.max(res, level);
                if (node.right) {
                    node.right.level = level + 1;
                    stack.push(node.right);
                }
                if (node.left) {
                    node.left.level = level + 1;
                    stack.push(node.left);
                }
            }
            return res;
        };
        ```

### 111. 二叉树最小深度 minDepth
- 刷题进度:
    - [x] 迭代法
    - [x] 递归法
- 难度: easy
- 题意解析: 计算**根节点**到**最近叶子节点**的**最短路径**上的**节点数**.
- 二次读题: 注意说明**"叶子节点是指没有子节点的节点"**.
- 初始思路: 递归法.
    - 思路: 自递归。思路和二叉树最大深度一样。
    - **遇到问题**: Leetcode刷题者普遍遇到的问题。
        ![问题](img/二叉树最小深度问题.png)
        由题意可知"最小深度是**从根节点到最近叶子节点**的最短路径上的节点数量"，并且题目中有说明"叶子节点是指没有子节点的节点", 所以问题出自没有好好看题。
    - 复杂度分析:
        - 时间: O(n). 同节点数n.
        - 空间: O(n). 最好O(logn), 最坏O(n).
    - Leetcode 结果:
        - 执行用时 : 96ms, 在所有 JavaScript 提交中击败了  85.52%的用户
        - 内存消耗 : 37.5MB, 在所有 JavaScript 提交中击败  24.69%的用户
    - 实现:
        ``` js
        var minDepth = function(root) {
            if (!root || root.val===null) return 0;
            let [left, right] = [minDepth(root.left), minDepth(root.right)];
            return left&&right? 1+Math.min(left, right): 1+left+right;
        };
        ```
- 第二思路: 迭代法.
    - 思路: 每个节点加入 level 属性，向下查找所有叶子节点（即左右子树为空）,对比并返回最小 level.
    - 复杂度分析:
        - 时间: O(n). 遍历树所有节点即 n.
        - 空间: O(n). 最好 logn，最坏 n.
    - Leetcode 结果:
        - 执行用时 : 92ms, 在所有 JavaScript 提交中击败了  91.36%的用户
        - 内存消耗 : 37.9MB, 在所有 JavaScript 提交中击败  5.55%的用户
    - 实现:
        ``` js
        var minDepth = function(root) {
            if (!root || root.val===null) return 0;
            let res = Number.POSITIVE_INFINITY;
            root.level = 1;
            let stack = [root];
            while (stack.length > 0) {
                let node = stack.pop();
                let level = node.level;
                if (node.left || node.right) {
                    if (node.right) { 
                        node.right.level = level + 1;
                        stack.push(node.right); 
                    }
                    if (node.left) {
                        node.left.level = level + 1;
                        stack.push(node.left); 
                    }
                } else {
                    res = Math.min(res, level);
                }
            }
            return res;
        };
        ```



### 98. 验证二叉搜索树 isValidBST
- 刷题进度:
    - [x] 中序遍历递归
    - [ ] 中序遍历迭代
    - [ ] xxx
- 难度: medium
- 题意解析: 给一个棵树，通过验证其三个特征来判断这是否是一颗二叉树.
- 初始思路: 中序遍历递归.
    - 思路: 利用中序遍历递增的特性，依次对比前后元素即可. 这个思路比较难想，需要先下钻到最左然后开始验证每个结点.
    - 复杂度分析:
        - 时间: O(n)
        - 空间: O(n). 最好O(logn),最坏O(n).
    - Leetcode 结果:
        - 执行用时 : 84ms, 在所有 JavaScript 提交中击败了  99.18%的用户
        - 内存消耗 : 37.4MB, 在所有 JavaScript 提交中击败  57.23%的用户
    - 实现:
        ``` js
        var isValidBST = function(root) {
            // 空树也是二叉搜索树
            if (!root) return true;
            let arr = [Number.NEGATIVE_INFINITY];
            return recursion(root, arr);
        };

        function recursion (node, arr) {
            // 1. terminate
            if (!node) return true;
            
            // 2. process
            // 3. drill down
            //   DFS 到最左，开始验证，保证每个节点都是：
            //      先左子树过，再根节点过，接下来右子树过，获取右边最大值
            if (recursion(node.left, arr)) {
                if (arr[0] < node.val) {
                    arr[0] = node.val
                    return recursion(node.right, arr)
                }
            }
            return false;       // 对比失败，非二叉搜索树
            
            // 4. recover
        }
        ```
- 第二思路:
    - 思路:
    - 复杂度分析:
        - 时间: 
        - 空间: 
    - Leetcode 结果:
        - 执行用时 : ms, 在所有 JavaScript 提交中击败了  %的用户
        - 内存消耗 : MB, 在所有 JavaScript 提交中击败  %的用户
    - 实现:
        ``` js
        ```


### 236. 二叉树的最近公共祖先 lowestCommonAncestor
- 刷题进度:
    - [x] 递归法.
    - [ ] xxx
    - [ ] xxx
- 难度: medium
- 题意解析: 获取两个结点在一棵二叉树中的父节点. 前提: 两个结点都存在于给定的树中.
- 初始思路: 递归法.
    - 思路: 递归
    - 复杂度分析:
        - 时间: O(N)，最好 O(1), 最坏 O(N)
        - 空间: O(N)，最好 O(1), 最坏 O(N)
    - Leetcode 结果:
        - 执行用时 : 80ms, 在所有 JavaScript 提交中击败了  100%的用户
        - 内存消耗 : 41.5MB, 在所有 JavaScript 提交中击败  34.56%的用户
    - 实现:
        ``` js
        var lowestCommonAncestor = function(root, p, q) {
            // 1. terminate
            if (!root || root.val===p.val || root.val===q.val) return root;
            
            // 3. drill down
            let left = lowestCommonAncestor(root.left, p, q);
            let right = lowestCommonAncestor(root.right, p, q);
            
            // 2. process
            if (left != null && right != null) {
                return root;
            } else if (left != null) {
                return left;
            } else if (right != null){
                return right;
            }
            return null;
        };
        ```
- 第二思路:
    - 思路:
    - 复杂度分析:
        - 时间: 
        - 空间: 
    - Leetcode 结果:
        - 执行用时 : ms, 在所有 JavaScript 提交中击败了  %的用户
        - 内存消耗 : MB, 在所有 JavaScript 提交中击败  %的用户
    - 实现:
        ``` js
        ```

### 429. N叉树的层序遍历
- 刷题进度:
    - [x] 递归法(DFS).
    - [x] 迭代法(DFS).
    - [x] 递归法(BFS).
    - [x] 迭代法(BFS).
- 难度: easy
- 题意解析: 类似 102.
- 初始思路: 递归法(DFS).
    - 思路: 用 level 记层级，用 res 存储结果.
    - 复杂度分析:
        - 时间: O(n). 遍历所有故 O(n).
        - 空间: O(n). O(logn)->O(n).
    - Leetcode 结果:
        - 执行用时 : 964ms, 在所有 JavaScript 提交中击败了  85.21%的用户
        - 内存消耗 : 86.2MB, 在所有 JavaScript 提交中击败  19.74%的用户
    - 实现:
        ``` js
        var levelOrder = function(root) {
            if (!root) return [];
            let level = 0;
            let res = [];
            recursion(level, root, res);
            return res;
        };

        function recursion (level, node, res) {
            // 1. terminate
            
            // 2. process
            if (!res[level]) res[level] = [];
            res[level].push(node.val);
            if (!node.children || node.children.length===0) return;
            
            // 3. drill down 
            for (let i=0, len = node.children.length; i<len; i++) {
                recursion(level+1, node.children[i], res);
            }
            
            // 4. recover
        }
        ```
- 第二思路: 迭代法(DFS).
    - 思路: node 加上 level 标志，用 stack 存储未处理节点；
    - 复杂度分析:
        - 时间: O(n). 遍历所有故 O(n).
        - 空间: O(n). O(logn)->O(n).
    - Leetcode 结果:
        - 执行用时 : 928ms, 在所有 JavaScript 提交中击败了  92.25%的用户
        - 内存消耗 : 81.6MB, 在所有 JavaScript 提交中击败  38.16%的用户
    - 实现:
        ``` js
        var levelOrder = function(root) {
            if (!root) return [];
            root.level = 0;
            let stack = [root];
            let res = [];
            // 1. terminate
            while (stack.length > 0) {
                // 2. process
                let node = stack.pop();
                let currLevel = node.level;
                if (!res[currLevel]) res[currLevel] = [];
                res[currLevel].push(node.val);
                
                // 3. drill down
                if (!node.children || node.children.length===0) continue;
                let childLen = node.children.length;
                for (let i=childLen-1; i>=0; i--) {
                    if (node.children[i]) {
                        node.children[i].level = currLevel + 1;
                        stack.push(node.children[i]);
                    }
                }
                
                // 4. recover
            } 
            return res;
        };
        ```
- 第三思路: 递归法(BFS).
    - 思路: 传递 level、queue、res 来递归, 一层处理完递归处理下一层.
    - 复杂度分析:
        - 时间: O(n). 遍历所有故 O(n).
        - 空间: O(n). O(logn)->O(n).
    - Leetcode 结果:
        - 执行用时 : 888 ms, 在所有 JavaScript 提交中击败了 98.59 %的用户
        - 内存消耗 : 77.5 MB, 在所有 JavaScript 提交中击败 81.58%的用户
    - 实现:
        ``` js
        var levelOrder = function(root) {
            if (!root) return [];
            let res = [];
            let queue = [root];
            recursion (0, queue, res);
            return res;
        };


        function recursion (level, queue, res) {
            // 1. terminate
            if (queue.length===0) return;
            
            // 2. process
            res[level] = [];
            for (let i=0, len=queue.length; i<len; i++) {
                let node = queue.shift();
                res[level].push(node.val);
                if (!node.children || node.children.length===0) continue;
                for (let j=0, cLen=node.children.length; j<cLen; j++) {
                    queue.push(node.children[j]);
                }
            }
            
            // 3. drill down
            recursion(level+1, queue, res);
        }
        ```
- 第四思路: 迭代法(BFS).
    - 思路: 每次处理一层，并用 queue 存储下一层节点.
    - 复杂度分析:
        - 时间: O(n). 遍历所有故 O(n).
        - 空间: O(n). O(logn)->O(n).
    - Leetcode 结果:
        - 执行用时 : 924 ms, 在所有 JavaScript 提交中击败了 94.37%的用户
        - 内存消耗 : 80.5 MB, 在所有 JavaScript 提交中击败  59.21%的用户
    - 实现:
        ``` js
        var levelOrder = function(root) {
            if (!root) return [];
            let level = 0;
            let res = [];
            let queue = [root];
            // 1. termimate
            while (queue.length > 0) {
                res[level] = [];
                for (let i=0, len=queue.length; i<len; i++) {
                    // 2. process
                    let node = queue.shift();
                    res[level].push(node.val);
                    // 3. drill down
                    if (!node.children || node.children.length===0) continue;
                    for (let j=0, cLen=node.children.length; j<cLen; j++) {
                        queue.push(node.children[j]);
                    }
                }
                level++;
            }
            return res;
        };
        ```

### 107. 二叉树的层次遍历 II
- 刷题进度:
    - [ ] 102反转结果法 复杂度:102复杂度+反转数组复杂度
    - [ ] 先获取最大深度，再DFS或BFS 复杂度: 104复杂度+102复杂度
    - [ ] 102 递归x迭代(BFSxDFS), 插入数组顺序调整  复杂度：102复杂度


### 103. 二叉树的锯齿形层次遍历
- 刷题进度:
    - [x] 102递归法(BFS).
    - [x] 102迭代法(BFS).
    - [ ] 本题专属套路解法.
- 难度: medium
- 题意解析: 同 102，奇数层反转. **切勿调换插入队列顺序!**.
- 初始思路: 递归法(BFS).
    - 思路: 同 102递归法(BFS).
    - 复杂度分析:
        - 时间: O(n). 遍历所有故 O(n).
        - 空间: O(n). O(logn)->O(n).
    - Leetcode 结果:
        - 执行用时 : 76ms, 在所有 JavaScript 提交中击败了 90.44 %的用户
        - 内存消耗 : 32MB, 在所有 JavaScript 提交中击败 43.75 %的用户
    - 实现:
        ``` js
        function recursion (level, queue, res) {
            // 1. terminate
            if (queue.length === 0) return;
            
            res[level] = [];
            // 2. process
            for (let i=0, len=queue.length; i<len; i++) {
                let node = queue.shift();
                res[level].push(node.val);
                
                if (node.left) queue.push(node.left);
                if (node.right) queue.push(node.right);
            }
            if(level%2===1) res[level].reverse();
            
            // 3. drill down 
            recursion(level+1, queue, res);
            
            // 4. recover
        }
        ```
- 第二思路: 迭代法(BFS).
    - 思路: 同 102迭代法(BFS).
    - 复杂度分析:
        - 时间: O(n). 遍历所有故 O(n).
        - 空间: O(n). O(logn)->O(n).
    - Leetcode 结果:
        - 执行用时 : 68ms, 在所有 JavaScript 提交中击败了  98.53%的用户
        - 内存消耗 : 34.4MB, 在所有 JavaScript 提交中击败  6.25%的用户
    - 实现:
        ``` js
        var zigzagLevelOrder = function(root) {
            if (!root) return [];
            let level = 0;
            let queue = [root];
            let res = [];
            // 1.terminate
            while (queue.length > 0) {
                res[level] = [];
                for (let i=0, len=queue.length; i<len; i++) {
                    // 2. process
                    let node = queue.shift();
                    res[level].push(node.val);
                    // 3.drill down
                    if (node.left) queue.push(node.left);
                    if (node.right) queue.push(node.right);
                    // 4. recover
                }
                if (level%2===1) res[level].reverse();
                level++;
            }
            return res;
        };
        ```

### 529. 扫雷游戏
- 刷题进度:
    - [ ] xxx
    - [ ] xxx
    - [ ] xxx
- 难度: medium.
- 题意解析: 挖地雷. 根据**给定面板数组** & **挖掘位置** 来更新 **结果面板数组**. 点击之后响应如下:
    - 'M'是未挖的地雷，被点击则将其更新为'X';
    - 'E'是未挖的空格，被点击则检查周围格子是否有地雷
        - 有则更新为'1'-'8', 结束;
        - 无则更新为'B', 然后**与其相邻的方块都将被递归地揭露(直到边界 or 周边有)**;
    - 'X'是已挖到的地雷，被点击无反应;
    - '1'-'8'是周围有地雷的格子，被点击无反应;
    - 'B'是被打开的空白格子，被点击无反应;
- 总思路：
    - 'M'打开直接更新为'X'即可;
    - 'E'打开要判断周围,
    - 非'M' & 'E', 直接返回即可;
- 初始思路: 
    - 思路:
    - 复杂度分析:
        - 时间: 
        - 空间: 
    - Leetcode 结果:
        - 执行用时 : ms, 在所有 JavaScript 提交中击败了  %的用户
        - 内存消耗 : MB, 在所有 JavaScript 提交中击败  %的用户
    - 实现:
        ``` js
        ```
- 第二思路:
    - 思路:
    - 复杂度分析:
        - 时间: 
        - 空间: 
    - Leetcode 结果:
        - 执行用时 : ms, 在所有 JavaScript 提交中击败了  %的用户
        - 内存消耗 : MB, 在所有 JavaScript 提交中击败  %的用户
    - 实现:
        ``` js
        ```