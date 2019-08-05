//设计一个支持以下两种操作的数据结构：
//
// void addWord(word)
//bool search(word)
//
//
// search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
//
// 示例:
//
// addWord("bad")
//addWord("dad")
//addWord("mad")
//search("pad") -> false
//search("bad") -> true
//search(".ad") -> true
//search("b..") -> true
//
//
// 说明:
//
// 你可以假设所有单词都是由小写字母 a-z 组成的。
//

/**
 * Initialize your data structure here.
 */

/**
 * Adds a word into the data structure.
 * @param {string} word
 * @return {void}
 */

/**
 * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
 * @param {string} word
 * @return {boolean}
 */

/**
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = new WordDictionary()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */

// 时间复杂度（complexity）：
// 最好为 O(n)：n是字符的长度，没有.的情况直接搜索树
// 最坏为 O(26^m * n)：n是字符的长度，m是.的数量

function TrieWord() {
  this.children = {}
  this.isEnd = false
}

class WordDictionary {
  constructor() {
    this.root = new TrieWord()
  }
  addWord(word) {
    let current = this.root
    for (let i = 0; i < word.length; i++) {
      if (!(word[i] in current.children)) {
        current.children[word[i]] = new TrieWord()
      }
      current = current.children[word[i]]
    }
    current.isEnd = true
  }
  traverse(word, current, level) {
    if (!current || (level === word.length && !current.isEnd)) {
      return false
    }
    if (level === word.length && current.isEnd) {
      return true
    }
    if (word[level] === '.') {
      for (let i = 0; i < 26; i++) {
        let ch = String.fromCharCode(97 + i)
        // ！！有.的地方，从.开始继续把后面的字符压进去，可获取后面的字符的父节点
        if (this.traverse(word, current.children[ch], level + 1)) {
          return true
        }
      }
      return false
    }
    // 非.的字符的处理
    return this.traverse(word, current.children[word[level]], level + 1)
  }
  search(word) {
    return this.traverse(word, this.root, 0)
  }
}

let wordDictionary = new WordDictionary()
const opera = ["addWord","addWord","addWord","addWord","search","search","addWord","search","search","search","search","search","search"]
const data = [["at"],["and"],["an"],["add"],["a"],[".at"],["bat"],[".at"],["an."],["a.d."],["b."],["a.d"],["."]]
for (let i = 0; i < opera.length; i++) {
  console.log(wordDictionary[opera[i]](data[i][0]))
}
