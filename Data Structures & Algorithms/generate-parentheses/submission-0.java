class Solution {
    List<String> result = new ArrayList<>();
    StringBuilder strB = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        backtrack(n, 0);
        return result;
    }

    public void backtrack(int n, int open) {
        if(n == 0 && open == 0) {
            result.add(strB.toString());
            return;
        }
        if(n > 0) {
            strB.append('(');
            backtrack(n-1, open+1);
            strB.deleteCharAt(strB.length()-1);
        }
        if(open > 0) {
            strB.append(')');
            backtrack(n, open-1);
            strB.deleteCharAt(strB.length()-1);
        }
    }
}
