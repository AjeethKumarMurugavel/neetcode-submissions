class Solution {

    class Trie {
        Trie[] children = new Trie[26];
        String word;
    }
    Trie root = new Trie();

    public void addWord(String word) {
        Trie curr = root;
        for(char ch : word.toCharArray()) {
            if(curr.children[ch-'a'] == null) {
                curr.children[ch-'a'] = new Trie();
            }
            curr = curr.children[ch-'a'];
        }
        curr.word = word;
    }
    public List<String> findWords(char[][] board, String[] words) {
        for(String word : words) {
            addWord(word);
        }

        List<String> result = new ArrayList<>();

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                search(board, i,j, root, result);
            }
        }

        return result;
    }

    public void search(char[][] board, int i, int j, Trie root, List<String> result) {
        if(i<0 || i >= board.length || j<0 || j >= board[i].length) {
            return;
        }

        if(board[i][j] == '#') {
            return;
        }

        char ch = board[i][j];
        Trie next = root.children[ch - 'a'];

        if(next == null) {
            return;
        }

        if(next.word != null) {
            result.add(next.word);
            next.word = null;
        }

         board[i][j] = '#';
        search(board, i+1, j, next, result);
        search(board, i-1, j, next, result);
        search(board, i, j+1, next, result);
        search(board, i, j-1, next, result);
         board[i][j] = ch;

    }
}
