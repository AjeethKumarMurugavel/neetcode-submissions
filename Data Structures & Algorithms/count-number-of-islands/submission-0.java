class Solution {
    public int numIslands(char[][] grid) {
        int numberOfIslands = 0;

        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if(grid[row][col] != '0') {
                    numberOfIslands++;
                    sinkIsland(grid, row, col);
                }
            }
        }
        return numberOfIslands;
    }

    public void sinkIsland(char[][] grid, int row, int col) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }

        if(grid[row][col] != '1') {
            return;
        }

        grid[row][col] = '0';
        sinkIsland(grid, row+1, col);
        sinkIsland(grid, row-1, col);
        sinkIsland(grid, row, col+1);
        sinkIsland(grid, row, col-1);
    }
}
