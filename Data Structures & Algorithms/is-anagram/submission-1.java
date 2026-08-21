class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> charSet = new HashMap<>();
        for(char c : s.toCharArray()) {
            charSet.put(c, charSet.getOrDefault(c, 0) + 1);
        }

        for(char c : t.toCharArray()) {
            if(charSet.containsKey(c)) {
                int frequency = charSet.getOrDefault(c, 0);
                if(frequency <= 1) {
                    charSet.remove(c);
                } else {
                    charSet.put(c, charSet.getOrDefault(c, 0) - 1);
                }
            } else {
                return false;
            }
        }

        return charSet.isEmpty();
    }
}
