class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i=0; i<strs.length; i++) {
            char[] count = new char[26];
            for (char c : strs[i].toCharArray()) {
                count[c - 'a']++;
            }
            String sortedString = new String(count);
            map.computeIfAbsent(sortedString, k -> new ArrayList()).add(strs[i]);
        }

        List<List<String>> result = new ArrayList<>();
        for(String str : map.keySet()) {
            result.add(map.get(str));
        }

        return result;
    }
}
