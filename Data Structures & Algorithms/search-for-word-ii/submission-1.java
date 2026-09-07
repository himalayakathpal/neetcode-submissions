class TrieNode {
    TrieNode[] children;
    boolean isTerminal;
    TrieNode() {
        children = new TrieNode[26];
        isTerminal = false;
    }
}

class Solution {
    TrieNode root;
    Set<String> result;
    StringBuilder sb; 
    private static int[][] options = {{0,1},{0,-1},{1,0},{-1,0}};
    private void dfs(int i, int j, char[][] board, boolean[][] visited) {
        visited[i][j] = true;
        sb.append(board[i][j]);
        if (!startsWith(sb)) {
            sb.deleteCharAt(sb.length()-1);
            visited[i][j] = false;
            return;
        }
        if (search(sb.toString())) {
            result.add(new String(sb));
        }
        for (int[] option: options) {
            int newx = option[0] + i;
            int newy = option[1] + j;
            if (newx>=0 && newx<board.length && newy>=0 && newy<board[0].length && !visited[newx][newy]) {
                dfs(newx,newy, board, visited);
            }
        }

        visited[i][j] = false;
        sb.deleteCharAt(sb.length()-1);
    }
    public boolean startsWith(StringBuilder prefix) {
        if (prefix.length() == 0) return true;
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
    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) {
                cur.children[i] = new TrieNode();
            }
            cur = cur.children[i];
        }
        cur.isTerminal = true;
    }
    public List<String> findWords(char[][] board, String[] words) {
        result = new HashSet<>();
        root = new TrieNode();
        for (String word: words) {
            insert(word);
        }
        sb = new StringBuilder(); 
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                dfs(i, j, board, visited);
            }
        }
        return new ArrayList<>(result);
    }
}
