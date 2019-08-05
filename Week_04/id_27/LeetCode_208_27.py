import collections

class TrieNode:
    def __init__(self):
        # self.data = data
        self.children = collections.defaultdict(TrieNode)
        self.isEndingChar = False

    # def __str__(self):
    #     return  "'%s'" % self.data


class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        p = self.root
        for i in word:
            print(p.children[i])
            p = p.children[i]
        p.isEndingChar = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        p = self.root
        for i in word:
            p = p.children.get(i)
            if p == None:
                return False

        return p.isEndingChar


    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """

        p = self.root
        for i in prefix:
            p = p.children.get(i)
            if p == None:
                return False
        return True


if __name__ == "__main__":
    a = Trie()
    a.insert("hello")
    print(a.startsWith("helloa"))

