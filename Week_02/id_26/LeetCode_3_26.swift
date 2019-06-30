class Solution {
    func lengthOfLongestSubstring(_ s: String) -> Int {
        guard !s.isEmpty else {
            return 0
        }
        var maxlength = Int.min
        var i = 0, j = 0
        var indexArray = [Int?](repeating: nil, count: 255)
        for char in s {
            guard let asc = char.asciiValue else {
                return 0
            }
            let xb = Int(asc)
            if let index = indexArray[xb] {
                i = max(index, i)
            }
            indexArray[xb] = j + 1
            maxlength = max(maxlength, j - i + 1)
            j += 1
        }
        return maxlength
    }
}
