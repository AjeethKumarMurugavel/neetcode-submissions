class PrefixTree {

    private Trie root;

    class Trie {
        Trie[] node = new Trie[26];
        boolean isEnd;
    }

    public PrefixTree() {
         root = new Trie();
    }

    public void insert(String word) {
        Trie child = root;
        for(char ch : word.toCharArray()) {
            if(child.node[ch - 'a'] == null) {
                child.node[ch - 'a'] = new Trie();
            }
            child = child.node[ch - 'a'];
        }
        child.isEnd = true;
    }

    public boolean search(String word) {
        Trie child = root;
        for(char ch : word.toCharArray()) {
            if(child.node[ch - 'a'] != null) {
                child = child.node[ch - 'a'];
            } else {
                return false;
            }
        }
        return child.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie child = root;
        for(char ch : prefix.toCharArray()) {
            if(child.node[ch - 'a'] != null) {
                child = child.node[ch - 'a'];
            } else {
                return false;
            }
        }
        return true;
    }
}
