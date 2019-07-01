/**
 * 排列硬币
 * 链接： https://leetcode-cn.com/problems/arranging-coins/description/
 */
class Solution {
    public int arrangeCoins(int n) {
        return (int)Math.floor(Math.sqrt(2.0 * n + 0.25) - 0.5);
    }
}
/**
 * 思考：高中常用的等差数列求和
 */