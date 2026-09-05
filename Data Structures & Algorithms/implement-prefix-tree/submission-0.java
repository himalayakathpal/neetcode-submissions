class TrieNode {
    TrieNode[] children;
    boolean isTerminal;
    TrieNode() {
        children = new TrieNode[26];
        isTerminal = false;
    }
}
class PrefixTree {

    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    private void insertAtNode(TrieNode node, String word) {
        if (word.length() == 0) {
            node.isTerminal = true;
            return;
        }
        node.children[word.charAt(0)-'a'] = new TrieNode();
        insertAtNode(node.children[word.charAt(0)-'a'], word.substring(1));

    }

    public void insert(String word) {
        TrieNode temp = root;
        int index = 0;
        char tempC = word.charAt(index);
        while(temp.children[tempC-'a']!=null) {
            if (index == word.length()-1 && temp.children[tempC-'a'].isTerminal) return;
            if (index == word.length()-1) {
                temp.children[tempC-'a'].isTerminal = true; 
                return;
            }
            temp = temp.children[tempC-'a'];
            index++;
            tempC = word.charAt(index);
        }
        insertAtNode(temp,word.substring(index));
    }

    public boolean search(String word) {
        TrieNode temp = root;
        int index = 0;
        char tempC = word.charAt(index);
        while(temp.children[tempC-'a']!=null) {
            if (index == word.length()-1 && temp.children[tempC-'a'].isTerminal) return true;
            if (index == word.length()-1) return false;
            temp = temp.children[tempC-'a'];
            index++;
            tempC = word.charAt(index);
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        int index = 0;
        char tempC = prefix.charAt(index);
        while(temp.children[tempC-'a']!=null) {
            if (index == prefix.length()-1) return true;
            temp = temp.children[tempC-'a'];
            index++;
            tempC = prefix.charAt(index);
        }
        return false;
    }
}
