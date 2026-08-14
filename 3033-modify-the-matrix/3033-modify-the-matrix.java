class Solution {
    public int[][] modifiedMatrix(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] < 0) {
                    int max = Integer.MIN_VALUE;
                    for (int k = 0; k < n; k++){
                        if (arr[k][j] > max) {
                            max = arr[k][j];
                        }
                    }
                    arr[i][j] = max;
                }
            }
        }
        return arr;
    }
}