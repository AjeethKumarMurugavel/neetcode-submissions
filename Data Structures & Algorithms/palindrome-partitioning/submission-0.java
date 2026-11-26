class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> subSet = new ArrayList<>();
        addSub(s, 0, result, subSet);
        return result;
    }

    public void addSub(String s, int idx, List<List<String>> result, List<String> subSet) {
        if(idx == s.length()) {
            result.add(new ArrayList<>(subSet));
        }
        for(int i=idx; i<s.length(); i++) {
            boolean added = isPalindrome(s.substring(idx, i+1));
            if(added) {
                subSet.add(s.substring(idx, i+1));
                addSub(s, i+1, result, subSet);
            }
            if(added) {
                subSet.remove(subSet.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            if(s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
