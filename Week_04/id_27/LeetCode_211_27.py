import collections

class TrieNode:
    def __init__(self):
        self.children = collections.defaultdict(TrieNode)
        self.isEndingChar = False

class WordDictionary:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()


    def addWord(self, word: str) -> None:
        """
        Adds a word into the data structure.
        """
        p = self.root
        for i in word:
            p = p.children[i]
        p.isEndingChar = True



    def search(self, word: str) -> bool:
        """
        Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
        """
        p = self.root
        self.res = False
        self.dfs(p, word)
        return self.res

    def dfs(self, node, word):
        if not word:
            if node.isEndingChar:
                self.res = True
            return
        if word[0] == ".":
            for n in node.children.values():
                self.dfs(n, word[1:])
        else:
            node = node.children.get(word[0])
            if not node:
                return
            self.dfs(node, word[1:])

if __name__ == "__main__":
    a = WordDictionary()
    a.addWord("hello")
    print (a.search(".ello"))
    # print(a.search(".ello"))