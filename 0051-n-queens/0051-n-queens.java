class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for (char[] i : board) {
            Arrays.fill(i, '.');
        }

        List<List<String>> ans = new ArrayList<>();

        int[] leftRow = new int[n];
        int[] leftUpperD = new int[2 * n - 1];
        int[] leftLowerD = new int[2 * n - 1];

        backtrack(0, board, ans, leftRow, leftUpperD, leftLowerD);
        return ans;
    }


    public void backtrack(int col, char[][] board, List<List<String>> ans, int[] leftRow, int[] leftUpperD, int[] leftLowerD) {
        int n = board.length;
        if (col == n) {
            ans.add(createBoard(board));
        }

        for (int row = 0; row < n; row++) {
            if (col < n && leftRow[row] == 0 && leftUpperD[row + col] == 0 && leftLowerD[row - col + n - 1] == 0) {
                
                board[row][col] = 'Q';
                leftRow[row] = 1;
                leftUpperD[row + col] = 1;
                leftLowerD[row - col + n - 1] = 1;

                backtrack(col + 1, board, ans, leftRow, leftUpperD, leftLowerD);

                board[row][col] = '.';
                leftRow[row] = 0;
                leftUpperD[row + col] = 0;
                leftLowerD[row - col + n - 1] = 0;
            }
        }
    }

    public List<String> createBoard(char[][] board) {
        List<String> list = new ArrayList<>();

        for (char[] row : board) {
            list.add(new String(row));
        }

        return list;
    }
}