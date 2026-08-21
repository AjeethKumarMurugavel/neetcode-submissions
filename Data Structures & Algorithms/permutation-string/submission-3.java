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

        int matches = 0;
        for(int i=0; i<26; i++) {
            if(need[i] == have[i]){
                matches++;
            }
        }
        if(matches == 26) {
            return true;
        }

        int windowSize = s1.length();
        for(int i=s1.length(); i<s2.length(); i++) {
            int indexToAdd = s2.charAt(i) - 'a';
            int indexToRemove = s2.charAt(i - windowSize) - 'a';
            if(have[indexToAdd] == need[indexToAdd]) {
                matches--;
            } 
            have[indexToAdd]++;
            if(have[indexToAdd] == need[indexToAdd]) {
                matches++;
            } 
            if(have[indexToRemove] == need[indexToRemove]) {
                matches--;
            } 
            have[indexToRemove]--;
            if(have[indexToRemove] == need[indexToRemove]) {
                matches++;
            } 
            if(matches == 26) {
                return true;
            }
        }

        return false;
    }
}
