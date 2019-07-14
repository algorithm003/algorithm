public class LeetCode_720_16 {
    class TrieNode {
        public TrieNode[] next = new TrieNode[26];
        public boolean isWord = false;
        public char character;

        public TrieNode(char character) {
            this.character = character;
        }
    }

    class Trie {
        public TrieNode root = new TrieNode('/');

        public void insert(String word) {
            TrieNode p = root;
            char[] c = word.toCharArray();
            for (int i=0; i < c.length; i ++) {
                int index = c[i] - 'a';
                if(p.next[index] == null) {
                    p.next[index] = new TrieNode(c[i]);
                }
                p = p.next[index];
            }
            p.isWord = true;
        }

        public boolean isValidWord(String word) {
            TrieNode p = root;
            char[] c = word.toCharArray();
            for (int i=0; i < c.length; i ++) {
                int index = c[i] - 'a';
                if (!p.next[index].isWord) {
                    return false;
                } else {
                    p = p.next[index];
                }
            }
            return true;
        }
    }

    public String longestWord(String[] words) {
        if (words == null || words.length == 0) {
            return new String();
        }

        Trie trie = new Trie();

        for (String word : words) {
            trie.insert(word);
        }

        int longestLen = 0;
        String longestWord = "";
        for (String word : words) {
            if (trie.isValidWord(word) && word.length() > longestLen) {
                longestLen = word.length();
                longestWord = word;
            } else if (trie.isValidWord(word) && word.length() == longestLen) {
                char[] wordChar = word.toCharArray();
                char[] longestChar = longestWord.toCharArray();
                for (int i=0; i < word.length(); i ++) {
                    if (wordChar[i] - longestChar[i] < 0) {
                        longestWord = word;
                        break;
                    } else if (wordChar[i] - longestChar[i] > 0) {
                        break;
                    }
                }
            }
        }

        return longestWord;
    }
}
