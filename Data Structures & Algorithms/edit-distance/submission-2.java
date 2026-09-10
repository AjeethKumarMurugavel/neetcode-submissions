class Solution {
    int L1;
    int L2;
    int[][] dp;
    public int minDistance(String word1, String word2) {
        L1 = word1.length();
        L2 = word2.length();
        int[][] dp = new int[L1+1][L2+1];

        // for(int[] rows : dp) {
        //     Arrays.fill(rows, -1);
        // }

        for(int i=0; i<=L1; i++) {
            dp[i][0] = i;
        }

        for(int i=0; i<=L2; i++) {
            dp[0][i] = i;
        }

        for(int i=1; i<=L1; i++) {
            for(int j=1; j<=L2; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]);
                }
            }
        }
        return dp[L1][L2];
    }
}
