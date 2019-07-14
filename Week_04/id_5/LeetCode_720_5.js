//给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
//
// 若无答案，则返回空字符串。
//
// 示例 1:
//
//
//输入:
//words = ["w","wo","wor","worl", "world"]
//输出: "world"
//解释:
//单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
//
//
// 示例 2:
//
//
//输入:
//words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//输出: "apple"
//解释:
//"apply"和"apple"都能由词典中的单词组成。但是"apple"得字典序小于"apply"。
//
//
// 注意:
//
//
// 所有输入的字符串都只包含小写字母。
// words数组长度范围为[1,1000]。
// words[i]的长度范围为[1,30]。
//
//

/**
 * @param {string[]} words
 * @return {string}
 */
// 时间复杂度：O(nlognL)，n是数组长度，L是单词的平均长度
// 空间复杂度： O(n*L)
var longestWord = function(words) {
  // 按字符串长度进行前缀排序
  [...words.sort()]
  let build = new Set()
  let res = ''
  for (let item of words) {
    // 过滤非数组前面的元素（前缀）能组成的单词
    // 判断非空单词（或前缀）
    if (item.length === 1 || build.has(item.substring(0, item.length - 1))) {
      res = item.length > res.length ? item : res
      // 添加到前缀表中
      build.add(item)
    }
  }
  return res
};

let words = ["w","wo","worl","wor", "what", "world"]
console.log(longestWord(words));
