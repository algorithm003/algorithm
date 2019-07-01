//+build ignored

package main

import (
	"fmt"
	"strconv"
	"strings"
)

/**
297. 二叉树的序列化与反序列化
*/

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

/**
广度搜索
当一层都为叶子节点时，返回
*/
func Serialize(root *TreeNode) string {
	if root == nil {
		return "[]"
	}
	result := "["
	list := []*TreeNode{root}
	for len(list) > 0 {
		flag := true
		for i := len(list); i > 0; i-- {
			node := list[0]
			list = list[1:]
			if node == nil {
				result += "null,"
				continue
			}
			result += strconv.Itoa(node.Val) + ","
			if node.Left != nil || node.Right != nil {
				flag = false
			}
			list = append(list, node.Left, node.Right)
		}
		if flag {
			break
		}
	}
	return result[:len(result)-1] + "]"
}

func Deserialize(data string) *TreeNode {
	var root TreeNode
	if len(data) <= 2 {
		return &root
	}
	// 构造root节点
	data = data[1 : len(data)-1]
	split := strings.Split(data, ",")
	v, _ := strconv.Atoi(split[0])
	root.Val = v
	split = split[1:]

	list := []*TreeNode{&root}
	// 层次搜索
	for {
		node := list[0]
		list = list[1:]
		// 左
		if len(split) > 0 {
			if split[0] != "null" {
				v, _ = strconv.Atoi(split[0])
				node.Left = &TreeNode{Val: v}
				list = append(list, node.Left)
			}
			split = split[1:]
		} else {
			break
		}
		// 右
		if len(split) > 0 {
			if split[0] != "null" {
				v, _ = strconv.Atoi(split[0])
				node.Right = &TreeNode{Val: v}
				list = append(list, node.Right)
			}
			split = split[1:]
		} else {
			break
		}
	}
	return &root
}

func main() {
	root := &TreeNode{Val: 1}
	root.Left = &TreeNode{Val: 2}
	root.Right = &TreeNode{Val: 3}
	root.Right.Left = &TreeNode{Val: 4}
	root.Right.Right = &TreeNode{Val: 5}
	fmt.Println(Serialize(root))
	fmt.Println(Deserialize("[1,2,3,null,null,4,5]"))
}
