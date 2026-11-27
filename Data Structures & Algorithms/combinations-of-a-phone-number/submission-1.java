class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) {
            return result;
        }
        StringBuilder combi = new StringBuilder();
        backTrack(digits, 0, result, combi);
        return result;
    }

    public void backTrack(String digits, int index, List<String> result, StringBuilder combi) {
        if(index == digits.length()) {
            result.add(combi.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        int start = (digit - 2) * 3 + (digit > 7 ? 1 : 0);
        int end = start + ((digit == 7 || digit == 9) ? 4 : 3);
        for(int j = start; j < end; j++) {
            char ch = (char)('a'+j);
            combi.append(ch);
            backTrack(digits, index+1, result, combi);
            combi.deleteCharAt(combi.length() - 1);
        }

    }
}
