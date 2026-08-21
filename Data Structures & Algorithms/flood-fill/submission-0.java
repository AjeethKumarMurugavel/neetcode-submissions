class Solution {
    boolean[][] visited;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        visited = new boolean[image.length][image[0].length];
        backTrack(image, sr, sc, image[sr][sc], color);
        return image;
    }

    public void backTrack(int[][] image, int sr, int sc, int currentCol, int color) {
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length){
            return;
        }
        if(visited[sr][sc]){
            return;
        }
        visited[sr][sc] = true;

        if(image[sr][sc] == currentCol) {
            image[sr][sc] = color;
            backTrack(image, sr, sc+1, currentCol, color);
            backTrack(image, sr, sc-1, currentCol, color);
            backTrack(image, sr+1, sc, currentCol, color);
            backTrack(image, sr-1, sc, currentCol, color);
        } 
    }
}