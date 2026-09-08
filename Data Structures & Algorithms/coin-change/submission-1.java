class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        topDown(coins, amount, dp);
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }

    public int topDown(int[] coins, int amount, int[] dp) {
        if(amount < 0) {
            return Integer.MAX_VALUE;
        }
        if(dp[amount] != -1) {
            return dp[amount];
        }

        int min = Integer.MAX_VALUE;
        for(int coin : coins) {
            if(amount - coin < 0) {
                continue;
            }
            int sub = topDown(coins, amount - coin, dp);
            if(sub != Integer.MAX_VALUE) {
                min = Math.min(min, 1+sub);
            }
        }
        dp[amount] = min;
        return dp[amount];
    }
}
