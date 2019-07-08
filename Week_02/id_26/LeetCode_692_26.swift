class Solution {
    func topKFrequent(_ words: [String], _ k: Int) -> [String] {
        var map: [String: Int] = [:]
        for (_, word) in words.enumerated() {
            map[word, default: 0] += 1
        }

        return Array(Array(map.keys).sorted {
            return $0 < $1
            }.sorted { (str1, str2) -> Bool in
                return map[str1]! > map[str2]!
        }.prefix(k))
    }
}
