class Solution {
    func longestWord(_ words: [String]) -> String {
        guard words.count > 0 else {
            return ""
        }
        var ans = ""
        let wordSet = Set(words)
        for word in words {
            if word.count < ans.count || (word.count == ans.count && word > ans) {
                continue
            }
            var ok = true
            for i in 1...word.count {
                // not meet the demand
                if !wordSet.contains(String(word.prefix(i))) {
                    ok = false
                    break
                }
            }
            if ok {
                ans = word
            }
        }
        return ans
    }
}
