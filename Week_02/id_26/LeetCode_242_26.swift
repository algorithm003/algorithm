class Solution {
    func isAnagram(_ s: String, _ t: String) -> Bool {
        // border
        guard s.count == t.count else {
            return false
        }
        var charsDict: [Character: Int] = [:]
        for c in s {
            charsDict[c, default: 0] += 1
        }
        
        for c in t {
            charsDict[c, default: 0] -= 1 
            if charsDict[c, default: 0] < 0 {
                return false
            }
        }
        return true
    }
}
