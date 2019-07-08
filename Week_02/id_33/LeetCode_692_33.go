//+build ignored

package main

import (
	"fmt"
	"sort"
)

/**
692. 前K个高频单词
*/

// 自定义排序，key为map key, value为map value,必须实现Swap, Len, Less方法
// value相等按字母顺序，否则按value逆序
type Pair struct {
	Key   string
	Value int
}
type PairList []Pair

func (p PairList) Swap(i, j int) { p[i], p[j] = p[j], p[i] }
func (p PairList) Len() int      { return len(p) }
func (p PairList) Less(i, j int) bool {
	if p[i].Value == p[j].Value {
		return p[i].Key <= p[j].Key
	} else {
		return p[i].Value >= p[j].Value
	}
}

func topKFrequent(words []string, k int) []string {
	var result []string
	maps := make(map[string]int)
	for _, v := range words {
		maps[v]++
	}
	// 构造自定义集合
	p := make(PairList, len(maps))
	i := 0
	for k, v := range maps {
		p[i] = Pair{k, v}
		i++
	}
	// value相等按字母顺序，否则按value逆序
	sort.Sort(p)
	if p.Len() < k {
		k = p.Len()
	}
	// 输出前k项
	for j := 0; j < k; j++ {
		result = append(result, p[j].Key)
	}

	return result
}

func main() {
	//fmt.Println(topKFrequent([]string{"i", "love", "leetcode", "i", "love", "coding"}, 2))
	fmt.Println(topKFrequent([]string{"a", "aa", "aaa"}, 2))
}
