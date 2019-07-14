//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
//
// 示例:
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");
//trie.search("app");     // 返回 true
//
// 说明:
//
//
// 你可以假设所有的输入都是由小写字母 a-z 构成的。
// 保证所有输入均为非空字符串。
//
//

/**
 * Initialize your data structure here.
 */
class Trie {
  constructor() {
    // 初始化字典树的根节点
    this.root = {}
  }
  insert(word) {
    let curr = this.root
    word.split('').forEach(ch => {
      // 构建一个字典树
      // curr.a = {} -> curr.a.p = {} -> curr.a.p.p = {}
      curr[ch] = curr[ch] || {}
      // curr = curr.a -> curr = curr.a.p -> curr = curr.a.p.p
      curr = curr[ch]
      return curr
      // return curr = curr[ch] = curr[ch] || {}
    })
    curr.isWord = true
  }
  traverse(word) {
    // 匹配
    let curr = this.root
    for (let i = 0; i < word.length; i++) {
      if (!curr) return null
      // 返回每个字符的子树
      curr = curr[word[i]]
    }
    return curr
  }
  search(word) {
    let node = this.traverse(word)
    // !!常常用来做类型判断，在第一步!（变量）之后再做逻辑取反运算
    // 双重否定等于肯定
    return !!node && !!node.isWord
  }
  startsWith(word) {
    return !!this.traverse(word)
  }
}

let trie = new Trie();
trie.insert("apple")
console.log(trie.search("apple"));  // 返回 true
console.log(trie.search("app"));    // 返回 false
console.log(trie.startsWith("app")); // 返回 true
trie.insert("app")
console.log(trie.search("app"));     // 返回 true
