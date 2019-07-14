//给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
//
//
//示例:
//输入: S = "a1b2"
//输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
//
//输入: S = "3z4"
//输出: ["3z4", "3Z4"]
//
//输入: S = "12345"
//输出: ["12345"]
//
//
// 注意：
//
//
// S 的长度不超过12。
// S 仅由数字和字母组成。
//
//

/**
 * @param {string} S
 * @return {string[]}
 */
var letterCasePermutation = function(S) {
  let res = []
  dfs(S.split(''), 0)
  return res

  function dfs(s, i) {
    if (i == s.length) {
      res.push(String.fromCharCode(s.join(',')))
      return
    }
    dfs(s, i + 1, res)
    if (s[i] < '0' || s[i] > '9') {
      console.log(s[i]);
      s[i] = s[i].charCodeAt(0)
      s[i] ^= (1 << 5)
      dfs(s, i + 1, res)
    }
  }
};

const S = "a1b2"
console.log(letterCasePermutation(S));
