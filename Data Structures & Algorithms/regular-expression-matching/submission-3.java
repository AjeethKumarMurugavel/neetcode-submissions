class Solution {
    Boolean[][] memo;
    
    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];  // +1 on both dimensions
        return patternMatch(s, p, 0, 0);
    }

    public boolean patternMatch(String s, String p, int i, int j) {
        if (i >= s.length() && j >= p.length()) {
            return true;
        }
        if (j >= p.length()) {
            return false;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        boolean isDot = p.charAt(j) == '.';
        boolean match = (i < s.length() && (s.charAt(i) == p.charAt(j) || isDot));

        boolean result;
        if ((j + 1) < p.length() && p.charAt(j + 1) == '*') {
            result = patternMatch(s, p, i, j + 2) || (match && patternMatch(s, p, i + 1, j));
        } else if (match) {
            result = patternMatch(s, p, i + 1, j + 1);
        } else {
            result = false;
        }

        memo[i][j] = result;
        return result;
    }
}