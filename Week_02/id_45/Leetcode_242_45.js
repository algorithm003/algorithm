/**
  *    @answer jhwong
  * 
  *   242. 有效的字母异位词
  *   给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

      示例 1:

      输入: s = "anagram", t = "nagaram"
      输出: true
      示例 2:

      输入: s = "rat", t = "car"
      输出: false
      说明:
      你可以假设字符串只包含小写字母。

      进阶:
      如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

  *
  *    学号：045
  *
  * */


/**
 * 先排序然后再toString后对比两个字符串是否相等
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
const isAnagram = (s, t) => [...s].sort().toString() == [...t].sort().toString()


/**
  先创建字母表,遍历两个字符串,对出现的字母进行加减计数,如果字母表所有计数都为 0 则表示这两个字符串为异位词
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
const isAnagram = (s, t) => {
  if (s.length != t.length) return false
  const countW = new Int8Array(26)
  s.split('').forEach((item,i) => (countW[item.charCodeAt() - 97]++ , countW[t[i].charCodeAt() - 97]--))
  return countW.filter(item => item).length == 0
}