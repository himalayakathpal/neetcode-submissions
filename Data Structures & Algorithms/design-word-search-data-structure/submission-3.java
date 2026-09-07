class TrieNode {
    TrieNode[] children;
    boolean isTerminal;
    TrieNode() {
        children = new TrieNode[26];
        isTerminal = false;
    }
}
class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c: word.toCharArray()) {
            if (curr.children[c-'a']==null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];                            
        }
        curr.isTerminal = true;
    }

    public boolean searchHelper(TrieNode root, String word, int i) {
        if (i == word.length() && root.isTerminal) return true;
        if (i == word.length()) return false;
        if (word.charAt(i) == '.') {
            for (int j=0;j<26;j++) {
                if (root.children[j]!= null && searchHelper(root.children[j], word, i+1)) return true;
            }
        } else {
            if (root.children[word.charAt(i)-'a'] == null) return false;
            return searchHelper(root.children[word.charAt(i)-'a'], word, i+1);
        }
        return false;

    }

    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }
}
