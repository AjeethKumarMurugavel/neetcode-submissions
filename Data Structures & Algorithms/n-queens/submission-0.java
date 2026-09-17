class Solution {
    List<List<String>> sol = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        fillBoard(board, 0);
        return sol;
    }

    public void fillBoard(int[][] board, int idx) {
        if(idx == board.length) {
            sol.add(convertBoardToList(board));
            return;
        }
        for(int i=0; i<board.length; i++) {
            if(canPlace(new int[]{idx, i}, board)) {
                board[idx][i] = 1;
                fillBoard(board, idx+1);
                board[idx][i] = 0;
            }
        }
    }

    public List<String> convertBoardToList(int[][] board) {
        List<String> res = new ArrayList<>();
        for(int i=0; i<board.length; i++) {
            StringBuilder strB = new StringBuilder();
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == 0) {
                    strB.append(".");
                } else {
                    strB.append("Q");
                }
            }
            res.add(strB.toString());
        }
        return res;
    }

    public boolean canPlace(int[] pos, int[][] board) {
        int x = pos[0];
        int y = pos[1];

        for(int i=x-1; i>=0; i--) {
            if(board[i][y] == 1) {
                return false;
            }
            if(((y-x+i) >= 0) && board[i][y-x+i] != 0) {
                return false;
            }
            if((y+x-i) < board.length && board[i][y+x-i] != 0) {
                return false;
            }
        }
        return true;
    }
}
