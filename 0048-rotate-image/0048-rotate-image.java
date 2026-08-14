class Solution {
    public void rotate(int[][] arr) {
        int n = arr.length;


           for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n  - 1 - i; j++) {
                int copy = arr[n - 1 - j][i];
                
                 arr[n - 1 - j][i] = arr[n - 1 - i][n - 1 - j];
               
                arr[n - 1 - i][n - 1 - j] = arr[j][n - 1 - i];
                
                arr[j][n - 1 - i] = arr[i][j];
                
                arr[i][j] = copy;
            }
        }
    }
}