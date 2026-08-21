class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        int[] need = new int[26];
        int[] have = new int[26];
        HashMap<Character, Integer> charFreq = new HashMap<>();
        for(int i=0; i<s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            need[ch1 - 'a']++;
            have[ch2 - 'a']++;
        }

        if(Arrays.equals(need, have)) {
            return true;
        }

        // int matches
        // for(int i=0; i<26; i++) {

        // }

        int windowSize = s1.length();
        for(int i=s1.length(); i<s2.length(); i++) {
            have[s2.charAt(i) - 'a']++;
            have[s2.charAt(i - windowSize) - 'a']--;
            if(Arrays.equals(need, have)) {
                return true;
            }
        }

        return false;
    }
}
