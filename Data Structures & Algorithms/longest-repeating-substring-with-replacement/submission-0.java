class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxFreq = 0;

        int left = 0;
        int maxLen = 0;
        for(int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            count[ch - 'A']++;
            maxFreq = Math.max(maxFreq, count[ch - 'A']);

            while((right -left + 1 - maxFreq) > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, (right - left + 1));
        }

        return maxLen;
    }
}
