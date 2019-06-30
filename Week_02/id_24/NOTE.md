# 学习笔记

week_02

* 1. 寻找最下公共节点（LCA），使用递归最简单
		TreeNode left = lowestCommonAncestor(root.left, p, q);
    	TreeNode right = lowestCommonAncestor(root.right, p, q);
		分别查找传入的节点（root）的左右两边，由于递归是自低向上的
		因此最先出现左右两边分别等于p，q的root节点就是LCA节点
		如果没有出现就查看左右两边那一边是空值，出现空证明p，q都不在这个子树上
		返回另外一边子树，继续递归
