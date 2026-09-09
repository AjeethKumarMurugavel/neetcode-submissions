class Solution {
    int[][] dp;
    int ROWS;
    int COLS;
    public int minPathSum(int[][] grid) {
        ROWS = grid.length;
        if(ROWS <= 0) {
            return 0;
        }
        COLS = grid[0].length;
        dp = new int[ROWS][COLS];
        for(int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        return findMinSum(grid, 0, 0);
    }

    public int findMinSum(int[][] grid, int row, int col) {
        if(row >= ROWS || col >= COLS) {
            return Integer.MAX_VALUE;
        }
        if(row == ROWS-1 && col == COLS-1) {
            return grid[row][col];
        }
        if(dp[row][col] != -1) {
            return dp[row][col];
        }
        int right = findMinSum(grid, row, col+1);
        int bottom = findMinSum(grid, row+1, col);
        dp[row][col] = grid[row][col] + Math.min(right, bottom);
        return dp[row][col];
    }
}