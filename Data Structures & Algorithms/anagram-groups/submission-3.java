class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> anagrams = new HashMap<>();

        for(String str: strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String strSorted = new String(charArray);

            anagrams.putIfAbsent(strSorted, new ArrayList<>());
            anagrams.get(strSorted).add(str);
        }
        return new ArrayList<>(anagrams.values());

    }
}
