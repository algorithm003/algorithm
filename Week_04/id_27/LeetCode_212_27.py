import collections
class TrieNode:
    def __init__(self):
        self.children = collections.defaultdict(TrieNode)
        self.isEndingChar = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for i in word:
            node = node.children[i]
        node.isEndingChar = True

    def search(self, word):
        node = self.root
        for i in word:
            node = node.children.get(i)
            if node == None:
                return False
        return node.isEndingChar

class Solution:
    def findWords(self, board: [[str]], words: [str]) -> [str]:
        trie = Trie()
        node = trie.root
        res = []
        for i in words:
            trie.insert(i)
        for x in range(len(board)):
            for y in range (len(board[0])):
                self.dfs(board, node, x, y, "", res)
        return res

    def dfs(self, board, node, x, y, str, res):
        if node.isEndingChar:
            res.append(str)
            node.isEndingChar = False
        if x < 0 or x > len(board) or y < 0 or y > len(board[0]):
            return
        temp = board[x][y]
        node = node.children.get(temp)
        if not node:
            return
        board[x][y] = "#"
        self.dfs(board, node, x - 1, y, str+temp, res)
        self.dfs(board, node, x + 1, y, str+temp, res)
        self.dfs(board, node, x, y - 1, str+temp, res)
        self.dfs(board, node, x, y + 1 , str+temp, res)