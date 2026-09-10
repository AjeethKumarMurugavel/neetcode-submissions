class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();

        int[] dp = new int[l2+1];

        char[] ch1 = text1.toCharArray();
        char[] ch2 = text2.toCharArray();

        for(int c1 : ch1) {
            int prev = 0;
            for(int j=1; j<=l2; j++) {
                int temp = dp[j];
                dp[j] = c1 == ch2[j-1] ? 1 + prev : Math.max(dp[j], dp[j-1]);
                prev = temp;
            }
        }

        return dp[l2];
    }
}
