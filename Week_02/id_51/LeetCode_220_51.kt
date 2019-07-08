class Solution {
    fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
        val treeSet = sortedSetOf<Int>()

        for (i in 0 until nums.size) {
            val num = nums[i]
            val ceiling = treeSet.ceiling(num)?.toLong()
            if (ceiling != null && ceiling - num.toLong() <= t.toLong()) return true
            val floor = treeSet.floor(num)?.toLong()
            if (floor != null && num.toLong() - floor <= t.toLong()) return true
            treeSet.add(num)
            if (treeSet.size > k) treeSet.remove(nums[i - k])
        }

        return false
    }
}
