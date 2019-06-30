func isAnagram(s string, t string) bool {
    
    if len(s) != len(t) {
        return false
    }
    
    count := make(map[rune]int, len(s))
    
    for _, v := range s {
        count[v]++
    }
    
    for _, v := range t {
        count[v]--
        if count[v] < 0 {
            return false
        }
    }
    
    return true
}
