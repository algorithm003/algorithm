func twoSum(nums []int, target int) []int {
 
    
    index := make(map[int]int)
    
    for i, v := range nums {
        
        if j, ok := index[target-v]; ok {
            return []int{j, i}
        }
        
        index[v] = i
    }
    
    return nil
}
