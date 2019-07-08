package main

import (
	"fmt"
)

/**
703. 数据流中的第K大元素
*/

//// 构造int大堆
//type MaxIntHeap []int
//func (h MaxIntHeap) Len() int           { return len(h) }
//func (h MaxIntHeap) Less(i, j int) bool { return h[i] < h[j] }
//func (h MaxIntHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }
//func (h *MaxIntHeap) Push(x interface{}) {
//	*h = append(*h, x.(int))
//}
//func (h *MaxIntHeap) Pop() interface{} {
//	old := *h
//	n := len(old)
//	x := old[n-1]
//	*h = old[0 : n-1]
//	return x
//}
//// 构造int小堆
//type MinIntHeap []int
//func (h MinIntHeap) Len() int           { return len(h) }
//func (h MinIntHeap) Less(i, j int) bool { return h[i] > h[j] }
//func (h MinIntHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }
//func (h *MinIntHeap) Push(x interface{}) {
//	*h = append(*h, x.(int))
//}
//func (h *MinIntHeap) Pop() interface{} {
//	old := *h
//	n := len(old)
//	x := old[n-1]
//	*h = old[0 : n-1]
//	return x
//}
//// 处理实体
//type MedianFinder struct {
//	MaxHeep *MaxIntHeap
//	MinHeap *MinIntHeap
//}
//// 初始化
//func Constructor() MedianFinder {
//	maxHeap, minHeap := &MaxIntHeap{}, &MinIntHeap{}
//	heap.Init(maxHeap)
//	heap.Init(minHeap)
//	return MedianFinder{maxHeap, minHeap}
//}
//// 优先放入大堆
//func (this *MedianFinder) AddNum(num int)  {
//	heap.Push(this.MaxHeep, num)
//	heap.Push(this.MinHeap, heap.Pop(this.MaxHeep))
//	if len(*this.MaxHeep) != len(*this.MinHeap) {
//		heap.Push(this.MaxHeep, heap.Pop(this.MinHeap))
//	}
//}
//// 大堆>小堆，返回大堆的最大值，否则返回(大堆最大值 + 小堆最小值)/2
//func (this *MedianFinder) FindMedian() float64 {
//	if this.MaxHeep.Len() == 0 {
//		return 0
//	}
//	if this.MaxHeep.Len() > this.MinHeap.Len() {
//		return float64((*this.MaxHeep)[0])
//	} else {
//		return float64((*this.MaxHeep)[0] + (*this.MinHeap)[0]) / 2
//	}
//}

// 处理实体
type MedianFinder struct {
	List *[]int
}

// 初始化
func Constructor() MedianFinder {
	return MedianFinder{&[]int{}}
}

// 二分查找
func (this *MedianFinder) AddNum(num int) {
	list := this.List
	left, right, mid := 0, len(*list)-1, 0
	for left <= right {
		mid = (right-left)/2 + left
		if num < (*list)[mid] {
			right = mid - 1
		} else if num > (*list)[mid] {
			left = mid + 1
		} else {
			left = mid
			break
		}
	}

	if len(*list) > 0 {
		temp := make([]int, len(*list)-left)
		copy(temp, (*list)[left:])
		*list = append((*list)[0:left], num)
		*list = append(*list, temp...)
	} else {
		*list = append(*list, num)
	}
}
func (this *MedianFinder) FindMedian() float64 {
	if len(*this.List) == 0 {
		return 0
	}
	i := len(*this.List) / 2
	if len(*this.List)&1 == 1 {
		return float64((*this.List)[i])
	} else {
		return float64((*this.List)[i]+(*this.List)[i-1]) / 2
	}
}

func main() {
	finder := Constructor()
	finder.AddNum(6)
	fmt.Println(finder.FindMedian())
	finder.AddNum(10)
	fmt.Println(finder.FindMedian())
	finder.AddNum(2)
	fmt.Println(finder.FindMedian())
	finder.AddNum(6)
	fmt.Println(finder.FindMedian())
	finder.AddNum(5)
	fmt.Println(finder.FindMedian())
}
