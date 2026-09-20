class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i=0; i<strs.length; i++) {
            char[] chArr = strs[i].toCharArray();
            Arrays.sort(chArr);
            String sortedString = new String(chArr);
            map.computeIfAbsent(sortedString, k -> new ArrayList()).add(strs[i]);
        }

        List<List<String>> result = new ArrayList<>();
        for(String str : map.keySet()) {
            result.add(map.get(str));
        }

        return result;
    }
}
