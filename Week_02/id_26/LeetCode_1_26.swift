class Solution {
    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        var hashMap: [Int: Int] = [:]
        for (index, value) in nums.enumerated() {
            if hashMap[value] != nil {
                return [hashMap[value]!, index]
            } else {
                hashMap[target - value] = index
            }
        }
        return []
    }
}
