class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) {
            return "";
        }

        HashMap<Character, Integer> charFrequency = new HashMap<>();

        for(char ch : t.toCharArray()) {
            charFrequency.put(ch, charFrequency.getOrDefault(ch, 0)+1);
        }

        int required = charFrequency.size();

        int left = 0;
        int right = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int gotSoFar = 0;

        while(left <= right && right < s.length()) {
            char charToInclude = s.charAt(right);
            if(charFrequency.containsKey(charToInclude)) {
                charFrequency.put(charToInclude, charFrequency.getOrDefault(charToInclude, 0)-1);
                if(charFrequency.get(charToInclude) == 0) {
                    gotSoFar++;
                }
            }
            while(required == gotSoFar && left <= right) {
                int currentWindow = right - left + 1;
                if(currentWindow < minLen) {
                    start = left;
                    minLen = currentWindow;
                }
                char charToExclude = s.charAt(left);
                if(charFrequency.containsKey(charToExclude)) {
                    if(charFrequency.get(charToExclude) == 0) {
                        gotSoFar--;
                    }
                    charFrequency.put(charToExclude, charFrequency.getOrDefault(charToExclude, 0)+1);
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start+minLen);
    }
}
