func lengthOfLongestSubstring(s string) int {
    
    index := make(map[rune]int, len(s))
    
    for _, v := range s {
        index[v] = -1
    }
    
    pre, res := -1, 0
    
    for i, v := range s {
        pre = max(pre, index[v])
        res = max(res, i-pre)
        index[v] = i
    }
    
    return res    
}

func max(a, b int) int {
    if a > b {
        return a 
    }
    
    return b
}
