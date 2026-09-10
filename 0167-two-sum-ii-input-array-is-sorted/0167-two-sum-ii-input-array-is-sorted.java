class Solution {
    public int[] twoSum(int[] arr, int target) {
        int L = 0;
        int R = arr.length - 1;

        while (L < R) {
            if (arr[L] + arr[R] == target) {
                return new int[]{L + 1, R + 1};
            } else if (arr[L] + arr[R] > target) R--;
            else L++;
        }
        return new int[]{};
    }
}