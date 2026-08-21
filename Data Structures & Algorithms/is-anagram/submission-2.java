class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> charFrequency = new HashMap<>();

        for(char ch : s.toCharArray()) {
            charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) + 1);
        }

        for(char ch : t.toCharArray()) {
            if(!charFrequency.containsKey(ch)){
                return false;
            }
            charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) - 1);
            if(charFrequency.get(ch) == 0) {
                charFrequency.remove(ch);
            }
        }

        return charFrequency.isEmpty();
        
    }
}
