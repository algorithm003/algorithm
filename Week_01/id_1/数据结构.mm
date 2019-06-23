<map version="1.0.1"><node CREATED="1561249085302" ID="ID_root" MODIFIED="1561249085302" TEXT="数据结构"><node CREATED="1561249085302" ID="ID_644eaa5029f8076b7d86" POSITION="right" MODIFIED="1561249085302" TEXT="树与二叉树"><node CREATED="1561249085302" ID="ID_959ea06c9f9162701806" MODIFIED="1561249085302" TEXT="抽象数据类型"></node><node CREATED="1561249085302" ID="ID_1f68306da57a83bebd2a" MODIFIED="1561249085302" TEXT="二叉树"><node CREATED="1561249085302" ID="ID_e84a3fd631dca618fc07" MODIFIED="1561249085302" TEXT="二叉树的性质"><node CREATED="1561249085302" ID="ID_1fdbb1d2338f" MODIFIED="1561249085302" TEXT="二叉树允许只有（左）右子树，而没有左（右）子树"></node><node CREATED="1561249085302" ID="ID_03660ae2d11b" MODIFIED="1561249085302" TEXT="二叉树中第i (i&amp;gt;=0) 层上的节点数最多为2^n"></node><node CREATED="1561249085302" ID="ID_cb6a5bb8a11e" MODIFIED="1561249085302" TEXT="深度为h (h&amp;gt;=1) 的二叉树中最多有 (2^h)-1 个结点"></node><node CREATED="1561249085302" ID="ID_a002677374a4" MODIFIED="1561249085302" TEXT="具有n个结点的完全二叉树，深度为 (log2^) 或者 (log2(n+1))"></node></node><node CREATED="1561249085302" ID="ID_62b3a04076a7d1d85b74" MODIFIED="1561249085302" TEXT="存储结构"><node CREATED="1561249085302" ID="ID_3d93c053669a67152540" MODIFIED="1561249085302" TEXT="顺序存储结构"></node><node CREATED="1561249085302" ID="ID_9ddc06c77ef02cfda5a2" MODIFIED="1561249085302" TEXT="链式存储结构"><node CREATED="1561249085302" ID="ID_39f4d1fa286a" MODIFIED="1561249085302" TEXT="二叉链表"><richcontent TYPE="NOTE"><html><head></head><body><p>左右孩子，结点值</p></body></html></richcontent></node><node CREATED="1561249085302" ID="ID_856809511f6c" MODIFIED="1561249085302" TEXT="三叉链表"><richcontent TYPE="NOTE"><html><head></head><body><p>左右孩子，结点值，双亲结点</p></body></html></richcontent></node></node></node><node CREATED="1561249085302" ID="ID_83fccbd9118d50ab704e" MODIFIED="1561249085302" TEXT="遍历与线索化"><node CREATED="1561249085302" ID="ID_5edafe130a0c" MODIFIED="1561249085302" TEXT="树的层次遍历（BFS）"><richcontent TYPE="NOTE"><html><head></head><body><p>1，初始化一个队列，并把根结点入队列
2，队列元素入队，取得一个结点，访问该结点
3，若该结点的左孩子非空，则将该结点的左子树入队列
4，若该结点的右孩子非空，则将该结点的右子树入队列
5，循环执行2到4，直到队列为空

//层次遍历二叉树的算法（自左向右）非递归

```java
public void levelTraverse() throws Exception {
    BiTreeNode T = root;
    if(T!=null) {
        LinkQueue L =new LinkQueue();//构造队列
        L.offer(T);//根结点入队列
        while(!L.isEmpty()) {
            T = (BiTreeNode)L.poll();
            System.out.println(T.data);//访问结点
            if(T.lchild!=null)//左孩子非空，入队列
                L.offer(T.lchild);
            if(T.rchild!=null)
                L.offer(T.rchild);//右孩子非空，入队列
        }

    }
}

```</p></body></html></richcontent></node><node CREATED="1561249085302" ID="ID_5a37f22e3211" MODIFIED="1561249085302" TEXT="树的深度遍历（DFS）"><node CREATED="1561249085302" ID="ID_c59e31aeb114" MODIFIED="1561249085302" TEXT="先序遍历"><node CREATED="1561249085302" ID="ID_339fafc31830" MODIFIED="1561249085302" TEXT="递归"><richcontent TYPE="NOTE"><html><head></head><body><p>```java
public void D(BiTreeNode T){
    if(T!=null){
        System.out.println(T.data);//访问跟结点
        D(T.lchld);//遍历左子树
        D(T.rchild);//遍历右子树

      }

}
```</p></body></html></richcontent></node><node CREATED="1561249085302" ID="ID_8eaa8e38f64e" MODIFIED="1561249085302" TEXT="非递归"><richcontent TYPE="NOTE"><html><head></head><body><p>1，创建一个栈对象，根结点入栈
2，当栈非空时，将栈顶结点弹出栈内并访问
3，对当前访问结点的非空左孩子结点相继访问，并将当前访问结点的非空右孩子结点压入栈
4，重复执行2,3，直到栈空为止
```java
//先序遍历的非递归算法
public void preRootTraverse() throws Exception {
    BiTreeNode  T= root;
    if(T!=null) {
        LinkStack s = new LinkStack();//构造栈
        s.push(T);//根节点入栈
        while(!s.isEmpty()) { 
            T = (BiTreeNode)s.pop();//移除栈顶元素,并返回其值
            System.out.println(T.data);//访问节点
            while(T!=null) {
                if(T.lchild!=null)//访问左孩子
                    System.out.println(T.lchild.data);//访问节点
                if(T.rchild!=null)//右孩子非空入栈
                    s.push(T.rchild);
                T = T.lchild;
            }   
        }

    }

}

```</p></body></html></richcontent></node><node CREATED="1561249085302" ID="ID_90baa0fc446d" MODIFIED="1561249085302" TEXT="二叉树中查找值为x的结点"><richcontent TYPE="NOTE"><html><head></head><body><p>先序遍历的思想实现
1，若二叉树为空，则不存在这个结点，返回空值，否则，将根结点的值与x进行比较，若相等，则返回该结点
2，若该结点的值与x不相等，则在左子树中进行查找，若找不到，则返回找到的结点
3，若在左子树中没找到值为x的结点，则继续在右子树中进行查找
```java
//二叉树上的查找算法
public BiTreeNode searchNode (BiTreeNode T, Object x) {

    if(T!=null) {
        return T;
    }
    else {
        BiTreeNode lresult = searchNode(T.lchild,x);//查找左子树
        return lresult !=null?lresult:searchNode(T.rchild,x);
        //若左子树中查找到值为x的结点，则返回该结点，否则，在右子树中查找该结点
        //返回结果
    }
}
```</p></body></html></richcontent></node></node><node CREATED="1561249085302" ID="ID_fc555eab4c85" MODIFIED="1561249085302" TEXT="中序遍历"><node CREATED="1561249085303" ID="ID_8f838875ab1e" MODIFIED="1561249085303" TEXT="递归"><richcontent TYPE="NOTE"><html><head></head><body><p>```java
public void D(BiTreeNode T){
    if(T!=null){
        D(T.lchld);//遍历左子树
        System.out.println(T.data);//访问跟结点
        D(T.rchild);//遍历右子树

      }

}
```</p></body></html></richcontent></node><node CREATED="1561249085303" ID="ID_b24e03145d0a" MODIFIED="1561249085303" TEXT="非递归"><richcontent TYPE="NOTE"><html><head></head><body><p>1，创建一个栈对象，根结点进栈
2，若栈非空，则将栈顶结点的非空左孩子想继入栈
3，栈顶结点出栈并访问非空栈顶结点，并使该栈顶结点的非空右孩子结点入栈
4，重复执行2,3直到栈为空为止
```java
public void inRootTraverse() throws Exception {
    BiTreeNode T = root;
    if(T!=null) {
        LinkStack S = new LinkStack();//构造链栈
        S.push(T);//根节点入栈
        while (!S.isEmpty()) {//判断栈顶是否为空
            while(S.peek()!=null)//将栈顶结点的孩子相继入栈
                S.push(((BiTreeNode)S.peek()).lchild);
            S.pop();//空结点退栈
            if(!S.isEmpty()) {//判断栈顶是否为空
                T = (BiTreeNode)S.pop();//移除栈顶结点，并返回其值
                System.out.println(T.data);//访问节点
                S.push(T.rchild);//结点的右孩子入栈
            }
        }
    }
}

```</p></body></html></richcontent></node></node><node CREATED="1561249085303" ID="ID_2ce1964903f9" MODIFIED="1561249085303" TEXT="后序遍历"><node CREATED="1561249085303" ID="ID_cba16d3d4d07" MODIFIED="1561249085303" TEXT="递归"><richcontent TYPE="NOTE"><html><head></head><body><p>```java
public void D(BiTreeNode T){
    if(T!=null){
        D(T.lchld);//遍历左子树
        D(T.rchild);//遍历右子树
        System.out.println(T.data);//访问跟结点
      }

}
```</p></body></html></richcontent></node><node CREATED="1561249085303" ID="ID_bb88814e2af5" MODIFIED="1561249085303" TEXT="非递归"><richcontent TYPE="NOTE"><html><head></head><body><p>1，创建一个栈对象，根结点进栈，p赋初值null (p为结点指针)
2，若栈非空，则栈顶结点的非空左孩子相继进栈
3，若栈非空，查看栈顶结点，若栈顶结点的右孩子为空，或者与p相等，则将栈顶结点弹出栈斌访问它，同时使p指向该结点，并置flag值为true,否则，将栈顶结点的右孩子压入栈，并置flag值为false
4，若flag值为true,则重复执行步骤3，否则，重复执行步骤2和3，直到栈为空为止
```java
public void postRootTraverse() throws Exception {

    BiTreeNode T = root;
    if(T!=null) {
        LinkStack S = new LinkStack();//构造链栈
        S.push(T);//根结点进栈
        Boolean flag;//访问标记
        BiTreeNode p = null;//p指向刚被访问的结点
        while(!S.isEmpty()) {
            while(S.peek()!=null)//将栈顶结点的左孩子相继入栈
                S.push(((BiTreeNode)S.peek()).lchild);
            S.pop();//空结点退栈
            while(!S.isEmpty()) {
                T = (BiTreeNode)S.peek();//查看栈顶元素
                if(T.rchild== null || T.rchild==p) {
                    System.out.println(T.data);//访问结点
                    S.pop();//移除栈顶元素
                    p=T;//p指向刚被访问的结点
                    flag = true;//设置访问标记
                }
                else {
                    S.push(T.rchild);//右孩子结点入栈
                    flag = false;
                }
                if(!flag)
                    break;
            }
        }


    }
}
```</p></body></html></richcontent></node><node CREATED="1561249085303" ID="ID_37be310d5165" MODIFIED="1561249085303" TEXT="二叉树的深度"><richcontent TYPE="NOTE"><html><head></head><body><p>运用后序遍历的思想
1,求左子树的深度
2，求右子树的深度
3，将左，右子树的深度的最大值加1并返回</p></body></html></richcontent></node></node></node></node><node CREATED="1561249085303" ID="ID_abb564ab32b7f0544a0b" MODIFIED="1561249085303" TEXT="基于栈的递归消除"></node></node><node CREATED="1561249085303" ID="ID_51d3e2ebd97c99b5c59b" MODIFIED="1561249085303" TEXT="树，森林和二叉树的关系"><node CREATED="1561249085303" ID="ID_74e381e71b6ae7495ee8" MODIFIED="1561249085303" TEXT="双亲表示法"></node><node CREATED="1561249085303" ID="ID_775184ea395fc563f252" MODIFIED="1561249085303" TEXT="孩子表示法"></node><node CREATED="1561249085303" ID="ID_c189e1884dae32d0cabf" MODIFIED="1561249085303" TEXT="孩子兄弟表示法"></node><node CREATED="1561249085303" ID="ID_660c58efacc5331d13fe" MODIFIED="1561249085303" TEXT="转换"></node></node><node CREATED="1561249085303" ID="ID_193411d8c1bf7efa20b9" MODIFIED="1561249085303" TEXT="哈夫曼树"><node CREATED="1561249085303" ID="ID_c86df5d65d178d840054" MODIFIED="1561249085303" TEXT="哈夫曼编码实现压缩，解压缩"><node CREATED="1561249085303" ID="ID_71127c7b0aca" MODIFIED="1561249085303" TEXT="最优二叉树"><richcontent TYPE="NOTE"><html><head></head><body><p>一棵二叉树，使其带权路径长度达到最小值，则这课二叉树称为最优二叉树</p></body></html></richcontent></node></node><node CREATED="1561249085303" ID="ID_996e437c34cd" MODIFIED="1561249085303" TEXT="构造方法"><richcontent TYPE="NOTE"><html><head></head><body><p>先构造哈夫曼树，堆字符串再次编码，二进制的长度会明显缩小，进而达到压缩效果。</p></body></html></richcontent></node></node><node CREATED="1561249085303" ID="ID_4307b719952ee0230a14" MODIFIED="1561249085303" TEXT="并查集"></node></node><node CREATED="1561249085303" ID="ID_0a4277227f6ef60a975a" POSITION="right" MODIFIED="1561249085303" TEXT="图"><node CREATED="1561249085303" ID="ID_e85c292bb267dd95251a" MODIFIED="1561249085303" TEXT="抽象数据类型"></node><node CREATED="1561249085303" ID="ID_64fd99e9f3e6db2b3193" MODIFIED="1561249085303" TEXT="存储结构"><node CREATED="1561249085303" ID="ID_bb76de5786f4f203f46a" MODIFIED="1561249085303" TEXT="领结矩阵表示法"><richcontent TYPE="NOTE"><html><head></head><body><p>用两个数组表示图，一个一维数组存储途中顶点信息；一个二维数组（邻接矩阵）存储图中的边的信息</p></body></html></richcontent></node><node CREATED="1561249085303" ID="ID_442048fee3e2cb30ad51" MODIFIED="1561249085303" TEXT="邻接表表示法"><richcontent TYPE="NOTE"><html><head></head><body><p>数组和链表相结合的存储方法</p></body></html></richcontent></node><node CREATED="1561249085303" ID="ID_d6b4a9067fa5256618f2" MODIFIED="1561249085303" TEXT="十字链表"><richcontent TYPE="NOTE"><html><head></head><body><p>把邻接表和逆邻接表结合</p></body></html></richcontent></node><node CREATED="1561249085303" ID="ID_ee468cf070addf1ca507" MODIFIED="1561249085303" TEXT="邻接多重表"></node></node><node CREATED="1561249085303" ID="ID_106349f1b0101b37ec12" MODIFIED="1561249085303" TEXT="遍历"><node CREATED="1561249085303" ID="ID_633833029228cb38ca45" MODIFIED="1561249085303" TEXT="深度优先搜索 DFS"><richcontent TYPE="NOTE"><html><head></head><body><p>在没有碰到重复顶点的情况下，始终向右手边走；
走回顶点之后，还要按原路一步步回溯，验证每一步是否有分叉且走完</p></body></html></richcontent></node><node CREATED="1561249085303" ID="ID_ff8edaa970ec49901af1" MODIFIED="1561249085303" TEXT="广度优先搜索 BFS"><richcontent TYPE="NOTE"><html><head></head><body><p>图需要变形下，改造成类似树那样有明显的层次关系的样子</p></body></html></richcontent></node></node><node CREATED="1561249085303" ID="ID_8dcb76a3b30c57cb6c7c" MODIFIED="1561249085303" TEXT="应用"><node CREATED="1561249085303" ID="ID_9d6f1d8a989c4328f52c" MODIFIED="1561249085303" TEXT="无向图的连通分量"></node><node CREATED="1561249085303" ID="ID_73615d2129eca507de8a" MODIFIED="1561249085303" TEXT="求简单路径"></node><node CREATED="1561249085303" ID="ID_88b2a5b5d7613f440279" MODIFIED="1561249085303" TEXT="最小生成树"><richcontent TYPE="NOTE"><html><head></head><body><p>把构造连通网的最小代价生成树称为最小生成树；
所谓最小代价，指n个顶点，用n-1条边把一个连通图连接起来，且是的权值的和最小</p></body></html></richcontent><node CREATED="1561249085303" ID="ID_3766b2824f1903da596f" MODIFIED="1561249085303" TEXT="普里姆算法"><richcontent TYPE="NOTE"><html><head></head><body><p>以某个顶点为起点，逐步找各个顶点上最小权值的边来构造最小生成树</p></body></html></richcontent></node><node CREATED="1561249085303" ID="ID_c8c12188cfab06b30c0c" MODIFIED="1561249085303" TEXT="克鲁斯卡算法"><richcontent TYPE="NOTE"><html><head></head><body><p>以最小权值边开始构建</p></body></html></richcontent></node></node><node CREATED="1561249085303" ID="ID_77002550091de2ba4a6d" MODIFIED="1561249085303" TEXT="拓扑排序"><node CREATED="1561249085303" ID="ID_0736f1ae6ebf128f31ea" MODIFIED="1561249085303" TEXT="AOV-网"></node><node CREATED="1561249085303" ID="ID_73a7697da1876f07cb72" MODIFIED="1561249085303" TEXT="关键路径"></node><node CREATED="1561249085303" ID="ID_b58721fa275d614f74c6" MODIFIED="1561249085303" TEXT="最短路径"><node CREATED="1561249085303" ID="ID_6bd9cd5e100f38f2a867" MODIFIED="1561249085303" TEXT="迪杰斯特拉算法"></node><node CREATED="1561249085303" ID="ID_95ec21bc1007d64a5434" MODIFIED="1561249085303" TEXT="弗洛伊德算法"></node></node></node></node></node><node CREATED="1561249085303" ID="ID_a14c2dd2489ce7a32e03" POSITION="right" MODIFIED="1561249085303" TEXT="查找"><node CREATED="1561249085303" ID="ID_d7048860146713c7ef1f" MODIFIED="1561249085303" TEXT="基于线性表的查找"><node CREATED="1561249085303" ID="ID_3ec24525e52a0711ee5a" MODIFIED="1561249085303" TEXT="线性查找法 O(n)"><richcontent TYPE="NOTE"><html><head></head><body><p>线性查找又称顺序查找；基本思路如下：
从第一个记录开始，逐个比较记录的关键字，直到和给定的K值相等，则查找成功；
若比较结果和文件中n个记录的关键字都不等，则查找失败。</p></body></html></richcontent></node><node CREATED="1561249085303" ID="ID_089de309063c543e285b" MODIFIED="1561249085303" TEXT="二分查找法 O(log2^n)"><richcontent TYPE="NOTE"><html><head></head><body><p>二分查找又称折半查找；基本思路如下：
设置一个左标记为0，一个右标记为当前数组长度；
让当前待查找元素与表中间元素进行匹配，如果一致则直接返回中间索引，
如果大于中间索引，则让左标记等于当前中间索引。</p></body></html></richcontent><node CREATED="1561249085303" ID="ID_acd5225a4b66" MODIFIED="1561249085303" TEXT="优点：比较次数大幅减少，索引效率高"></node><node CREATED="1561249085303" ID="ID_62cc47fa31f0" MODIFIED="1561249085303" TEXT="缺点：待查询的表需为有序表；插入修改数据效率低"></node></node><node CREATED="1561249085303" ID="ID_5047f39c6b1d377b9652" MODIFIED="1561249085303" TEXT="分块查找法"></node></node><node CREATED="1561249085303" ID="ID_127fd5edbeeccc4204e2" MODIFIED="1561249085303" TEXT="基于树的查找"><node CREATED="1561249085303" ID="ID_1d4eecdcf697800b4a91" MODIFIED="1561249085303" TEXT="二叉排序树"><richcontent TYPE="NOTE"><html><head></head><body><p>若左子树不为空，则左子树上所有结点值均小于根结点的值；
若右子树不为空，则右子树上所有结点值均大于根结点的值；
左右子树同样适用上面规则；
中序遍历后是升序的</p></body></html></richcontent></node><node CREATED="1561249085303" ID="ID_d38828f3449c2e4cbf88" MODIFIED="1561249085303" TEXT="平衡二叉排序树 AVL"><richcontent TYPE="NOTE"><html><head></head><body><p>二叉排序树的一种，其中每个结点的左右子树的高度差绝对值不超过1

应用场景中多适用于数据库，对插入删除不频繁，只要求查找效率高，这方面AVL较优于红黑树</p></body></html></richcontent></node><node CREATED="1561249085303" ID="ID_892c2d99937b0d6587f9" MODIFIED="1561249085303" TEXT="B树"><richcontent TYPE="NOTE"><html><head></head><body><p>每个结点的孩子树可以多余两个，且每个结点处可以存储多个元素</p></body></html></richcontent><node CREATED="1561249085303" ID="ID_6ca7c5b7f069" MODIFIED="1561249085303" TEXT="B+树"><richcontent TYPE="NOTE"><html><head></head><body><p>应文件系统所需出现的一种B树的变种
出现在分支结点中的元素会在叶子结点中再次列出，每个叶子结点都会保存一个指向后一叶子结点的指针</p></body></html></richcontent></node></node><node CREATED="1561249085303" ID="ID_20df98d01310" MODIFIED="1561249085303" TEXT="红黑树"><richcontent TYPE="NOTE"><html><head></head><body><p>一种自平衡的二叉排序树，和AVL树类似（并不是真的平衡二叉树），都是在进行插入和删除操作是通过特定操作保持二叉排序树的平衡，从而获得较高的查询性能</p></body></html></richcontent><node CREATED="1561249085303" ID="ID_8377d4d1778d" MODIFIED="1561249085303" TEXT="性质"><node CREATED="1561249085303" ID="ID_beda48ed1e72" MODIFIED="1561249085303" TEXT="每个结点要么是红色，要么是黑色"></node><node CREATED="1561249085303" ID="ID_326f3ab08ebd" MODIFIED="1561249085303" TEXT="根结点永远是黑色"></node><node CREATED="1561249085303" ID="ID_2d29e0018007" MODIFIED="1561249085303" TEXT="所有的叶子结点都是空结点，且是黑色的"></node><node CREATED="1561249085303" ID="ID_084772810812" MODIFIED="1561249085303" TEXT="每个红色结点的两个子结点都是黑色的&amp;lt;br&amp;gt;（从每个叶子结点到根结点的路径上不会出现两个连续的红色结点）"></node><node CREATED="1561249085303" ID="ID_d6e1ae193a52" MODIFIED="1561249085303" TEXT="从任一结点到其子树中每个叶子结点的路径都包含相同数量的黑色结点"></node></node><node CREATED="1561249085303" ID="ID_d193b2c7816e" MODIFIED="1561249085303" TEXT="特点"><richcontent TYPE="NOTE"><html><head></head><body><p>以上性质可推出红黑树的关键特点：
从跟到叶子结点的最长的可能路径不多于最短的可能路径的两倍；
主要原因在于性质4导致路径不能有两个连续的红色结点，最短的可能路径都是黑色结点，最长的可能路径都是交替出现的红色和黑色结点；
根据性质5所有最长路径都有相同数目的黑色结点，这表明没有路径能多于任何其他路径的两倍长；
因而大多数数据结构底层是红黑树实现的</p></body></html></richcontent></node></node></node><node CREATED="1561249085303" ID="ID_86ad51be38b1d88b1d52" MODIFIED="1561249085303" TEXT="散列表查找"><node CREATED="1561249085303" ID="ID_40cf7b03bf1e74bb7eee" MODIFIED="1561249085303" TEXT="哈希法"><richcontent TYPE="NOTE"><html><head></head><body><p>在存储时，通过hash函数计算记录的hash地址，名按此hash地址存储该记录
查询记录时，通过同样的hash函数计算记录的hash地址，按hash地址访问记录</p></body></html></richcontent><node CREATED="1561249085303" ID="ID_be617699001e6185452e" MODIFIED="1561249085303" TEXT="构造"><node CREATED="1561249085303" ID="ID_68989458ea96f943ad53" MODIFIED="1561249085303" TEXT="数字分析法"></node><node CREATED="1561249085303" ID="ID_703d17e50147fd157d5f" MODIFIED="1561249085303" TEXT="平方取中法"></node><node CREATED="1561249085303" ID="ID_1e72637a22ccd7061226" MODIFIED="1561249085303" TEXT="分段叠加法"></node><node CREATED="1561249085303" ID="ID_6b7c1c4667a6f51bd01d" MODIFIED="1561249085303" TEXT="除留余数法"></node><node CREATED="1561249085303" ID="ID_9de46939f7eeb9369d69" MODIFIED="1561249085303" TEXT="伪随机数法"></node></node><node CREATED="1561249085303" ID="ID_8c12470a68d55d11c025" MODIFIED="1561249085303" TEXT="处理冲突"><node CREATED="1561249085303" ID="ID_c780eddc936a94fc14d6" MODIFIED="1561249085303" TEXT="开放定址法"><richcontent TYPE="NOTE"><html><head></head><body><p>遇到冲突，就去寻找下一个空的hash函数指向地址</p></body></html></richcontent></node><node CREATED="1561249085303" ID="ID_a0f113496ba5643463f5" MODIFIED="1561249085303" TEXT="再哈希法"><richcontent TYPE="NOTE"><html><head></head><body><p>准备多个hash函数，遇到冲突就换一个</p></body></html></richcontent></node><node CREATED="1561249085303" ID="ID_0cd769e24ea4bf993f60" MODIFIED="1561249085303" TEXT="链地址法"><richcontent TYPE="NOTE"><html><head></head><body><p>遇到冲突，在生成链表存储hash值</p></body></html></richcontent></node><node CREATED="1561249085303" ID="ID_aff6f1235f7271537dec" MODIFIED="1561249085303" TEXT="建立公共溢出区"><richcontent TYPE="NOTE"><html><head></head><body><p>冲突的都单独存储到溢出表中</p></body></html></richcontent></node></node></node></node></node><node CREATED="1561249085303" ID="ID_1e72a0efde86" POSITION="right" MODIFIED="1561249085303" TEXT="排序"><node CREATED="1561249085303" ID="ID_c2957caa429435e49249" MODIFIED="1561249085303" TEXT="内部排序"><node CREATED="1561249085303" ID="ID_e031e34cb055410ef887" MODIFIED="1561249085303" TEXT="插入排序"><node CREATED="1561249085303" ID="ID_c5e777a1a3a02fa9dda2" MODIFIED="1561249085303" TEXT="直接插入排序O(n^2)"><richcontent TYPE="NOTE"><html><head></head><body><p>每趟将一条待插入的记录，按关键字值的大小插入到前面已经排好序的记录序列中的合适位置</p></body></html></richcontent><node CREATED="1561249085303" ID="ID_6a1aeee44cca" MODIFIED="1561249085303" TEXT="无哨兵节点"><richcontent TYPE="NOTE"><html><head></head><body><p>```java
public void insertSort(){
  RecordNode temp;
  int i, j;
  for(i=1;i&amp;lt;this.curlen;i++) {
      temp= r[i];
      for(j=i-1;j&amp;gt;=0 &amp;&amp; temp.key.compareTo(r[j].key)&amp;lt;0; j--) {
          r[j+1] =r[j];
      }
      r[j+1] = temp;
  }
}
```</p></body></html></richcontent></node><node CREATED="1561249085303" ID="ID_2ae147769246" MODIFIED="1561249085303" TEXT="有哨兵节点"><richcontent TYPE="NOTE"><html><head></head><body><p>```java
//只适用于存储单元下标为1到n-1数组
public void insertSortwithGuard() {

    int i,j;
    for(i=1;i&amp;lt;this.curlen;i++) { //n-1趟扫描                           
        r[0] = r[i];              //将待插入的第i条记录暂存在r[0]中，同时r[0]为监视哨
         for(j=i-1;r[0].key.compareTo(r[j].key)&amp;lt;0; j--) {//将前面较大的数据元素向后移动
             r[j+1]  = r[j];
         }
         r[j+1] = r[0];//r[i]插入到j+1个位置
    }

}
```</p></body></html></richcontent></node><node CREATED="1561249085303" ID="ID_88e3d6e5dec8" MODIFIED="1561249085303" TEXT="时间复杂度O(n^2)"></node><node CREATED="1561249085303" ID="ID_d651b1c53c78" MODIFIED="1561249085303" TEXT="空间复杂度O(1)"></node><node CREATED="1561249085303" ID="ID_e269ffe1d62a" MODIFIED="1561249085303" TEXT="稳定的排序方式"></node></node><node CREATED="1561249085303" ID="ID_94b874097ac891dcf64f" MODIFIED="1561249085303" TEXT="希尔排序 O(nlog2^n)至O(n^2)"><node CREATED="1561249085303" ID="ID_51b483b1a226" MODIFIED="1561249085303" TEXT="实际是缩小增量的直接插入排序"><richcontent TYPE="NOTE"><html><head></head><body><p>设置多组增量间隔，分别形成子表，在表内进行直接插入排序，下面使用的插入排序是不带监视哨的
```java
//希尔排序算法
public void shellSort(int[] d) { //d[]为增量数组
    RecordNode temp;
    int i,j;
    //控制增量，增量减半，若干趟扫描
    for(int k=0;k&amp;lt;d.length;k++) {
        //一趟若干子表，每个记录在自己所属子表内进行直接排序
        int dk=d[k];
        for(i=dk;i&amp;lt;this.curlen;i++) {
            temp = r[i];
            for(j=i-dk;j&amp;gt;=0 &amp;&amp; temp.key.compareTo(r[j].key)&amp;lt;0;j-=dk) {
                r[j+dk] =r[j];
            }
            r[j+dk] = temp;
        }
    }

}
```</p></body></html></richcontent></node><node CREATED="1561249085303" ID="ID_4488691c6853" MODIFIED="1561249085303" TEXT="时间复杂度&amp;nbsp;O(nlog2^n)至O(n^2)"></node><node CREATED="1561249085303" ID="ID_a190fe1089ac" MODIFIED="1561249085303" TEXT="空间复杂度O(1)"></node><node CREATED="1561249085303" ID="ID_8664852461bc" MODIFIED="1561249085303" TEXT="不稳定的排序方式"></node></node></node><node CREATED="1561249085303" ID="ID_098c7ae7fbe228eb1c46" MODIFIED="1561249085303" TEXT="交换类排序"><node CREATED="1561249085303" ID="ID_555636bbbdd49826f88d" MODIFIED="1561249085303" TEXT="冒泡排序 O(n^2)"><node CREATED="1561249085303" ID="ID_7e5a50f1e4c1" MODIFIED="1561249085303" TEXT="两个循环，将最大值依次移至最后"><richcontent TYPE="NOTE"><html><head></head><body><p>```java
//冒泡排序
public void bubbleSort() {
    RecordNode temp;//辅助结点
    boolean flag = true; //是否交换的标记
    for(int i = 1; i&amp;lt;this.curlen &amp;&amp; flag;i++) {//有交换时，进行下一趟
        flag = false;//记录为交换
        for(int j = 0; j&amp;lt;this.curlen-i;j++) {
            if(r[j].key.compareTo(r[j+1].key)&amp;gt;0) {//逆序时，交换
                temp = r[j];
                r[j] = r[j+1];
                r[j+1]= temp;
                flag=true;

            }
        }
    }
}
```</p></body></html></richcontent></node><node CREATED="1561249085303" ID="ID_bc93e7916fbe" MODIFIED="1561249085303" TEXT="时间复杂度 O(n^2)"></node><node CREATED="1561249085303" ID="ID_d6f1402f716f" MODIFIED="1561249085303" TEXT="空间复杂度 O(1)"></node><node CREATED="1561249085303" ID="ID_3bc904c63343" MODIFIED="1561249085303" TEXT="稳定的排序方式"></node></node><node CREATED="1561249085303" ID="ID_847112efa1228dd14222" MODIFIED="1561249085303" TEXT="快排"><richcontent TYPE="NOTE"><html><head></head><body><p>是冒泡排序的改进算法，采用分治策略，将原问题划分为若干规模的子问题，采用递归解决这些问题</p></body></html></richcontent><node CREATED="1561249085303" ID="ID_71fe57fa7a12" MODIFIED="1561249085303" TEXT="最坏时间复杂度 O(n^2), 平均时间复杂度 O(nlog2^n) 内部排序中性能最好的一种"></node><node CREATED="1561249085303" ID="ID_c7127b54318f" MODIFIED="1561249085303" TEXT="平均情况下，空间复杂度为 O(log2^n)，最坏为 O(n)"></node><node CREATED="1561249085303" ID="ID_0a901d1e3fc4" MODIFIED="1561249085303" TEXT="不稳定的排序方式"></node></node></node><node CREATED="1561249085303" ID="ID_dda00cf1b287a3911f6b" MODIFIED="1561249085303" TEXT="选择类排序"><node CREATED="1561249085303" ID="ID_eefa1410409f43d70229" MODIFIED="1561249085303" TEXT="直接选择排序 O(n^2)"><richcontent TYPE="NOTE"><html><head></head><body><p>在第一趟中，从n个记录中找出关键字值最小的记录与第1个记录交换，在第2趟中，从第2个记录开始的n-1个记录中再选出关键字最小的记录与第二个记录交换</p></body></html></richcontent><node CREATED="1561249085303" ID="ID_9bbb30dcfde2" MODIFIED="1561249085303" TEXT="时间复杂度 O(n^2)"></node><node CREATED="1561249085303" ID="ID_7035503f69d4" MODIFIED="1561249085303" TEXT="空间复杂度 O(1)"></node><node CREATED="1561249085303" ID="ID_ca393e8d8a53" MODIFIED="1561249085303" TEXT="不稳定的排序方式"></node></node><node CREATED="1561249085303" ID="ID_36480388c35fedca9e8b" MODIFIED="1561249085303" TEXT="树形选择排序 O(nlog2^n)"><richcontent TYPE="NOTE"><html><head></head><body><p>类似于打比赛，两个决出胜负，冠军树，如果n不是2的几次幂，需要补足为满二叉树</p></body></html></richcontent><node CREATED="1561249085303" ID="ID_fc90c10bfc5c" MODIFIED="1561249085303" TEXT="时间复杂度&amp;nbsp;O(nlog2^n)"></node><node CREATED="1561249085303" ID="ID_209dc281787f" MODIFIED="1561249085303" TEXT="空间复杂度 O(n^2)"></node><node CREATED="1561249085303" ID="ID_0af2f5eb8f8c" MODIFIED="1561249085303" TEXT="稳定的排序方式"></node></node></node><node CREATED="1561249085303" ID="ID_6325e384f5fe65bb1c07" MODIFIED="1561249085303" TEXT="堆排序&amp;nbsp;O(nlog2^n)"><node CREATED="1561249085303" ID="ID_2264bd2b1897" MODIFIED="1561249085303" TEXT="弥补了树形选择排序使用较多存储空间的缺点"></node><node CREATED="1561249085303" ID="ID_8f7b38d0fe51" MODIFIED="1561249085303" TEXT="采用数组存储，可看作顺序存储的完全二叉树"></node><node CREATED="1561249085303" ID="ID_a27f2c4639cc" MODIFIED="1561249085303" TEXT="堆排思想"><node CREATED="1561249085303" ID="ID_afadc8a12d82" MODIFIED="1561249085303" TEXT="建初始堆"><richcontent TYPE="NOTE"><html><head></head><body><p>对完全二叉树从下往上反复筛选的过程，用筛选法，完全二叉树最后一个非叶子结点编号为（n/2）-1，只需从此开始筛选即可</p></body></html></richcontent></node><node CREATED="1561249085303" ID="ID_5b3580b004db" MODIFIED="1561249085303" TEXT="筛选法调整堆"><richcontent TYPE="NOTE"><html><head></head><body><p>父节点，与左右子结点比较，筛选，然后下一个结点循环到最后</p></body></html></richcontent></node></node><node CREATED="1561249085303" ID="ID_ad6bcf878723" MODIFIED="1561249085303" TEXT="时间复杂度 O(nlog2^n)"></node><node CREATED="1561249085303" ID="ID_c54da179a086" MODIFIED="1561249085303" TEXT="空间复杂度 O(1)"></node><node CREATED="1561249085303" ID="ID_fd7f61bda857" MODIFIED="1561249085303" TEXT="不稳定的排序方式"></node></node><node CREATED="1561249085303" ID="ID_10ff0f48459ddbaaf232" MODIFIED="1561249085303" TEXT="归并排序"><node CREATED="1561249085303" ID="ID_fcd3db679b18" MODIFIED="1561249085303" TEXT="二路归并 O(nlog2^n)"><node CREATED="1561249085303" ID="ID_9ba78a7f5578" MODIFIED="1561249085303" TEXT="时间复杂度&amp;nbsp;O(nlog2^n)"></node><node CREATED="1561249085303" ID="ID_f7562468b33f" MODIFIED="1561249085303" TEXT="空间复杂度 O(n)"></node><node CREATED="1561249085303" ID="ID_df9a05a92a9e" MODIFIED="1561249085303" TEXT="稳定的排序方式"></node></node><node CREATED="1561249085303" ID="ID_cd4215ab49d2" MODIFIED="1561249085303" TEXT="多路归并"></node></node><node CREATED="1561249085303" ID="ID_f9eaa12dd417983938d7" MODIFIED="1561249085303" TEXT="分配类排序"><node CREATED="1561249085303" ID="ID_6043be6dbb51d7311096" MODIFIED="1561249085303" TEXT="多关键字排序"></node><node CREATED="1561249085303" ID="ID_5fa80ec0f0d1a3dcd2c8" MODIFIED="1561249085303" TEXT="链式基数排序"></node></node></node><node CREATED="1561249085303" ID="ID_53169628bc65" MODIFIED="1561249085303" TEXT="外排序"></node></node><node CREATED="1561249085303" ID="ID_05e138a0165e5ff812b7" POSITION="right" MODIFIED="1561249085303" TEXT="一般线性表"><node CREATED="1561249085303" ID="ID_1541271d57d6" MODIFIED="1561249085303" TEXT="抽象数据类型"></node><node CREATED="1561249085303" ID="ID_b9f7ac128829" MODIFIED="1561249085303" TEXT="顺序存储"><node CREATED="1561249085303" ID="ID_0786bcd9a3f7" MODIFIED="1561249085303" TEXT="顺序表"><node CREATED="1561249085303" ID="ID_0fc70e89d16e" MODIFIED="1561249085303" TEXT="插入"><richcontent TYPE="NOTE"><html><head></head><body><p>思路：
如果插入位置不正确，抛出异常；
如果线性表长度大于数组长度，则动态扩容（2N）；
从最后一个元素开始向前遍历到第i个元素位置，分别将元素后移一位，将目标元素插入指定位置，表长度自增1。</p></body></html></richcontent></node><node CREATED="1561249085303" ID="ID_684f2074bf7e" MODIFIED="1561249085303" TEXT="删除"><richcontent TYPE="NOTE"><html><head></head><body><p>思路：
如果删除位置不合理，抛出异常；
删除元素，从删除元素位置开始遍历至最后一个元素位置，分别将元素前移一位，表长度自减1。</p></body></html></richcontent></node><node CREATED="1561249085303" ID="ID_8d6e342671d6" MODIFIED="1561249085303" TEXT="特点"><node CREATED="1561249085304" ID="ID_4d694eb6c3af" MODIFIED="1561249085304" TEXT="查询修改时，时间复杂度为 O(1)"></node><node CREATED="1561249085304" ID="ID_a8d4ec3c043a" MODIFIED="1561249085304" TEXT="插入和删除时，时间复杂度为 O(n)"></node></node></node></node><node CREATED="1561249085304" ID="ID_838a681454c83a922e0f" MODIFIED="1561249085304" TEXT="链式存储"><node CREATED="1561249085304" ID="ID_f48f3c1d05be7c2ef158" MODIFIED="1561249085304" TEXT="单链表"><node CREATED="1561249085304" ID="ID_0d8221a99a1f" MODIFIED="1561249085304" TEXT="查询"><richcontent TYPE="NOTE"><html><head></head><body><p>从头结点开始遍历，使用临时变量记录遍历次数；一直遍历至指定下标元素，取出当前下标结点。</p></body></html></richcontent></node><node CREATED="1561249085304" ID="ID_e5b5255ea817" MODIFIED="1561249085304" TEXT="插入"><richcontent TYPE="NOTE"><html><head></head><body><p>指定位置插入：
1. 定位至需要操作结点的前一结点对象；
2. 改变操作结点前一结点的指针域指向当前结点；
3. 最后把操作结点的指针域指向之前第一步定位到结点的原始指针域的结点

尾结点插入：
1. 判断当前结点指向下一结点的指针域是否为空
2. 如果指针域为空，说明该结点为尾结点
3. 直接在尾结点修改默认结点的指针域指向新增结点，并把新增结点的指针域指向null</p></body></html></richcontent></node><node CREATED="1561249085304" ID="ID_f28cce1a2d28" MODIFIED="1561249085304" TEXT="删除"><richcontent TYPE="NOTE"><html><head></head><body><p>定位至当前要删除的结点的前一结点
修改当前删除的结点的前一结点（前继结点）的指针域指向当前要删除结点的指针域指向的下一结点（后继结点）</p></body></html></richcontent></node><node CREATED="1561249085304" ID="ID_335917affff8" MODIFIED="1561249085304" TEXT="特点"><node CREATED="1561249085304" ID="ID_59d5f4ac8fc4" MODIFIED="1561249085304" TEXT="插入和删除时，时间复杂度 O(1)"></node><node CREATED="1561249085304" ID="ID_2b9d99f774ea" MODIFIED="1561249085304" TEXT="查询修改时，时间复杂度 O(1)"></node></node></node><node CREATED="1561249085304" ID="ID_152a9b66afa6081420eb" MODIFIED="1561249085304" TEXT="双向链表"><richcontent TYPE="NOTE"><html><head></head><body><p>在单链袤的每个结点中,再设置一个指向其前驱结点的指针 域 。所以在双向链表中的结点都有两个指针域, 一个指向直接后继,另一个指向直接 前驱。</p></body></html></richcontent><node CREATED="1561249085304" ID="ID_8e3a343963c4" MODIFIED="1561249085304" TEXT="双向链表和单链表操作基本相同，子树在插入和删除是多了一个改变前继指针的操作"></node></node><node CREATED="1561249085304" ID="ID_05cabf873799ee6fdcfd" MODIFIED="1561249085304" TEXT="循环链表"><richcontent TYPE="NOTE"><html><head></head><body><p>头尾相连成环</p></body></html></richcontent></node><node CREATED="1561249085304" ID="ID_659ee5a62d48641e4559" MODIFIED="1561249085304" TEXT="静态链表（借助数组实现）"></node></node></node><node CREATED="1561249085304" ID="ID_ce3f2a380fd7" POSITION="right" MODIFIED="1561249085304" TEXT="受限线性表"><node CREATED="1561249085304" ID="ID_2f09b10434a8c0e30206" MODIFIED="1561249085304" TEXT="栈 LIFO"><node CREATED="1561249085304" ID="ID_e41fc11a53ee5964d80f" MODIFIED="1561249085304" TEXT="抽象数据类型"></node><node CREATED="1561249085304" ID="ID_0909934fe86e1bca6cbe" MODIFIED="1561249085304" TEXT="顺序栈"><node CREATED="1561249085304" ID="ID_df41b5b6159ff650bc52" MODIFIED="1561249085304" TEXT="多栈共享"></node></node><node CREATED="1561249085304" ID="ID_b2e6f2374ed979e1fa5f" MODIFIED="1561249085304" TEXT="链栈"><node CREATED="1561249085304" ID="ID_38335de3790017d45662" MODIFIED="1561249085304" TEXT="多栈运算"></node></node><node CREATED="1561249085304" ID="ID_f0aafccf7d27b64f1260" MODIFIED="1561249085304" TEXT="应用"><node CREATED="1561249085304" ID="ID_576803bea7b02ea7e3e4" MODIFIED="1561249085304" TEXT="括号补全"></node><node CREATED="1561249085304" ID="ID_50cd04c8d42bedcaa32a" MODIFIED="1561249085304" TEXT="表达式求值"></node></node><node CREATED="1561249085304" ID="ID_d9772805cbfa0c6ea362" MODIFIED="1561249085304" TEXT="栈与递归的实现"><node CREATED="1561249085304" ID="ID_03879af5943ed145f26e" MODIFIED="1561249085304" TEXT="汉诺塔递归算法"></node><node CREATED="1561249085304" ID="ID_78d6b2a648924be27b13" MODIFIED="1561249085304" TEXT="斐波那契数列的非递归算法"></node></node></node><node CREATED="1561249085304" ID="ID_50009200d202f1066e5a" MODIFIED="1561249085304" TEXT="队列 FIFO"><node CREATED="1561249085304" ID="ID_48fb1c36f748f8b2cc83" MODIFIED="1561249085304" TEXT="抽象数据类型"></node><node CREATED="1561249085304" ID="ID_f6b5b809cdbd47d7e0fc" MODIFIED="1561249085304" TEXT="链队列"><node CREATED="1561249085304" ID="ID_d026d90490fb298ed6e7" MODIFIED="1561249085304" TEXT="循环队列"></node></node><node CREATED="1561249085304" ID="ID_8732f898868155d2713d" MODIFIED="1561249085304" TEXT="应用举例"><node CREATED="1561249085304" ID="ID_6dd2bb63b4c05e0d2950" MODIFIED="1561249085304" TEXT="打印杨辉三角"></node><node CREATED="1561249085304" ID="ID_ba4092ddbc33f8510c94" MODIFIED="1561249085304" TEXT="键盘输入缓冲区问题"></node></node></node><node CREATED="1561249085304" ID="ID_b0fd487f6ba9" MODIFIED="1561249085304" TEXT="堆"><richcontent TYPE="NOTE"><html><head></head><body><p>一个完全二叉树，同时满足堆积的性质：
子结点的值总是小于（大于）它的父亲结点</p></body></html></richcontent><node CREATED="1561249085304" ID="ID_896c8ab57825" MODIFIED="1561249085304" TEXT="常用方法"><node CREATED="1561249085304" ID="ID_1b3313485b38" MODIFIED="1561249085304" TEXT="可以实现优先队列，队列中的元素出栈顺序按元素的优先级大小决定，而非先后顺序"></node><node CREATED="1561249085304" ID="ID_3abd6d84d1bf" MODIFIED="1561249085304" TEXT="支持堆排序"></node><node CREATED="1561249085304" ID="ID_b6e2972416aa" MODIFIED="1561249085304" TEXT="快速找出一个集合中的最小（大）值"></node></node><node CREATED="1561249085304" ID="ID_07c8c049eeec" MODIFIED="1561249085304" TEXT="最大堆"><richcontent TYPE="NOTE"><html><head></head><body><p>父结点的值比每个子结点的值都要大</p></body></html></richcontent></node><node CREATED="1561249085304" ID="ID_24bb4010e22c" MODIFIED="1561249085304" TEXT="最小堆"><richcontent TYPE="NOTE"><html><head></head><body><p>父结点的值比每个子结点的值都要小</p></body></html></richcontent></node></node></node><node CREATED="1561249085304" ID="ID_909e984eed4d2efc5991" POSITION="right" MODIFIED="1561249085304" TEXT="数组与广义表"><node CREATED="1561249085304" ID="ID_2f3b85fe142217793188" MODIFIED="1561249085304" TEXT="定义"></node><node CREATED="1561249085304" ID="ID_7ee53206457d17793f1c" MODIFIED="1561249085304" TEXT="存储"><node CREATED="1561249085304" ID="ID_cc7d1d12a1fe1723af9b" MODIFIED="1561249085304" TEXT="n维地址计算"></node></node><node CREATED="1561249085304" ID="ID_dcf7ac713b58bf410441" MODIFIED="1561249085304" TEXT="特殊矩阵的压缩"><node CREATED="1561249085304" ID="ID_ce8c0953ec7dce460723" MODIFIED="1561249085304" TEXT="三角矩阵"></node><node CREATED="1561249085304" ID="ID_dbcaaec25fd30ebe6401" MODIFIED="1561249085304" TEXT="带状矩阵"></node><node CREATED="1561249085304" ID="ID_427c94cb8384c3a7dff0" MODIFIED="1561249085304" TEXT="稀疏矩阵"></node></node><node CREATED="1561249085304" ID="ID_4819e2f6dd89e54e1876" MODIFIED="1561249085304" TEXT="广义表"></node></node></node></map>