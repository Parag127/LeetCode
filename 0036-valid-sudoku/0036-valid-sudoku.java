class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            
            for (int j = 0; j < board[0].length; j++) {
                
                if (board[i][j] != '.') {
                    
                    if (isValid(board, i, j, board[i][j]) == false) {
                        return false;
                    } 
                }
            }
        }
        return true;
    }

    static boolean isValid(char[][] board, int row, int col, char ch) {

        for (int i = 0; i < 9; i++) {

            if (i != col && board[row][i] == ch) {
                return false;
            }

            if (i != row && board[i][col] == ch) {
                return false;
            }

            int r = 3 * (row / 3) + i / 3;
            int c = 3 * (col / 3) + i % 3;
            if ((r != row || c != col) && board[r][c] == ch) {
                return false;
            } 
        }
        return true;
    }
}