import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetcod/
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // map不代表当前字串，而是通过i遍历将所有元素存到hash表中
        // 它的作用就时判断当前i元素是否出现过，若出现过将起最近出现的（索引+1）的值与左区间j比较取最大值
        // 以此来完成左窗口的收缩
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        int ans=0;
        // 滑动窗口[j,i)  i每次加1，j根据i元素是否在map里及其下标来决定滑动窗口的收缩情况
        for (int j=0, i = 0; i <s.length(); i++) {
            // 判断当前的元素是否在map里
            if(hashMap.containsKey(s.charAt(i))){
                // 如果查出来的元素不在[j,i)，则仍取j
                j=Math.max(j, hashMap.get(s.charAt(i)));
            }
            ans=Math.max(ans, i-j+1);
            // i+1是因为i是当前元素的索引，根据题目不能出现重复字符，区间是左闭右开
            // 所以在赋值左区间j时要跳过这个元素
            // 如果map之前存过该字符则直接覆盖原索引
            hashMap.put(s.charAt(i), i+1);
        }
        return ans;
    }
}

