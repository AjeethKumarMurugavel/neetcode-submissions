class Solution {
    public boolean isValidSudoku(char[][] board) {
        int row = board.length;

        for(int i = 0; i < row;  i++) {
            for(int j = 0; j < row;  j++) {
                System.out.println(board[i][j]);
                if(board[i][j] == '.') {
                    continue;
                }
                if(!checkRow(i, j, board)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkRow(int x, int y, char[][] board) {
        int xMul = x/3;
        int yMul = y/3;
        for(int i=0; i < board.length; i++) {
            if(board[x][y] == board[x][i] && i != y) {
                return false;
            }
            if(board[x][y] == board[i][y] && i != x) {
                return false;
            }
            int xSqr = xMul*3 + i/3;
            int ySqr = yMul*3 + i%3;
            if(board[x][y] == board[xSqr][ySqr] && xSqr != x && ySqr != y) {
                return false;
            }
        }
        return true;
    }

}
