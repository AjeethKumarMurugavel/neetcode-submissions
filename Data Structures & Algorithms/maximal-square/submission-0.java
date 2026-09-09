class Solution {
    int[][] dp;
    int ROWS;
    int COLS;
    int maxSquare = 0;
    public int maximalSquare(char[][] matrix) {
        ROWS = matrix.length;
        if(ROWS <= 0) {
            return 0;
        }
        COLS = matrix[0].length;
        dp = new int[ROWS][COLS];
        for(int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        for(int row = 0; row < ROWS; row++) {
            for(int col = 0; col < COLS; col++) {
                if(matrix[row][col] != '0') {
                    maxSquare = Math.max(maxSquare, findSquare(matrix, row, col));
                }
            }
        }
        return maxSquare * maxSquare;
    }

    public int findSquare(char[][] matrix, int row, int col) {
        if(row < 0 || col < 0 || row >= ROWS || col >= COLS) {
            return 0;
        }
        if(dp[row][col] != -1) {
            return dp[row][col];
        }
        if(matrix[row][col] == '0') {
            dp[row][col] = 0;
        }
        if(matrix[row][col] == '1') {
            int left = findSquare(matrix, row, col-1);
            int top = findSquare(matrix, row-1, col);
            int topLeft = findSquare(matrix, row-1, col-1);
            dp[row][col] = 1 + Math.min(Math.min(left, top), topLeft);
        }
        return dp[row][col];
    }
}