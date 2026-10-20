class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        int[] leftRow = new int[n];
        int[] leftUpperD = new int[2 * n + 1];
        int[] leftLowerD = new int[2 * n + 1];

        backtrack(0, board, ans, leftRow, leftUpperD, leftLowerD);
        return ans;
    }

    static void backtrack(int col, char[][] board, List<List<String>> ans, int[] leftRow, int[] leftUpperD, int[] leftLowerD) {
        int n = board.length;
        if (col == n) {
            ans.add(constructBoard(board));
            return;
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

    static List<String> constructBoard(char[][] board) {
        List<String> list = new ArrayList<>();

        for (char[] row : board) {
            list.add(new String(row));
        }

        return list;
    }
}