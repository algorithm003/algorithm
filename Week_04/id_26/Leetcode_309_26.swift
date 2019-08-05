class Solution {
    func maxProfit(_ prices: [Int]) -> Int {
        guard prices.count >= 2 else {
            return 0
        }
        // define the formula
        var hold = [Int](repeating: Int.min, count: prices.count)
        var rest = [Int](repeating: Int.min, count: prices.count)
        var sold = [Int](repeating: Int.min, count: prices.count)
        hold[0] = -prices[0]
        rest[0] = 0
        var length = prices.count
        for i in 1..<length {
            hold[i] = max(hold[i - 1], rest[i - 1] - prices[i])
            rest[i] = max(sold[i - 1], rest[i - 1])
            sold[i] = hold[i - 1] + prices[i]
        }
        return max(rest[length - 1], sold[length - 1])
    }
}
