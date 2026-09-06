class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.length() != endWord.length()) {
            return 0;
        }
        HashSet<String> wordMap = new HashSet<>(wordList);
        if(!wordMap.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int level = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                String word = queue.poll();
                if(word.equals(endWord)) {
                    return level;
                }
                char[] wordChar = word.toCharArray();
                for(int j=0; j<wordChar.length; j++) {
                    char original = wordChar[j];
                    for(char c='a'; c<='z'; c++) {
                        wordChar[j] = c;
                        String candidate = new String(wordChar);
                        if(wordMap.contains(candidate)) {
                            queue.offer(candidate);
                            wordMap.remove(candidate);
                        }
                    }
                     wordChar[j] = original;
                }
            }
            level++;
        }

        return 0;
    }
}
