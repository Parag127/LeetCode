class Solution {
    public int totalNQueens(int n) {
        int[] arr = new int[1];
        arr[0] = 0;
        
        char[][] board = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        int[] leftRow = new int[n];
        int[] leftUpperD = new int[2 * n - 1]; 
        int[] leftLowerD = new int[2 * n - 1];

        backtrack(0, board, arr, leftRow, leftUpperD, leftLowerD);
        return arr[0]; 
    }

    static void backtrack(int col, char[][] board, int[] arr, int[] leftRow, int[] leftUpperD, int[] leftLowerD) {
        int n = board.length;

        if (col == n) {
            arr[0] += 1;
            return;
        }

        for (int row = 0; row < n; row++) {
            if (col < n && leftRow[row] == 0 && leftUpperD[row + col] == 0 && leftLowerD[row - col + n - 1] == 0) {

                board[row][col] = 'Q';
                leftRow[row] = 1;
                leftUpperD[row + col] = 1;
                leftLowerD[row - col + n - 1] = 1;

                backtrack(col + 1, board, arr, leftRow, leftUpperD, leftLowerD);

                board[row][col] = '.';
                leftRow[row] = 0;
                leftUpperD[row + col] = 0;
                leftLowerD[row - col + n - 1] = 0;
            }
        }
    }
}