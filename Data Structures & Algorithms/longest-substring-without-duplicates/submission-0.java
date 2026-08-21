class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> visited = new HashMap<>();

        if(s.length() <= 1){
            return s.length();
        }

        int left = 0;
        int maxLen = 0;
        for(int right = 0; right < s.length(); right++) {
            char character = s.charAt(right);
            if(visited.containsKey(character)) {
                left = Math.max(visited.get(character)+1, left);
            }
            visited.put(character, right);
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}
