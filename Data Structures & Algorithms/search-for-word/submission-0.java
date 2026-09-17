class Solution {
    boolean[][] visited;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        if(board.length == 0) {
            return false;
        }
        visited = new boolean[board.length][board[0].length];

        for(int row = 0; row < board.length; row++) {
            for(int col =0; col < board[0].length; col++) {
                if(board[row][col] == word.charAt(0)) {
                    if(backtrack(board, word, row, col, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word, int row, int col, int idx) {
        if(idx == word.length()) {
            return true;
        }
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }
        if(word.charAt(idx) != board[row][col]) {
            return false;
        }

        if(visited[row][col]) {
            return false;
        }

        visited[row][col] = true;
        for(int[] dir : directions) {
            if(backtrack(board, word, row+dir[0], col+dir[1], idx+1)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
}
