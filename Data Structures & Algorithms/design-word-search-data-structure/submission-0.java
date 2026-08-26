class WordDictionary {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    TrieNode dictionary;
    public WordDictionary() {
        dictionary = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode root = dictionary;
        for(char ch : word.toCharArray()) {
            if(root.children[ch - 'a'] == null) {
                root.children[ch - 'a'] = new TrieNode();
            }
            root = root.children[ch - 'a'];
        }
        root.isEnd = true;
    }

    public boolean search(String word) {
        return search(word, dictionary);
    }

    public boolean search(String word, TrieNode root) {
        for(int idx=0; idx<word.length(); idx++) {
            char ch = word.charAt(idx);
            if(ch == '.') {
                String subString = word.substring(idx+1);
                for(int i=0; i<26; i++) {
                    if(root.children[i] != null) {
                        if(search(subString, root.children[i])) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                if(root.children[ch - 'a'] == null) {
                    return false;
                }
                root = root.children[ch - 'a'];
            }
        }
        return root.isEnd;
    }
}
