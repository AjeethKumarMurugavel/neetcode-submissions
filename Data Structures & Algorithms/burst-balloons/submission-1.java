class Solution {
    int[][] dp;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] baloons = new int[n+2];
        baloons[0] = 1;
        for(int i=1; i<=n; i++) {
            baloons[i] = nums[i-1];
        }
        baloons[n+1] = 1;
        dp = new int[n+1][n+1];

        for(int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        return recurse(baloons, 1, n);
    }

    public int recurse(int[] baloons, int start, int end) {
        if(start > end) {
            return 0;
        }

        if(dp[start][end] != -1) {
            return dp[start][end];
        }

        int maxCost = 0;
        //1,2,3,4,5,6
        for(int last = start; last <= end; last++) {
            int cost = (baloons[start-1] * baloons[last] * baloons[end+1]) + recurse(baloons, start, last-1) + recurse(baloons, last+1, end);
            maxCost = Math.max(maxCost, cost);
        }
        dp[start][end] = maxCost;
        return dp[start][end];
    }
}