class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;

        // dp[col] = best total score achievable from the current row onward,
        // if you land in this column for the current row.
        long[] dp = new long[n];
        for (int col = 0; col < n; col++) {
            dp[col] = points[m - 1][col];  // base case: last row, no penalty yet
        }

        // Process rows from second-to-last up to the first
        for (int row = m - 2; row >= 0; row--) {
            long[] newDp = new long[n];

            // leftMax[col] will hold: max over i <= col of (dp[i] + i)
            long[] leftMax = new long[n];
            leftMax[0] = dp[0] + 0;
            for (int col = 1; col < n; col++) {
                leftMax[col] = Math.max(leftMax[col - 1], dp[col] + col);
            }

            // rightMax[col] will hold: max over i >= col of (dp[i] - i)
            long[] rightMax = new long[n];
            rightMax[n - 1] = dp[n - 1] - (n - 1);
            for (int col = n - 2; col >= 0; col--) {
                rightMax[col] = Math.max(rightMax[col + 1], dp[col] - col);
            }

            // Combine: for each col, best "incoming" value considering both directions
            for (int col = 0; col < n; col++) {
                long best = Math.max(
                    leftMax[col] - col,   // best from the left side: (dp[i]+i) - col
                    rightMax[col] + col   // best from the right side: (dp[i]-i) + col
                );
                newDp[col] = points[row][col] + best;
            }

            dp = newDp;
        }

        long ans = 0;
        for (int col = 0; col < n; col++) {
            ans = Math.max(ans, dp[col]);
        }
        return ans;
    }
}