//+build ignore

package main

import (
	"container/heap"
	"fmt"
)

/**
703. 数据流中的第K大元素
*/

// 构造int堆，采用go示例中的代码
type IntHeap []int

func (h IntHeap) Len() int           { return len(h) }
func (h IntHeap) Less(i, j int) bool { return h[i] < h[j] }
func (h IntHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }
func (h *IntHeap) Push(x interface{}) {
	*h = append(*h, x.(int))
}
func (h *IntHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

// 处理实体
type KthLargest struct {
	Items *IntHeap // 堆
	K     int      // 第K大
}

func Constructor(k int, nums []int) KthLargest {
	items := &IntHeap{}
	heap.Init(items)
	for _, v := range nums {
		heap.Push(items, v)
		for len(*items) > k {
			heap.Pop(items)
		}
	}
	return KthLargest{items, k}
}

func (this *KthLargest) Add(val int) int {
	if len(*this.Items) < this.K {
		heap.Push(this.Items, val)
	} else if val > (*this.Items)[0] {
		heap.Push(this.Items, val)
		heap.Pop(this.Items)
	}
	return (*this.Items)[0]
}
func main() {
	constructor := Constructor(3, []int{4, 5, 8, 2})
	fmt.Println(constructor.Add(3))
	fmt.Println(constructor.Add(5))
	fmt.Println(constructor.Add(10))
	fmt.Println(constructor.Add(9))
	fmt.Println(constructor.Add(4))
}
