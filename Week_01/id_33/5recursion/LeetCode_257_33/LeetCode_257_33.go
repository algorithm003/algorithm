package main

import (
	"fmt"
	"strconv"
)

/**
257. 二叉树的所有路径
*/

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func binaryTreePaths1(root *TreeNode) []string {
	var result []string
	if root == nil {
		return result
	}
	dfs(root, "", &result)
	return result
}

/**
深度搜索
*/
func dfs(node *TreeNode, str string, result *[]string) {
	leftNode := node.Left
	rightNode := node.Right

	// 是叶子节点时，返回
	if leftNode == nil && rightNode == nil {
		*result = append(*result, str+strconv.Itoa(node.Val))
		return
	}
	str += strconv.Itoa(node.Val) + "->"
	if leftNode != nil {
		dfs(leftNode, str, result)
	}
	if rightNode != nil {
		dfs(rightNode, str, result)
	}
}

/**
广度搜索
*/
func binaryTreePaths(root *TreeNode) []string {
	var result []string
	if root == nil {
		return result
	}
	strArr := append(result, strconv.Itoa(root.Val))
	list := []*TreeNode{root}
	for len(list) > 0 {
		for i := 0; i < len(list); i++ {
			node := list[0]
			list = list[1:]
			str := strArr[0]
			strArr = strArr[1:]

			leftNode := node.Left
			rightNode := node.Right

			// 是叶子节点时，返回
			if leftNode == nil && rightNode == nil {
				result = append(result, str)
				continue
			}
			if leftNode != nil {
				list = append(list, leftNode)
				strArr = append(strArr, str+"->"+strconv.Itoa(leftNode.Val))
			}
			if rightNode != nil {
				list = append(list, rightNode)
				strArr = append(strArr, str+"->"+strconv.Itoa(rightNode.Val))
			}
		}
	}

	return result
}

func main() {
	root := &TreeNode{Val: 1}
	root.Left = &TreeNode{Val: 2}
	root.Right = &TreeNode{Val: 3}
	root.Left.Right = &TreeNode{Val: 5}

	fmt.Println(binaryTreePaths(root))
}
