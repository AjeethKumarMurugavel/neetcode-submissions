class Solution {
    
    public boolean dfs(HashMap<Character, Set<Character>> adjMap, HashMap<Character, Integer> visiting, char ch) {
        if(visiting.containsKey(ch) && visiting.get(ch) == 1) {
            return false;
        }
        if(visiting.containsKey(ch) && visiting.get(ch) == 2) {
            return true;
        }

        visiting.put(ch, 1);
        for(char neighbors : adjMap.get(ch)) {
            if(!(dfs(adjMap, visiting, neighbors))) {
                return false;
            }
        }
        result[--toBeProcessed] = ch;
        visiting.put(ch, 2);
        return true;
    }
    
    char[] result;
    int toBeProcessed;
    public String foreignDictionary(String[] words) {
        HashMap<Character, Set<Character>> adjList = new HashMap<>();

        for(String word : words) {
            for(char ch : word.toCharArray()) {
                adjList.computeIfAbsent(ch , k -> new HashSet<>());
            }
        }
        
        for(int i=0; i<words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];

            int minLen = Math.min(word1.length(), word2.length());

            if(word1.length() > word2.length() && word1.substring(0, minLen).equals(word2.substring(0, minLen))) {
                return "";
            }

            char[] w1 = word1.toCharArray();
            char[] w2 = word2.toCharArray();
            for(int j=0; j<minLen; j++) {
                if(w1[j] != w2[j]) {
                    adjList.computeIfAbsent(w1[j], k-> new HashSet<>()).add(w2[j]);
                    break;
                }
            }
        }

        toBeProcessed = adjList.size();
        result = new char[toBeProcessed];

        HashMap<Character, Integer> visiting = new HashMap<>();
        for(char ch : adjList.keySet()) {
            if(!dfs(adjList, visiting, ch)) {
                return "";
            }
        }

        return new String(result);
    }
}
