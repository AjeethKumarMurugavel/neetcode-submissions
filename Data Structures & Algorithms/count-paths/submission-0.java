class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        return travel(dp, 0, 0);
    }

    public int travel(int[][] grid, int m, int n) {
        if(m == grid.length-1 && n == grid[0].length-1) {
            return 1;
        }
        if(m >= grid.length || n>= grid[0].length) {
            return 0;
        }
        if(grid[m][n] != -1) {
            return grid[m][n];
        }
        grid[m][n] = travel(grid, m, n+1) + travel(grid, m+1, n);
        return grid[m][n];
    }
}
