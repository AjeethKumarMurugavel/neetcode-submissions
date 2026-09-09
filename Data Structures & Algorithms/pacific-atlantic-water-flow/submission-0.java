class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for(int i=0; i<cols; i++) {
            canVisit(heights, pacific, 0, i, heights[0][i]);
            canVisit(heights, atlantic, rows-1, i, heights[rows-1][i]);
        }

        for(int i=0; i<rows; i++) {
            canVisit(heights, pacific, i, 0, heights[i][0]);
            canVisit(heights, atlantic, i, cols-1, heights[i][cols-1]);
        }

        List<List<Integer>> result = new ArrayList<>();


        for(int r=0; r<rows; r++) {
            for(int c=0; c < cols; c++) {
                if(pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    public void canVisit(int[][] heights, boolean[][] visited, int row, int col, int prevHeight) {
        if(row < 0 || row >= heights.length || col < 0 || col >= heights[0].length || prevHeight > heights[row][col] || visited[row][col]) {
            return;
        }
        visited[row][col] = true;

        canVisit(heights, visited, row+1, col, heights[row][col]);
        canVisit(heights, visited, row-1, col, heights[row][col]);
        canVisit(heights, visited, row, col+1, heights[row][col]);
        canVisit(heights, visited, row, col-1, heights[row][col]);

    }
}
