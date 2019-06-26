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

func serialize(root *TreeNode) string {
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

func deserialize(data string) *TreeNode {
	var root TreeNode
	if len(data) <= 2 {
		return &root
	}
	data = data[1 : len(data)-1]
	split := strings.Split(data, ",")
	v, _ := strconv.Atoi(split[0])
	split = split[1:]
	root.Val = v
	list := []*TreeNode{&root}

	for {
		node := list[0]
		list = list[1:]
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
	//root := &TreeNode{Val: 1}
	//root.Left = &TreeNode{Val: 2}
	//root.Right = &TreeNode{Val: 3}
	//root.Right.Left = &TreeNode{Val: 4}
	//root.Right.Right = &TreeNode{Val: 5}
	//fmt.Println(serialize(root))
	fmt.Println(deserialize("[1,2,3,null,null,4,5]"))
}
