class Solution {
    public int[] findDegrees(int[][] matrix) {
        int n = matrix.length;

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int ans = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) ans++;
            }
            arr[i] = ans;
        }
        return arr;
    }
}