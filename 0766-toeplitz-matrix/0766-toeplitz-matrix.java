class Solution {
    public boolean isToeplitzMatrix(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;


        for (int j = m - 1; j >= 0; j--) {
            
            int k = 0, i = j;
            
            while (k < n - 1 && i < m - 1) {
                if (arr[k][i] != arr[k + 1][i + 1]) {
                    return false;
                }
                k++;
                i++;
            }
        }
        
        
        for (int i = 1; i < n; i++) {
            int k = i, j = 0;
            
            while (k < n - 1 && j < m - 1) {
                if (arr[k][j] != arr[k + 1][j + 1]) {
                    return false;
                }
                k++;
                j++;
            }
        }
        return true;
    }
}