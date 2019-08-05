func maxProfit(prices []int) int {
    
    rest, sold := 0, 0
    hold := -1<<31
    
    for _, v := range prices {
        tmp := sold
        sold = hold + v
        hold = max(hold, rest-v)
        rest = max(rest, tmp)
    }
    
    return max(rest, sold)
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
